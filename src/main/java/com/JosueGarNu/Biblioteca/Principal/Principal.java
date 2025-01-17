package com.JosueGarNu.Biblioteca.Principal;

import com.JosueGarNu.Biblioteca.Domain.Autor.Autor;
import com.JosueGarNu.Biblioteca.Domain.Autor.AutorRepository;
import com.JosueGarNu.Biblioteca.Domain.Libro.APILibro;
import com.JosueGarNu.Biblioteca.Domain.Libro.Libro;
import com.JosueGarNu.Biblioteca.Domain.Libro.LibroRepository;
import com.JosueGarNu.Biblioteca.Domain.Model.DatosAPI;
import com.JosueGarNu.Biblioteca.Domain.Model.Idioma;
import com.JosueGarNu.Biblioteca.Service.ConsumoAPI;
import com.JosueGarNu.Biblioteca.Service.ConvierteDatos;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository libroRepositorio;
    private AutorRepository autorRepositorio;

    public Principal(LibroRepository libroRepository, AutorRepository autorRepositorio) {
        this.libroRepositorio = libroRepository;
        this.autorRepositorio = autorRepositorio;
    }

    public void muestraElMenu() {
        var opcion = "";
        String menu = """
                1. Buscar Libro por su nombre
                2. Lista libros buscados
                3. Listar autores registrados
                4. Buscar autores por determinado año
                5. Listar libros por idioma
                0. Salir
                """;
        while (!opcion.equals("0")) {
            System.out.println(menu);
            opcion = teclado.nextLine();

            switch (opcion) {
                case "1":
                    buscarLibro();
                    break;
                case "2":
                    ListarLibrosBuscados();
                    break;
                case "3":
                    ListarAutoresRegistrados();
                    break;
                case "4":
                    BuscarAutoresPorAnio();
                    break;
                case "5":
                    BuscarLibrosRegistradosPorIdioma();
                    break;
                case "0":
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private APILibro get_datos_libro() {
        System.out.println("Escribe el nombre del libro que deseas buscar: ");
        var libroABuscar = teclado.nextLine().replace(" ", "%20");
        var json = consumoAPI.obtenerDatos(URL_BASE + "search=" + libroABuscar);
        DatosAPI libro = conversor.obtenerDatos(json, DatosAPI.class);

        if (libro.datosLibro().isEmpty()) {
            System.out.println("\nNo se encontró el libro que buscas\n");
            muestraElMenu();
        } else {
            return libro.datosLibro().get(0);
        }
        return null;
    }

    private void buscarLibro() {
        Libro libro = new Libro(Objects.requireNonNull(get_datos_libro()));
        if (libroRepositorio.existsByTitulo(libro.getTitulo())) {
            System.out.println("\nEl libro ya existe en la base de datos\n");
            muestraElMenu();
        }
        Autor autor = autorRepositorio.findByNombre(libro.getAutor().getNombre());
        if (autor == null){
            autor = libro.getAutor();
            autorRepositorio.save(autor);
            libro.setAutor(autor);
        }
        libroRepositorio.save(libro);
        System.out.println("El libro se ha registrado con éxito! \n" +
                libro);

    }

    private void ListarLibrosBuscados() {
        List<Libro> librosRegistrados = libroRepositorio.findAll();
        if (librosRegistrados.isEmpty()) {
            System.out.println("\nNo hay libros registrados. Se quien registre el primero de ellos :)\n");
        } else {
            librosRegistrados.forEach(System.out::println);
        }
    }

    private void ListarAutoresRegistrados() {
        List<Autor> autores_registrados = autorRepositorio.findAll();
        if (autores_registrados.isEmpty()){
            System.out.println("No hay autores registrados. Busca un libro para ser el primero en registrar uno");
        } else {
            autores_registrados.forEach(System.out::println);
        }
    }

    private void BuscarAutoresPorAnio() {
        System.out.println("Ingresa el año al cual pertenece tu escritor: ");
        var anio = teclado.nextInt();
        List<Autor> autores = autorRepositorio.findAutoresByAnioNacimientoBetween(anio);
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados en esa epoca. Corre a registrar al primero");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void BuscarLibrosRegistradosPorIdioma() {
        System.out.println("""
                es - Español
                en - Inglés
                fr - Francés
                pt - Portugués
                0 ~ 9 - Regresar al menú anterior
                """);

        var opcion = teclado.nextLine();

        try {
            Integer.parseInt(opcion);
            muestraElMenu();
        } catch (Exception e) {
            System.out.println("Opción Invalida");
            muestraElMenu();
        }

        try {
            Idioma idioma = Idioma.fromAbreviatura(opcion);
            List<Libro> lista_de_libros = libroRepositorio.findByIdiomaOrderByDescargasDesc(idioma);
            if (lista_de_libros.isEmpty()) {
                System.out.println("\nNo hay libros registrados en este idioma. Se quien registre el primero :)\n");
            } else {
                lista_de_libros.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
