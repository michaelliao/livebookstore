package com.crackj2ee.bookstore.domain;

import java.util.*;

import javax.persistence.*;

import org.compass.annotations.SearchableId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * An Order belongs to an Account and has 1:N relationship with OrderItem.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_order")
public class Order {

    public static final int STATE_NOT_PROCESS  = 0; // not process yet
    public static final int STATE_IN_PROCESS   = 1; // in process now
    public static final int STATE_PROCESS_DONE = 2; // process done
    public static final int STATE_CANCELLED    = 3; // order is cancelled

    public static final int PAY_FACE_TO_FACE = 0;
    public static final int PAY_ONLINE_BANK  = 1;
    public static final int PAY_POST_REMIT   = 2;

    private Account account; // FK
    private List<OrderItem> orderItems;

    // default value should be copied from Account:
    private String address;
    private String zip;
    private String name;
    private String telephone;
    private String mobile;

    private Date createdDate;
    private int payment;
    private int state;

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

    @OneToMany
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    @Column(nullable=false)
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Column(nullable=false)
    public int getPayment() { return payment; }
    public void setPayment(int payment) { this.payment = payment; }

    @Column(nullable=false)
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }

    @Column(nullable=false, length=200)
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Column(nullable=false, length=20)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(nullable=false, length=10)
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    @Column(nullable=true, length=20)
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Column(nullable=true, length=20)
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

}
