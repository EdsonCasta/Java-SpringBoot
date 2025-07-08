package com.aluracursos.catalogodelibros.model;

import java.util.List;

public class Libro {

    private Integer id;
    private String title;
    private List<Autor> authors;
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

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public List<String> getLenguages() {
        return lenguages;
    }

    public void setLenguages(List<String> lenguages) {
        this.lenguages = lenguages;
    }
}
