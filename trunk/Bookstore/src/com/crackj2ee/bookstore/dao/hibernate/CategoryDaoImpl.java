package com.crackj2ee.bookstore.dao.hibernate;

import java.io.Serializable;
import java.util.*;

import com.crackj2ee.bookstore.dao.CategoryDao;
import com.crackj2ee.bookstore.domain.Category;
import com.crackj2ee.bookstore.exception.ApplicationException;
import com.crackj2ee.bookstore.util.BeanUtil;

/**
 * Implementation of CategoryDao.
 * 
 * @author xuefeng
 * 
 * @spring.bean id="categoryDao"
 */
public class CategoryDaoImpl extends GenericHibernateDaoSupportImpl<Category> implements CategoryDao {

    private static final int[] INCREMENT = {
        0x010000,
        0x000100,
        0x000001
    };

    private Category ROOT_CATEGORY = null;

    private Map<Integer, Category> categories = new HashMap<Integer, Category>();

    public CategoryDaoImpl() {
        super(Category.class);
    }

    @SuppressWarnings("unchecked")
    public synchronized Category queryRoot() {
        if(ROOT_CATEGORY==null) {
            ROOT_CATEGORY = new Category();
            ROOT_CATEGORY.setId(new Integer(Category.ROOT_ID));
            ROOT_CATEGORY.setName("所有书籍");
            // cache root:
            categories.put(ROOT_CATEGORY.getId(), ROOT_CATEGORY);
            log.info("Load category: " + ROOT_CATEGORY);
            // load all categories:
            List<Category> list = hibernateTemplate.find("from Category as c order by c.id");
            for(Category c : list) {
                if(ROOT_CATEGORY.add(c)) {
                    categories.put(c.getId(), c);
                    log.info("Load category: " + c);
                }
                else {
                    log.warn("Load invalid category: " + c);
                    hibernateTemplate.delete(c);
                }
            }
            ROOT_CATEGORY.debug();
        }
        return ROOT_CATEGORY;
    }

    @Override
    public synchronized Category query(Serializable id) {
        Category c = categories.get(id);
        if(c==null)
            throw new ApplicationException("Not found.");
        return c;
    }

    @Override
    public void create(Category c) {
        throw new UnsupportedOperationException("Using create(Category, Integer) instead.");
    }

    public synchronized void create(Category category, Integer pId) {
        Integer parentId = pId;
        log.info("Try to create new category under: " + Integer.toHexString(parentId.intValue()));
        Category parent = query(parentId);
        // get next available child id:
        if(parent.isLeaf())
            throw new ApplicationException("Cannot create under leaf.");
        List<Category> list = parent.getChildren();
        if(list.size()==0xffff)
            throw new ApplicationException("Children is full.");
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(Category c : list) {
            map.put(c.getId(), Boolean.TRUE);
        }
        int id = 0;
        int increment = INCREMENT[parent.getLevel()];
        for(int i=parent.getId().intValue()+increment; i<=parent.getId().intValue()+increment*0xff; i+=increment) {
            log.info("Testing id: " + Integer.toHexString(i));
            if(map.get(new Integer(i))==null) {
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

    @Override
    public synchronized void delete(Category category) {
        Category c = query(category.getId());
        if(c.isRoot())
            throw new IllegalArgumentException("Cannot delete root.");
        if(c.getChildren().size()>0)
            throw new IllegalArgumentException("Not Empty.");
        // delete from database:
        hibernateTemplate.delete(c);
        // delete from cache:
        categories.remove(c.getId());
        ROOT_CATEGORY.remove(c);
    }

    @Override
    public synchronized void update(Category category) {
        Category c = query(category.getId());
        BeanUtil.copyProperties(category, c);
        hibernateTemplate.update(c);
    }
}
