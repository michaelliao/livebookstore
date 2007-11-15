package example.chapter6;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Book")
public class Book {

    private String id;
    private String name;
    private String author;

    @Id
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

}
