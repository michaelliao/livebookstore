package net.livebookstore.dao.hibernate;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.locks.*;

import net.livebookstore.domain.Category;

import net.livebookstore.dao.CategoryDao;
import net.livebookstore.exception.ApplicationException;
import net.livebookstore.util.BeanUtil;

/**
 * Implementation of CategoryDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="categoryDao" init-method="init"
 */
public class CategoryDaoImpl extends GenericHibernateDao<Category> implements CategoryDao {

    private final ReadWriteLock wrLock = new ReentrantReadWriteLock();
    private final Lock readLock = wrLock.readLock();
    private final Lock writeLock = wrLock.writeLock();

    private static final int[] INCREMENT = {
        0x010000,
        0x000100,
        0x000001
    };

    private final Category root;

    private Map<Integer, Category> categories = null;

    public CategoryDaoImpl() {
        super(Category.class);
        root = new Category();
        root.setId(new Integer(Category.ROOT_ID));
        root.setName("所有书籍");
    }

    public void init() {
        writeLock.lock();
        try {
            // cache root:
            categories = new HashMap<Integer, Category>();
            categories.put(root.getId(), root);
            log.info("Load category: " + root);
            // load all categories:
            List<Category> list = hibernateTemplate.find("from Category as c order by c.id");
            for(Category c : list) {
                if(root.add(c)) {
                    categories.put(c.getId(), c);
                    log.info("Load category: " + c);
                }
                else {
                    log.warn("Load invalid category: " + c);
                    hibernateTemplate.delete(c);
                }
            }
            root.debug();
        }
        finally {
            writeLock.unlock();
        }
    }

    public Category queryRoot() {
        return root;
    }

    @Override
    public Category query(Serializable id) {
        readLock.lock();
        try {
            Category c = categories.get(id);
            if(c==null)
                throw new ApplicationException("Not found.");
            return c;
        }
        finally {
            readLock.unlock();
        }
    }

    @Override
    public void create(Category c) {
        throw new UnsupportedOperationException("Using create(Category, Integer) instead.");
    }

    public void create(Category category, Integer pId) {
        Integer parentId = pId;
        log.info("Try to create new category under: " + Integer.toHexString(parentId.intValue()));
        Category parent = query(parentId);
        writeLock.lock();
        try {
            // get next available child id:
            if(parent.isLeaf())
                throw new ApplicationException("Cannot create under leaf.");
            List<Category> list = parent.getChildren();
            if(list.size()==0xffff)
                throw new ApplicationException("Children is full.");
            Set<Integer> set = new HashSet<Integer>();
            for(Category c : list) {
                set.add(c.getId());
            }
            int id = 0;
            int increment = INCREMENT[parent.getLevel()];
            for(int i=parent.getId().intValue()+increment; i<=parent.getId().intValue()+increment*0xff; i+=increment) {
                log.info("Testing id: " + Integer.toHexString(i));
                if(!set.contains(new Integer(i))) {
                    // found an unused id:
                    id = i;
                    break;
                }
            }
            // create category:
            category.setId(new Integer(id));
            hibernateTemplate.save(category);
            // cache it:
            categories.put(category.getId(), category);
            parent.add(category);
            log.info("New category created: " + category);
        }
        finally {
            writeLock.unlock();
        }
    }

    @Override
    public void delete(Category category) {
        Category c = query(category.getId());
        writeLock.lock();
        try {
            if(c.isRoot())
                throw new IllegalArgumentException("Cannot delete root.");
            if(c.getChildren().size()>0)
                throw new IllegalArgumentException("Not Empty.");
            // delete from database:
            hibernateTemplate.delete(c);
            // delete from cache:
            categories.remove(c.getId());
            root.remove(c);
        }
        finally {
            writeLock.unlock();
        }
    }

    @Override
    public void update(Category category) {
        writeLock.lock();
        try {
            Category c = query(category.getId());
            BeanUtil.copyProperties(category, c);
            hibernateTemplate.update(c);
        }
        finally {
            writeLock.unlock();
        }
    }
}
