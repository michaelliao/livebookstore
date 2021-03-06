package net.livebookstore.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/**
 * Book object.
 * 
 * @author xuefeng
 */
@Searchable
@Entity
@Table(name="t_book")
public class Book extends UUIDSupport {

    public static final String[] STATES = {"正常销售", "即将上市", "停止出售" };
    public static final int STATE_SELLING     = 0;
    public static final int STATE_COMING_SOON = 1;
    public static final int STATE_SHUTDOWN    = 2;

    private String name;
    private String originalName;
    private int categoryId = Category.ROOT_ID;

    private String author;
    private String publisher;

    private String language;

    private float price;
    private int discount; // 1-100, default 100(no discount).

    private String isbn;
    private Date pubDate;

    private String description;

    private int state;
    private int stock;
    private int sold;

    private int rating;    // sum of all rating
    private int ratingCount; // how many user rate this book

    // default constructor:
    public Book() {}

    public Book(String id, String name, float price, int discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    @Column(nullable=false)
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    @SearchableProperty(boost=2.0f)
    @Column(nullable=false, length=50)
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Column(nullable=false, length=50)
    @SearchableProperty(index=Index.UN_TOKENIZED, store=Store.YES)
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    @SearchableProperty(boost=5.0f)
    @Column(nullable=false, length=50)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @SearchableProperty(boost=4.0f)
    @Column(nullable=true, length=50)
    public String getOriginalName() { return originalName; }
    public void setOriginalName(String originalName) { this.originalName = originalName; }

    @SearchableProperty
    @Column(nullable=false, length=2000)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @SearchableProperty(index=Index.NO, store=Store.YES)
    @Column(nullable=false)
    public int getDiscount() { return discount; }
    public void setDiscount(int discount) { this.discount = discount; }

    @Transient
    public String getDiscountAsString() {
        return discount==100 ? "无" : String.valueOf(discount);
    }

    @Column(nullable=false, length=50)
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @SearchableProperty(index=Index.NO, store=Store.YES)
    @Column(nullable=false, length=10)
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    @SearchableProperty(converter="date", index=Index.NO, store=Store.YES)
    @Column(nullable=false, columnDefinition="DATE")
    @org.hibernate.annotations.Index(name="INX_PUBDATE")
    public Date getPubDate() { return pubDate; }
    public void setPubDate(Date pubDate) { this.pubDate = pubDate; }

    @Transient
    public String getPubDateAsString() {
        return new SimpleDateFormat("yyyy-MM-dd").format(pubDate);
    }

    @Column(nullable=false)
    @SearchableProperty(index=Index.NO, store=Store.YES)
    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    @Transient
    public String getDiscountPrice() {
        return String.valueOf((int)(price * discount) / 100.0f );
    }

    @Transient
    public String getSavedPrice() {
        return String.valueOf((int)(price * (100-discount)) / 100.0f);
    }

    @Column(nullable=false)
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    @Column(nullable=false)
    public int getRatingCount() { return ratingCount; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }

    @Transient
    public int getRatingLevel() {
        if(ratingCount==0)
            return 0;
        return (int)(10 * ((float)rating / ratingCount + 0.05f) * 2) / 10;
    }

    @Column(nullable=false)
    public int getSold() { return sold; }
    public void setSold(int sold) { this.sold = sold; }

    @Column(nullable=false)
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }

    @Transient
    public String getStateAsString() { return STATES[state]; }

    @Column(nullable=false)
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Transient
    public String getImage() {
        int hash = getId().hashCode();
        int dir1 = (hash & 0xf0) >>> 4;
        int dir2 = hash & 0xf;
        return dir1 + "/" + dir2 + "/" + getId() + ".jpg";
    }

}
