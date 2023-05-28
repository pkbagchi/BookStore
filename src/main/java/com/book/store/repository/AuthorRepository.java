package com.book.store.repository;

import java.util.List;

import com.book.store.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();
	/*Long countByType(String type);*/
}
