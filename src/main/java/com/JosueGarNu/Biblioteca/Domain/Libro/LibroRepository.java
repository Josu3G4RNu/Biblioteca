package com.JosueGarNu.Biblioteca.Domain.Libro;

import com.JosueGarNu.Biblioteca.Domain.Model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    boolean existsByTitulo(String titulo);
    List<Libro> findByIdiomaOrderByDescargasDesc(Idioma idioma);


}
