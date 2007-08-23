package net.livebookstore.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.*;

/**
 * Represent a User.
 * 
 * @author xuefeng
 */
@Entity
@Table(name="t_account")
public class Account {

    public static final int PRIVILEGE_USER = 0;
    public static final int PRIVILEGE_ADMIN = 0xff;

    private String username;
    private String password;
    private String email;
    private int privilege;
    private Date createdDate;

    // contact information:
    private String address;
    private String zip;
    private String name;
    private String telephone;
    private String mobile;

    public Account() {}

    public Account(String username, String password, int privilege) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    public Account(String username, String password, String email, int privilege, Date createdDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.privilege = privilege;
        this.createdDate = createdDate;
    }

    @Id
    @Column(updatable=false, nullable=false, length=20)
    @Pattern(regex="[a-z0-9]{3,20}", message="用户名只能由英文字母和数字构成，长度为3-20个字符")
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Column(nullable=false, length=32)
    @Pattern(regex="[0-9a-f]{32}", message="无效的口令")
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Column(nullable=true, length=50)
    @Email(message="无效的Email地址（示例：xyz@abc.com）")
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column(nullable=false)
    public int getPrivilege() { return privilege; }
    public void setPrivilege(int privilege) { this.privilege = privilege; }

    @Column(nullable=false, updatable=false)
    public Date getCreatedDate() { return createdDate; }
    public void setCreatedDate(Date createdDate) { this.createdDate = createdDate; }

    @Transient
    public String getCreatedDateAsString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(createdDate);
    }

    @Column(nullable=true, length=200)
    @Length(max=100, message="地址长度请限制在100字以内")
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Column(nullable=true, length=20)
    @Length(max=10, message="名字长度请限制在10字以内")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(nullable=true, length=10)
    @Pattern(regex="[0-9]{6}", message="邮政编码应该为6个数字")
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    @Column(nullable=true, length=20)
    @Pattern(regex="[0-9\\-\\(\\) ]{6,20}", message="错误的电话号码（示例：010-12345678）")
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    @Column(nullable=true, length=20)
    @Pattern(regex="[0-9]{11,17}", message="错误的手机号码（示例：13500000001）")
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    /**
     * Display name will return name if name is not empty, otherwise username.
     */
    @Transient
    public String getDisplayName() {
        if(name==null || "".equals(name.trim()))
            return username;
        return name;
    }
}
