package com.aluracursos.catalogodelibros.repository;

import com.aluracursos.catalogodelibros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
