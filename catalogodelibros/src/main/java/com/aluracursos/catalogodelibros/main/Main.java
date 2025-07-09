package com.aluracursos.catalogodelibros.main;

import com.aluracursos.catalogodelibros.service.ConsumptionAPI;
import com.aluracursos.catalogodelibros.service.ConvertsData;

public class Main {

    private ConsumptionAPI consumptionAPI = new ConsumptionAPI();

    private final String URL_BASE = "https://gutendex.com/books";

    private ConvertsData converter = new ConvertsData();

}
