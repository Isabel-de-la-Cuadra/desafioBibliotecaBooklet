package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Book;
import com.desafiolatam.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping("") //http://localhost:9080/book
	public String showEntry(@ModelAttribute("book") Book book) {
		return "/book.jsp";
	}
	
	@PostMapping("")
	public String register(@Valid @ModelAttribute("book") Book book, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		
		if(!result.hasErrors()) {
			bookService.save(book);
			redirectAttributes.addFlashAttribute("msgOk","Libro creado correctamente");
		}else {
			redirectAttributes.addFlashAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			return "/book.jsp";
		}
		
		return "redirect:/book";
	}
	
	
	@RequestMapping("/list") //http://localhost:9080/book/list
	public String showListBooks(@ModelAttribute("book") Book book, Model model) {
		model.addAttribute("listBooks", bookService.findAll());
		return "/list.jsp";
	}
		
	@RequestMapping("/delete/{id}") //http://localhost:9080/book/delete/{id}
	public String deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		bookService.deleteById(id);
		redirectAttributes.addFlashAttribute("msgOk", "Libro eliminado correctamente");
		return "redirect:/book";
	}
	
	@RequestMapping("/edit/{id}") //http://localhost:9080/book/edit/{id}
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return "/editBook.jsp";
	}
	
	@PostMapping("/update")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if(!result.hasErrors()) {
			bookService.save(book);
			redirectAttributes.addFlashAttribute("msgOk", "Libro actualizado correctamente");
			return "redirect:/book";
		}else {
			redirectAttributes.addFlashAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			return "/editBook.jsp";
		}
	}
	
	
	
	
	
	
}
