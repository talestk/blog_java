/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author talestk
 */

@Entity

public class BlogEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    
    private Long id;
    
    @NotNull
    @Size(min = 10, max = 100)
    private String title;
    
    @Lob
    @NotNull
    @Size(min = 300, max = 4000)
    private String content;
    
    @NotNull
    @Size(min = 10, max = 40)
    private String author;
    
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();
    
    @PrePersist
    private void onCreate() {
        created = new Date();
    }
    
    // @param id (id to set)
    public void setId(Long id) {
        this.id = id;
    }
    
    // @return the title
    public String getTitle() {
        return title;
    }
    
    // @param title
    public void setTitle(String title) {
        this.title = title;
    }
    
    // @return the content
    public String getContent() {
        return content;
    }
    
    // @param content (the content to set)
    public void setContent(String content) {
        this.content = content;
    }
    
    // @return the author
    public String getAuthor() {
        return author;
    }
    
    // @param author (the author to set)
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // @ return the created
    public Date getCreated() {
        return created;
    }
    
    // @param created
    public void setCreated(Date created) {
        this.created = created;
    }
    
    // @return the id
    public Long getId() {
        return id;
    }
}
