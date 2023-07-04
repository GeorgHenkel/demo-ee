package org.jnosql.example.domain;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;
import jakarta.validation.constraints.Min;
import org.jnosql.example.domain.validation.ValidIsbn;

import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    private String id;

    @Column
    private String title;

    @ValidIsbn
    @Min(13)
    @Column("isbn")
    private String isbn;

    @Column
    private Date published;

    @Column
    private String edition;

    @Column
    private List<Author> authors;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
