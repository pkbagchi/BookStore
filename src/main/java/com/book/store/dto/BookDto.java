package com.book.store.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class BookDto {
    public Long id;
    @NotNull(message = "*Please enter book title")
    @NotBlank(message = "*Please enter book title")
    public String title;

    @NotNull(message = "*Please enter book tag")
    @NotBlank(message = "*Please enter book tag")
    public String tag;

    @NotNull(message = "*Please enter isbn")
    @NotBlank(message = "*Please enter isbn")
    public String isbn;

    @NotNull(message = "*Please enter price")
    @NotBlank(message = "*Please enter price")
    public String price;

    @NotNull(message = "*Please enter publication ")
    @NotBlank(message = "*Please enter publication ")
    public String publicationYear;

    @NotNull(message = "*Please select category")
    public String category;

    List<AuthorDto> authorDtoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<AuthorDto> getAuthorDtoList() {
        return authorDtoList;
    }

    public void setAuthorDtoList(List<AuthorDto> authorDtoList) {
        this.authorDtoList = authorDtoList;
    }
}
