package com.desafiolatam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotNull
	@Size(min=3, max=50, message = "Acepto títulos de libros entre 3 y 50 caracteres" )
	private String title;
	
	@NotNull
	@Range(min=1900, message = "La fecha de publicación está fuera del rango, desde 1900 en adelante") 
	private Integer year;
	
	@NotNull
	@Size(min=3, max=50, message = "Acepto nombres de autor entre 3 y 50 caracteres" )
	private String author;
	
	@NotNull
	@Size(min=3, max=50, message = "Acepto nombres de editorial entre 3 y 50 caracteres" )
	private String editorial;
	
	@NotNull
	private boolean available;

	public Book() {
		super();
	}

	public Book(Long id, String title, Integer year, String author, String editorial, boolean available) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.author = author;
		this.editorial = editorial;
		this.available = available;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
	