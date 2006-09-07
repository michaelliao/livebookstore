package com.crackj2ee.bookstore.domain;

import javax.persistence.*;

import org.compass.annotations.SearchableId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Comment that user makes on a book.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_comment")
public class Comment {

    private Book book;
    private Account account;
    private int rating;
    private String content;

    private String id;

    @SearchableId
    @Id
    @Column(nullable=false, updatable=false, length=36)
    @GenericGenerator(name="uuid", strategy="uuid.hex")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    @Column(nullable=false)
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    @Column(nullable=false, length=2000)
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

}
