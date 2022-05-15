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
	@Size(min=3, max=50, message = "Acepto títulos de libros con más de 3 caracteres" )
	private String titulo;
	
	@NotNull
	@Range(min=1900, message = "La fecha de publicación está fuera del rango") 
	private Integer anio;
	
	@NotNull
	@Size(min=3, max=50, message = "Acepto nombres de autor con más de 3 caracteres" )
	private String autor;
	
	@NotNull
	@Size(min=3, max=50, message = "Acepto nombres de editorial con más de 3 caracteres" )
	private String editorial;
	
	@NotNull
	private boolean disponible;

	public Book() {
		super();
	}

	public Book(Long id, String titulo, Integer anio, String autor, String editorial, boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
		this.autor = autor;
		this.editorial = editorial;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}
	