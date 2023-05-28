package com.book.store.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.book.store.common.Utils;
import com.book.store.model.Author;
import com.book.store.model.AuthorBookTableMap;
import com.book.store.repository.AuthorBookTableMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.common.Constants;
import com.book.store.model.Book;
import com.book.store.model.Category;
import com.book.store.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	AuthorService authorService;
	@Autowired
	AuthorBookTableService authorBookTableService;

	public Long getTotalCount() {
		return bookRepository.count();
	}

	
	public List<Book> getAll() {
		return bookRepository.findAllByOrderByCreatedByDesc();
	}
	
	public Book get(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public Book getByTag(String tag) {
		return bookRepository.findByTag(tag);
	}
	
	public List<Book> get(List<Long> ids) {
		return bookRepository.findAllById(ids);
	}
	
	public List<Book> getByCategory(Category category) {
		return bookRepository.findByCategory(category);
	}

	public List<Book> geAvailabletByCategory(Category category) {
		/*return bookRepository.findByCategoryAndStatus(category, Constants.BOOK_STATUS_AVAILABLE);*/
		return new ArrayList<>();
	}

	public List<Book> getByAuthor(Author author) {
		/*return bookRepository.findByAuthors(author);*/
		return new ArrayList<>();
	}

	public Book addNew(Book book) {
		book.setCreatedBy(Utils.getLoggedInUser());
		book.setCreatedOn(new Date());
		Book saveBook =  bookRepository.save(book);
		authorBookTableService.saveAll(book,saveBook);
		return book;
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		Book previousBook = get(book.getId());
		book.setCreatedOn(previousBook.getCreatedOn());
		book.setCreatedBy(previousBook.getCreatedBy());
		book.setUpdatedOn(new Date());
		book.setUpdatedBy(Utils.getLoggedInUser());
		authorBookTableService.deleteAll(book);
		return bookRepository.save(book);

	}
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}

	public boolean hasUsage(Book book) {
		/*return issuedBookService.getCountByBook(book)>0;*/
		return true;
	}

	public Book addBookPage() {
		List<Author> author = authorService.getAll();
		Book book = new Book();
		book.setAuthor(author);
		return book;
	}
}
