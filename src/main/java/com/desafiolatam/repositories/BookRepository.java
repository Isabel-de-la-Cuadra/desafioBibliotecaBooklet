package com.desafiolatam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Book;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

	@Query(value="SELECT * FROM bibliotecaBooklet.books b WHERE b.author LIKE '%?1%' OR b.title LIKE '%?1%'", nativeQuery=true)
	List<Book> findAllBooksByAuthorOrTitle(String search);
}
