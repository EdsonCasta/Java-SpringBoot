package com.aluracursos.catalogodelibros.model;

import java.util.List;

public class Book {

    private Integer id;
    private String title;
    private List<Author> authors;
    private List<String> lenguages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLenguages() {
        return lenguages;
    }

    public void setLenguages(List<String> lenguages) {
        this.lenguages = lenguages;
    }
}
