package com.crackj2ee.bookstore.domain;

import javax.persistence.*;

import org.compass.annotations.SearchableId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Store user's favorite books.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_fav_book")
public class FavoriteBook {

    private Account account;
    private Book book;

    private String id;

    @SearchableId
    @Id
    @Column(nullable=false, length=36)
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

}
