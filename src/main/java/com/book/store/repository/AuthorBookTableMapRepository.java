package com.book.store.repository;


import com.book.store.model.AuthorBookTableMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorBookTableMapRepository extends JpaRepository<AuthorBookTableMap, Long> {
}
