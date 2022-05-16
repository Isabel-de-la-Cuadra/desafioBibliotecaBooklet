package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Book;
import com.desafiolatam.repositories.BookRepository;


@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Book findById(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public List<Book> searchBooks(String search) {
		System.out.println("search en método searchBooks en BookService " + search);
		return bookRepository.findAllBooksByAuthorOrTitle(search);
	}

}
