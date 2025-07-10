package com.aluracursos.catalogodelibros.main;

import com.aluracursos.catalogodelibros.service.ConsumptionAPI;
import com.aluracursos.catalogodelibros.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ConsumptionAPI consumptionAPI = new ConsumptionAPI();
    private final ConvertData converter = new ConvertData();

    private static final String URL_BASE = "https://gutendex.com/books";

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        int option = -1;

        while (option != 0){
            var menu = """
                    \n===== CATALOGO DE LIBROS =====
                    \n1 - Buscar libros por título
                    \n0 - Salir
                    \nElige una opción:
                    """;
            System.out.println(menu);

            try {
                option = Integer.parseInt(scanner.nextLine());

                switch (option){
                    case 1:
                        SearchBooksByTitle(scanner);
                        break;
                    case 0:
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción inválida, intenta nuevamente");
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida, ingresa un número");
            }
        }
        scanner.close();
    }

    private void SearchBooksByTitle(Scanner scanner) {
        System.out.println("Ingresa el título que deseas buscar: ");
    }
}
