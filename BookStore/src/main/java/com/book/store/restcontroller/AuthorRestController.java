package com.book.store.restcontroller;

import java.util.List;

import com.book.store.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.service.AuthorService;

@RestController
@RequestMapping(value = "/rest/author")
public class AuthorRestController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping(value = {"/", "/list"})
	public List<Author> all() {
		return authorService.getAll();
	}
}
