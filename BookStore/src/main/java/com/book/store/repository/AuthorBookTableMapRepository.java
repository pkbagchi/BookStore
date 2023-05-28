package com.book.store.repository;


import com.book.store.model.AuthorBookTableMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorBookTableMapRepository extends JpaRepository<AuthorBookTableMap, Long> {
    List<AuthorBookTableMap> getAllByBookId(Long bookId);
}
