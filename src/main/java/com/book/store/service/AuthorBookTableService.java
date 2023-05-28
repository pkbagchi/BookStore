package com.book.store.service;

import com.book.store.model.Author;
import com.book.store.model.AuthorBookTableMap;
import com.book.store.model.Book;
import com.book.store.repository.AuthorBookTableMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorBookTableService {
    @Autowired
    AuthorBookTableMapRepository authorBookTableMapRepository;

    public void deleteAll(Book book) {
        List<AuthorBookTableMap> authorBookTableMapList = authorBookTableMapRepository.getAllByBookId(book.getId());
        for(AuthorBookTableMap authorBookTableMap : authorBookTableMapList) {
            for(Author author : book.getAuthor()) {
                if(authorBookTableMap.getAuthorId() != author.getId()) {
                    authorBookTableMapRepository.delete(authorBookTableMap);
                }
            }
        }
    }
    public void saveAll(Book book, Book saveBook) {
        List<AuthorBookTableMap> authorBookTableMapList = new ArrayList<>();
        for(Author author : book.getAuthor()) {
            AuthorBookTableMap authorBookTableMap = new AuthorBookTableMap();
            authorBookTableMap.setAuthorId(author.getId());
            authorBookTableMap.setBookId(saveBook.getId());
            authorBookTableMapList.add(authorBookTableMap);
        }
        authorBookTableMapRepository.saveAll(authorBookTableMapList);
    }
}
