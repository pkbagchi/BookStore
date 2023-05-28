package com.book.store.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUTHOR_BOOK_TABLE_MAP")
public class AuthorBookTableMap implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "AUTHOR_ID")
    private Long authorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
