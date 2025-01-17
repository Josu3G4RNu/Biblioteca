package com.JosueGarNu.Biblioteca.Domain.Libro;

import com.JosueGarNu.Biblioteca.Domain.Autor.Autor;
import com.JosueGarNu.Biblioteca.Domain.Model.Idioma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Libros")
@AllArgsConstructor
public class Libro {

    public Autor getAutor() {
        return this.autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Libro(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Titulo", unique = true)
    private String titulo;

    //Puede ser un ENUM
    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    @ManyToOne
    private Autor autor;

    @Column(name = "Descargas")
    private Long descargas;

    public Libro(APILibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idioma = Idioma.fromAbreviatura(datosLibro.idiomas().get(0));
        this.autor = new Autor(datosLibro.autor().get(0), this);
        this.descargas = datosLibro.veces_descargado();
    }

    @Override
    public String toString() {
        return "============LIBRO==============" + "\n" +
                "Título del Libro: " + titulo + "\n" +
                "Autor/Autora: " + autor.getNombre() + "\n" +
                "Idioma: " + idioma + "\n" +
                "Descargas: " + descargas + "\n" +
                "===============================" + "\n";
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
