package com.aluracursos.catalogodelibros.repository;

import com.aluracursos.catalogodelibros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNombre(String nombre);

    List<Author> findAll();

    @Query("SELECT a FROM Author a WHERE a.anoDeNacimiento <= :year AND (a.anoDeFallecimiento >= :year OR a.anoDeFallecimiento IS NULL)")
    List<Author> findAuthorsAliveInYear(Integer year);
}
