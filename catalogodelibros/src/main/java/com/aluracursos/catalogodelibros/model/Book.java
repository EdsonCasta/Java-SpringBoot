package com.aluracursos.catalogodelibros.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Author autor;
    private String idioma;
    private Integer numeroDeDescargas;

    public Book (){}

    public Book(DataBook dataBook) {
        this.titulo = dataBook.titulo();
        this.numeroDeDescargas = dataBook.numeroDeDescargas();

        if (dataBook.idiomas() != null && !dataBook.idiomas().isEmpty()) {
            this.idioma = dataBook.idiomas().get(0);
        }
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

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
        return "BOOK: " +
                "| id: " + id +
                " | Titulo: " + titulo +
                " | Autor: " + autor +
                " | Idiomas: " + idioma +
                " | Número de Descargas: " + numeroDeDescargas;
    }
}
