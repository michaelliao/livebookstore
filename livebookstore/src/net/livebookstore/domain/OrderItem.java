package net.livebookstore.domain;

import javax.persistence.*;

/**
 * OrderItem is belong to an order.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_orderitem")
public class OrderItem extends UUIDSupport {

    private Order order; // FK, belong to which order.
    private Book book;   // FK, ordered book
    private int number;  // how many books

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable=false, updatable=false)
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    @Column(nullable=false)
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

}
