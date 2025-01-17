package com.JosueGarNu.Biblioteca.Domain.Autor;

import com.JosueGarNu.Biblioteca.Domain.Libro.Libro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {
    public Autor() {}

    public Autor(APIAutor autor, Libro libro) {
        this.nombre = autor.nombre();
        this.anio_nacimiento = autor.anio_nacimiento();
        this.anio_fallecimiento = autor.anio_fallecimiento();
        this.libros.add(libro);
    }

    @Override
    public String toString() {
        return "============AUTOR/A==============" + "\n" +
                "Nombre: " + nombre + "\n" +
                "Año de nacimiento: " + anio_nacimiento + "\n" +
                "Año de Fallecimiento: " + anio_fallecimiento + "\n" +
                "Libros Escritos Registrados: " + libros.stream().map(Libro::getTitulo).toList() + "\n" +
                "================================" + "\n";
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private int anio_nacimiento;
    private int anio_fallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final List<Libro> libros = new ArrayList<>();


    public String getNombre() {
        return nombre;
    }
}
