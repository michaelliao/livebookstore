package example.chapter5;

import javax.persistence.*;

import org.hibernate.validator.Pattern;

/**
 * Entity object mapping to Book table.
 * 
 * @author Xuefeng
 */
@Entity(name="Book")
@Table(name="Book")
public class Book {

    private String id;
    private String name;
    private String author;

    @Id
    @Pattern(regex="[a-z0-9\\-]{36}", message="ID只能由英文字母,数字和-构成,长度为36个字符")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

}
