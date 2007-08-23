package net.livebookstore.domain;

import java.util.*;

import javax.persistence.*;

import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.GenericGenerator;

/**
 * Category that has tree structure.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_category")
public class Category {

    public static final int ROOT_ID = 0x01000000;

    private static final int[] MASK = {
        0xFF000000,
        0xFFFF0000,
        0xFFFFFF00,
        0xFFFFFFFF
    };

    private Integer id; // PK
    private String name;
    private int categoryOrder;
    private int mask;
    private int level;
    private int parentId = 0; // parentId;
    private List<Category> children = new ArrayList<Category>();

    /**
     * Primary key of id. We use Integer instead of Long because there are some 
     * problems if using Long on HSQLDB.
     */
    @Id
    @GeneratedValue(generator="assigned")
    @GenericGenerator(name="assigned", strategy="assigned")
    public Integer getId() { return id; }

    // set object's id also set mask & parent's id:
    public void setId(Integer id) {
        this.id = id;
        for(int i=0; i<MASK.length; i++) {
            if((MASK[i] & id.intValue())==id.intValue()) {
                this.mask = MASK[i];
                this.level = i;
                if(i>0)
                    this.parentId = id.intValue() & MASK[i-1];
                break;
            }
        }
    }

    @Column(nullable=false)
    public int getCategoryOrder() { return categoryOrder; }
    public void setCategoryOrder(int categoryOrder) { this.categoryOrder = categoryOrder; };

    @Transient
    public int getParentId() { return parentId; }

    @Transient
    public int getLevel() { return level; }

    @Transient
    public List<Category> getChildren() { return children; }
    public void setChildren(List<Category> children) {
        this.children = children;
    }

    @Column(nullable=false, length=20)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Transient
    public int getMask() { return mask; }

    @Transient
    public boolean isRoot() { return level==0; }

    @Transient
    public boolean isLeaf() { return level==3; }

    public synchronized boolean add(Category child) {
        if(this.level>=child.level)
            return false;
        if((child.level - this.level) == 1) {
            if((child.id.intValue() & mask) == this.id.intValue()) {
                // direct child:
                LogFactory.getLog(Category.class).info("add child " + child + " into " + this);
                this.children.add(child);
                return true;
            }
            return false;
        }
        for(Category c : children) {
            if(c.add(child))
                return true;
        }
        return false;
    }

    public synchronized boolean remove(Category child) {
        for(Category c : children) {
            if(c.getId().intValue()==child.getId().intValue()) {
                children.remove(c);
                return true;
            }
            if(c.remove(child)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "[" + Integer.toHexString(id.intValue()) + ", " + level  + "] " + name;
    }

    public void debug() {
        String s = "";
        for(int i=0; i<getLevel(); i++) {
            s = s + " ";
        }
        LogFactory.getLog(Category.class).info(s + "[" + Integer.toHexString(id.intValue()) + ", " + Integer.toHexString(getMask())  + "] " + name);
        for(Category c : children)
            c.debug();
    }

}
