package com.aluracursos.catalogodelibros.main;

import com.aluracursos.catalogodelibros.model.Author;
import com.aluracursos.catalogodelibros.model.Book;
import com.aluracursos.catalogodelibros.model.DataAuthor;
import com.aluracursos.catalogodelibros.model.DataBook;
import com.aluracursos.catalogodelibros.repository.AuthorRepository;
import com.aluracursos.catalogodelibros.repository.BookRepository;
import com.aluracursos.catalogodelibros.service.ConsumptionAPI;
import com.aluracursos.catalogodelibros.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Main implements CommandLineRunner {

    Scanner scanner = new Scanner(System.in);

    private final ConsumptionAPI consumptionAPI = new ConsumptionAPI();
    private final ConvertData converter = new ConvertData();

    private static final String URL_BASE = "https://gutendex.com/books";

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public Main(BookRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) {

        int option = -1;

        while (option != 0){
            var menu = """
                    \n===== CATALOGO DE LIBROS =====
                    \n1 - Buscar libros por título
                    2 - Lista de todos los libros
                    3 - Lista de libros por idioma
                    4 - Lista de autores
                    5 - Listar autores vivos en determinado año
                    6 - Mostrar estadisticas de libros por idioma
                    \n0 - Salir
                    \nElige una opción:
                    """;
            System.out.println(menu);
            String input = scanner.nextLine();
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, ingresa un número");
                option = -1;
                continue;
            }

            try {
                switch (option){
                    case 1:
                        SearchBooksByTitle();
                        break;
                    case 2:
                        showAllBooks();
                        break;
                    case 3:
                        showBooksByLanguage();
                        break;
                    case 4:
                        showAllAuthors();
                        break;
                    case 5:
                        showAuthorsAliveInYear();
                        break;
                    case 6:
                        showBookStatsByLanguages();
                        break;
                    case 0:
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción inválida, intenta nuevamente");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private DataBook getDataBook() {
        System.out.println("Escribe el nombre del libro que deseas buscar: ");
        var nameBook = scanner.nextLine();

        try {
            var json = consumptionAPI.getData(URL_BASE + "?search=" + nameBook);

            var response = converter.parseResponse(json);

            if (response.getBooks() != null && !response.getBooks().isEmpty()) {
                return response.getBooks().get(0);
            }else {
                System.out.println("No se encontraron libros para: " + nameBook);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al procesar los datos: " + e.getMessage());
        }
        return null;
    }

    private void SearchBooksByTitle() {
        DataBook data = getDataBook();

        if (data != null && data.autores() != null && !data.autores().isEmpty()) {
            DataAuthor dataAuthor = data.autores().get(0);

            Optional<Author> autorExistente = authorRepository.findByNombre(dataAuthor.nombre());

            Author autor;
            if (autorExistente.isPresent()) {
                autor = autorExistente.get();
            } else {
                autor = new Author(dataAuthor);
                authorRepository.save(autor);
            }

            Book book = new Book(data);
            book.setAutor(autor);

            repository.save(book);
            System.out.println("Libro guardado en la base de datos: " + book.getTitulo());

        } else {
            System.out.println("No se encontró ningún libro con ese título o no tiene autores.");
        }
    }

    private void showAllBooks(){
        var books = repository.findAll();

        if (books.isEmpty()){
            System.out.println("No hay libros en la base de datos");
        } else {
            System.out.println("Lista de libros guardados: ");
            books.forEach(System.out::println);
        }
    }

    private void showBooksByLanguage() {
        var idiomas = repository.findDistinctIdiomas();

        if (idiomas.isEmpty()) {
            System.out.println("⚠️ No hay libros guardados aún, por lo tanto no hay idiomas disponibles.");
            return;
        }

        System.out.println();
        System.out.println("Idiomas disponibles:");
        idiomas.forEach(System.out::println);

        System.out.println();
        System.out.println("Ingresa uno de los idiomas listado arriba para ver el listado de libros: ");
        String language = scanner.nextLine();

        var books = repository.findByIdioma(language);
        if (books.isEmpty()) {
            System.out.println("No hay libros guardados con este idioma: " + language);
        } else {
            System.out.println("Los libros en idioma " + "'" + language + "'" + " son: ");
            books.forEach(System.out::println);
        }
    }

    private void showAllAuthors() {
        var authors = authorRepository.findAll();
        if (authors.isEmpty()) {
            System.out.println("No hay autores guardados en la base de datos");
        } else {
            System.out.println("Lista de autores: ");
            authors.forEach(System.out::println);
        }
    }

    private void showAuthorsAliveInYear() {
        System.out.println("Ingresa el año para consultar autores vivos: ");
        Integer year = scanner.nextInt();
        scanner.nextLine();

        List<Author> authors =  authorRepository.findAuthorsAliveInYear(year);
        if (authors.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año: " + year);
        } else {
            System.out.println("Autores vivos  en el año " + year + ": ");
            authors.forEach(System.out::println);
        }
    }

    private void showBookStatsByLanguages() {
        Map<String, String> languageNames = Map.of(
                "es", "Español",
                "en", "Inglés",
                "fr", "Francés",
                "it", "Italiano"
        );

        var books = repository.findAll();

        if (books.isEmpty()) {
            System.out.println("No hay libros guardados en la base de datos.");
        } else {
            var countsByLanguage = books.stream()
                    .collect(Collectors.groupingBy(
                            Book::getIdioma,
                            Collectors.counting()
                    ));
            System.out.println();
            System.out.println("Estadísticas de libros por idioma:");
            countsByLanguage.forEach((language, count) -> {
                String nombreCompleto = languageNames.getOrDefault(language, "Desconocido");
                System.out.println(nombreCompleto + " (" + language + "): " + count + " libro(s)");
            });
        }
    }
}
