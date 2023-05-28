package com.book.store.controller;

import javax.validation.Valid;


import com.book.store.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.book.store.service.AuthorService;

import java.util.List;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {


	private AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@RequestMapping(value = {"/", "/list"},  method = RequestMethod.GET)
	public String showAuthorPage(Model model) {

		List<Author> author = authorService.getAll();

		model.addAttribute("author", author);
		model.addAttribute("check", "Hello man");
		return "/author/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAuthorPage(Model model) {
		model.addAttribute("author", new Author());
		return "/author/form";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editAuthorPage(@PathVariable(name = "id") Long id, Model model) {
		Author author = authorService.get( id );
		if( author != null ) {
			model.addAttribute("author", author);
			return "/author/form";
		} else {
			return "redirect:/author/add";
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String saveAuthor(@Valid Author author, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if( bindingResult.hasErrors() ) {
			return "/author/form";
		}
		
		if( author.getId() == null ) {
			authorService.addNew(author);
			redirectAttributes.addFlashAttribute("successMsg", "'" + author.getFirstName()+" "+author.getMiddleName() + "' is added as a new Author.");
			return "redirect:/author/add";
		} else {
			Author updatedAuthor = authorService.updateAuthor( author );
			redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + author.getFirstName()+" "+author.getMiddleName() + "' are saved successfully. ");
			return "redirect:/author/edit/" + updatedAuthor.getId();
		}
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeAuthor(@PathVariable(name = "id") Long id, Model model) {
		Author author = authorService.get( id );
		if( author != null ) {
			if( authorService.hasUsage(author) ) {
				model.addAttribute("authorInUse", true);
				return showAuthorPage(model);
			} else {
				authorService.delete(id);
			}
		}
		return "redirect:/author/list";
	}
	
	
	
	
}
