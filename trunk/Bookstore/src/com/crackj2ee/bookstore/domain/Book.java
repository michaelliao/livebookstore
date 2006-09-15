package com.crackj2ee.bookstore.domain;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.compass.annotations.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * Book object.
 * 
 * @author xuefeng
 */
@Searchable
@Entity
@Table(name="t_book")
public class Book {

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

    private float rating;    // average rating
    private int ratingCount; // how many user rate this book

    private String id;

    @SearchableId
    @Id
    @Column(nullable=false, length=36)
    @GenericGenerator(name="uuid", strategy="uuid.hex")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Column(nullable=false)
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    @SearchableProperty
    @Column(nullable=false, length=50)
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Column(nullable=false, length=50)
    @SearchableProperty(index=Index.UN_TOKENIZED, store=Store.YES)
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    @SearchableProperty(boost=2)
    @Column(nullable=false, length=50)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @SearchableProperty(boost=2)
    @Column(nullable=true, length=50)
    public String getOriginalName() { return originalName; }
    public void setOriginalName(String originalName) { this.originalName = originalName; }

    @SearchableProperty
    @Column(nullable=false, length=200)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

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

    @Column(nullable=false, length=10)
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    @SearchableProperty(converter="date", index=Index.NO)
    @Column(nullable=false, columnDefinition="DATE")
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
    @SearchableProperty(index=Index.NO, store=Store.YES)
    public String getDiscountPrice() {
        return String.valueOf((int)(price * discount) / 100.0f );
    }

    @Transient
    public String getSavedPrice() {
        return String.valueOf((int)(price * (100-discount)) / 100.0f);
    }

    @Column(nullable=false)
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    @Column(nullable=false)
    public int getRatingCount() { return ratingCount; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }

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
