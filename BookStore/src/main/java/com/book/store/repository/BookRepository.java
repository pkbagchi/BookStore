package com.book.store.repository;

import java.util.List;

import com.book.store.model.Author;
import com.book.store.model.Book;
import com.book.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByTag(String tag);
	List<Book> findByCategory(Category category);
	/*List<Book> findByCategoryAndStatus(Category category, Integer status);*/

	/*List<Book> findByAuthors(Author author);*/
	List<Book> findAllByOrderByCreatedByDesc();
}
