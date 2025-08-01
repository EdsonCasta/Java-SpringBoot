package com.aluracursos.catalogodelibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAPI {

    private Integer count;
    private String next;
    private String previous;
    @JsonAlias("results") private List<DataBook> books;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<DataBook> getBooks() {
        return books;
    }

    public void setBooks(List<DataBook> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "RespuestaAPI{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", libros=" + books +
                '}';
    }
}
