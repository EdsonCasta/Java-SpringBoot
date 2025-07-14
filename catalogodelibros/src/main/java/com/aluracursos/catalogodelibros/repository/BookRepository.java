package com.aluracursos.catalogodelibros.repository;

import com.aluracursos.catalogodelibros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIdioma(String idioma);

    @Query("SELECT DISTINCT b.idioma FROM Book b")
    List<String> findDistinctIdiomas();

    Long countByIdioma(String idioma);
}
