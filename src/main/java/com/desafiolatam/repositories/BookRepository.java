package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Book;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

}
