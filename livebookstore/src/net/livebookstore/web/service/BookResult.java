package net.livebookstore.web.service;

import java.util.Date;

/**
 * A "compact" Book object, holds one book's information.
 * 
 * @author Xuefeng
 */
public class BookResult {

    private String id;
    private String name;
    private String originalName;
    private String author;
    private String language;
    private Date pubDate;
    private String image;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOriginalName() { return originalName; }
    public void setOriginalName(String originalName) { this.originalName = originalName; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public Date getPubDate() { return pubDate; }
    public void setPubDate(Date pubDate) { this.pubDate = pubDate; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
