package net.livebookstore.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * Store user's favorite books.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_fav_book")
public class FavoriteBook extends UUIDSupport {

    private Account account;
    private Book book;
    private Date createdDate;

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    @Column(nullable=false, updatable=false)
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

}
