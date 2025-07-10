package com.aluracursos.catalogodelibros.model;

import java.util.List;

public class Book {

    private Long id;
    private String titulo;
    private List<Author> autor;
    private List<String> idiomas;
    private Integer numeroDeDescargas;

    public Book(DataBook dataBook) {
        this.titulo = dataBook.titulo();
        this.autor = dataBook.autor();
        this.idiomas = dataBook.idiomas();
        this.numeroDeDescargas = dataBook.numeroDeDescargas();
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

    public List<Author> getAutor() {
        return autor;
    }

    public void setAutor(List<Author> autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
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
                " | Idiomas: " + idiomas +
                " | Número de Descargas: " + numeroDeDescargas;
    }
}
