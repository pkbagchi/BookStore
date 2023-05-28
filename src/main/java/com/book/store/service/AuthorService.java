package com.book.store.service;

import com.book.store.common.Utils;
import com.book.store.model.Author;
import com.book.store.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookService bookService;
	

	public Long getTotalCount() {
		return authorRepository.count();
	}

	public List<Author> getAll() {
		return authorRepository.findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();

	}
	
	public Author get(Long id) {
		return authorRepository.findById(id).get();
	}
	
	public Author addNew(Author author) {
		author.setCreatedOn(new Date());
		author.setCreatedBy(Utils.getLoggedInUser());
		return authorRepository.save( author );
	}
	
	public Author updateAuthor(Author author) {
		Author previousAuthor = get(author.getId());
		author.setCreatedOn(previousAuthor.getCreatedOn());
		author.setCreatedBy(previousAuthor.getCreatedBy());
		author.setUpdatedOn(new Date());
		author.setUpdatedBy(Utils.getLoggedInUser());
		return authorRepository.save( author );
	}
	
	public void delete(Author author) {
		authorRepository.delete(author);
	}
	
	public void delete(Long id) {
		authorRepository.deleteById(id);
	}

	public boolean hasUsage(Author author) {

		if(bookService.getByAuthor(author).size()>0) {
			return true;
		}
		return false;
	}
}
