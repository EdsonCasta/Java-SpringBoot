package com.aluracursos.catalogodelibros.main;

import com.aluracursos.catalogodelibros.model.Book;
import com.aluracursos.catalogodelibros.model.ResponseAPI;
import com.aluracursos.catalogodelibros.service.ConsumptionAPI;
import com.aluracursos.catalogodelibros.service.ConvertData;

import java.util.List;

public class Main {

    private static final String URL_BASE = "https://gutendex.com/books/";

    public static void main(String[] args){

        ConsumptionAPI consumptionAPI = new ConsumptionAPI();
        ConvertData converter = new ConvertData();

        String json = consumptionAPI.getData(URL_BASE);
        ResponseAPI response = converter.parseResponse(json);

        System.out.println("Total de libros encontrados: " + response.getCount());
        List<Book> books = response.getBooks();

        for (Book book : books) {
            System.out.println(book);
            System.out.println("---------");
        }
    }
}
