package com.crackj2ee.bookstore.domain;

import javax.persistence.*;

import org.compass.annotations.SearchableId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * OrderItem is belong to an order.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_orderItem")
public class OrderItem {

    private Order order; // FK, belong to which order.
    private Book book;   // FK, ordered book
    private int number;  // how many books

    private String id;

    @SearchableId
    @Id
    @Column(nullable=false, length=36)
    @GenericGenerator(name="uuid", strategy="uuid.hex")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    @ManyToOne
    @OnDelete(action=OnDeleteAction.NO_ACTION)
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    @Column(nullable=false)
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

}
