package net.livebookstore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;

import net.livebookstore.util.DateUtil;

/**
 * Comment that user makes on a book.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_comment")
public class Comment extends UUIDSupport {

    private Book book;
    private Account account;
    private int rating;
    private String content;
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
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    @Column(nullable=false, updatable=false, length=2000)
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Column(nullable=false, updatable=false)
    @Index(name="INX_CREATEDDATE")
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Transient
    public String getCreatedDateAsString() { return DateUtil.formatDateTime(createdDate); }
}
