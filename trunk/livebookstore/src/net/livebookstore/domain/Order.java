package net.livebookstore.domain;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.*;

/**
 * An Order belongs to an Account and has 1:N relationship with OrderItem.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_order")
public class Order extends UUIDSupport {

    public boolean canCancel() {
        return state<=STATE_WATING_FOR_HANDLE;
    }

    public static final int STATE_WAITING_FOR_PAY = 0;
    public static final int STATE_WATING_FOR_HANDLE = 1;
    public static final int STATE_PREPARE = 2;
    public static final int STATE_DELIVER = 3;
    public static final int STATE_COMPLETE = 4;
    public static final int STATE_CANCELLED = 5;
    private static final String[] STATES = {
        "等待付款", "等待处理", "正在配货", "正在发送", "处理完毕", "已经取消"
    };

    public static final int DELIVER_HOME = 0;
    public static final int DELIVER_POST = 1;
    public static final int DELIVER_EMS = 2;

    private static final String[] DELIVERS = {
        "送货上门", "普通平邮", "EMS快递"
    };

    public static final int PAYMENT_FACE_TO_FACE = 0;
    public static final int PAYMENT_ONLINE = 1;
    public static final int PAYMENT_REMIT = 2;

    private static final String[] PAYMENTS = {
        "货到付款", "在线支付", "邮局汇款"
    };

    private Account account; // FK
    private List<OrderItem> orderItems;

    // default value should be copied from Account:
    private String address;
    private String zip;
    private String name;
    private String telephone;
    private String mobile;

    private Date createdDate;
    private int deliver;
    private int payment;
    private int state;

    @ManyToOne
    @JoinColumn(nullable=false, updatable=false)
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    @OneToMany(targetEntity=OrderItem.class, mappedBy="order")
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    @Column(nullable=false, updatable=false)
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Transient
    public String getCreatedDateAsString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(createdDate);
    }

    @Column(nullable=false)
    @Range(min=0, max=2)
    public int getDeliver() { return deliver; }
    public void setDeliver(int deliver) { this.deliver = deliver; }

    @Transient
    public String getDeliverAsString() { return DELIVERS[deliver]; }

    @Column(nullable=false)
    @Range(min=0, max=2)
    public int getPayment() { return payment; }
    public void setPayment(int payment) { this.payment = payment; }

    @Transient
    public String getPaymentAsString() { return PAYMENTS[payment]; }

    @Column(nullable=false)
    @Range(min=0, max=5)
    public int getState() { return state; }
    public void setState(int state) { this.state = state; }

    @Transient
    public String getStateAsString() { return STATES[state]; }

    @Column(nullable=false, length=200)
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Column(nullable=false, length=20)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(nullable=true, length=10)
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    @Column(nullable=true, length=20)
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Column(nullable=true, length=20)
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

}
