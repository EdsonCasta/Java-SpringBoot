package com.aluracursos.desafioSpring.principal;

import com.aluracursos.desafioSpring.model.DatosPersonajes;
import com.aluracursos.desafioSpring.model.RespuestaAPI;
import com.aluracursos.desafioSpring.service.ConsumoAPI;
import com.aluracursos.desafioSpring.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private static final String URL_BASE = "https://dragonball-api.com/api/characters";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraElMenu() {
        int pagina = 1;
        boolean hayMasPaginas = true;
        List<DatosPersonajes> todosLosPersonajes = new ArrayList<>();

        while (hayMasPaginas) {
            var json = consumoAPI.obtenerDatos(URL_BASE + "?page=" + pagina + "&limit=10");
            RespuestaAPI respuestaAPI = convierteDatos.obtenerDatos(json, RespuestaAPI.class);

            System.out.println(json);

            if (respuestaAPI.items() == null || respuestaAPI.items().isEmpty()) {
                hayMasPaginas = false;
            } else {
                todosLosPersonajes.addAll(respuestaAPI.items());
                pagina++;
            }
        }
        System.out.println();
        System.out.println("Se encontraron: " + todosLosPersonajes.size() + " Personajes: ");
        System.out.println(todosLosPersonajes);
        // todosLosPersonajes.forEach(p -> System.out.println("- " + p.nombre()));

        // Top 10 de los personajes mas poderosos
        System.out.println();
        System.out.println("Top 10 de los personajes mas poderosos: ");

        todosLosPersonajes.stream()
                .filter(p -> p.ki() != null && p.ki().replace(".", "").matches("\\d+"))
                .sorted((p1, p2) -> {
                    int ki1 = Integer.parseInt(p1.ki().replace(".", ""));
                    int ki2 = Integer.parseInt(p2.ki().replace(".", ""));
                    return Integer.compare(ki2,ki1);
                })
                .limit(10)
                .forEach(p -> System.out.println("Nombre: " + p.nombre() + " | Kit: " + p.ki()));

        // Busqueda por Nombre
        System.out.println();
        Scanner escribir = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Escribe el nombre del personaje: ");
            String buscandoNombre = escribir.nextLine().toLowerCase().replace(" ", "");

            if (buscandoNombre.equals("salir")) {
                System.out.println("Saliendo del programa. ¡Gracias por usar el buscador de Dragon Ball!");
                break;
            }

            List<DatosPersonajes> result = new ArrayList<>();
            for (DatosPersonajes personaje : todosLosPersonajes) {
                if (personaje.nombre() != null && personaje.nombre().toLowerCase().replace(" ", "").contains(buscandoNombre)) {
                    result.add(personaje);
                }
            }
            if (result.isEmpty()) {
                System.out.println("No se encontro el personaje");
            } else {
                System.out.println("\nPersonaje Encontrado: ");
                result.forEach(p -> System.out.println("Nombre: " + p.nombre() +
                        " | Raza: " + p.raza() +
                        " | Género: " + p.genero() +
                        " | Ki: " + p.ki()));
                System.out.println("\n¡Escribe 'salir' si deseas parar la Busqueda!");
            }
        }

        // Generando Estadisticas
        System.out.println("\nEstadísticas por género:");
        Map<String, Long> personajesPorGenero = todosLosPersonajes.stream()
                .filter(p -> p.genero() != null && !p.genero().isBlank())
                .collect(Collectors.groupingBy(
                        p -> p.genero().toLowerCase(),
                        Collectors.counting()
                ));

        personajesPorGenero.forEach((genero, cantidad) ->
                System.out.println("Género: " + genero + " | Cantidad: " + cantidad));

        System.out.println("\nEstadísticas del Ki de los personajes:");

        DoubleSummaryStatistics statsKi = todosLosPersonajes.stream()
                .filter(p -> p.ki() != null && p.ki().replace(".", "").matches("\\d+"))
                .mapToDouble(p -> Double.parseDouble(p.ki().replace(".", "")))
                .summaryStatistics();

        System.out.println("Cantidad total con Ki válido: " + statsKi.getCount());
        System.out.println("Suma total de Ki: " + statsKi.getSum());
        System.out.println("Promedio de Ki: " + statsKi.getAverage());
        System.out.println("Ki mínimo: " + statsKi.getMin());
        System.out.println("Ki máximo: " + statsKi.getMax());
    }
}