package com.desafiolatam.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
	@RequestMapping("/search") //http://localhost:9080/book/search
	public String searchBook() {
				return "/searchBook.jsp";
	}

	@PostMapping("/search") //http://localhost:9080/book/search
	public String searchBook(@Param("search") String search, Model model, 
			RedirectAttributes redirectAttributes) {
		
		List<Book> books = new ArrayList<Book>();
		
		System.out.println("inicio del método searchBook");
		
		if(search.isEmpty()) {
			redirectAttributes.addFlashAttribute("msgError", "No puedo buscar si no ingresas algún dato");
			return "redirect:search";
		}else {
			System.out.println("search en el else del método " + search);
			books = bookService.searchBooks(search);
		
			System.out.println("books en método " + books);
			
			if(books.size()!=0) {
				model.addAttribute("books", books);
				System.out.println("books en el segundo if del método " + books);
				redirectAttributes.addFlashAttribute("msgOk", "He encontrado los siguientes libros con los caracteres ingresados");
				return "/searchBook.jsp";
			}else {
				System.out.println("En el segundo else del método ");
				redirectAttributes.addFlashAttribute("msgError", "No he encontrado ningún libro");
				return "redirect:search";
			}
		}
	}
	
}
