package com.JosueGarNu.Biblioteca;

import com.JosueGarNu.Biblioteca.Domain.Autor.AutorRepository;
import com.JosueGarNu.Biblioteca.Domain.Libro.LibroRepository;
import com.JosueGarNu.Biblioteca.Principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal main = new Principal(libroRepository, autorRepository);
        main.muestraElMenu();
    }
}
