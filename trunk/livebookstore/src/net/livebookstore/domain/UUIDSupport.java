package net.livebookstore.domain;

import javax.persistence.*;

import org.compass.annotations.SearchableId;
import org.hibernate.annotations.GenericGenerator;

/**
 * UUID primary key.
 * 
 * @author Liao Xuefeng
 */
@MappedSuperclass
public abstract class UUIDSupport {

    protected String id;

    @SearchableId
    @Id
    @Column(nullable=false, updatable=false, length=32)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

}
