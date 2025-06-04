package com.aluracursos.desafioSpring.principal;

import com.aluracursos.desafioSpring.service.ConsumoAPI;
import com.aluracursos.desafioSpring.service.ConvierteDatos;

public class Principal {

    private static final String URL_BASE = "https://dragonball-api.com/api/characters";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraElMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
    }
}