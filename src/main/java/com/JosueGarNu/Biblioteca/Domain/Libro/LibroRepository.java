package com.JosueGarNu.Biblioteca.Domain.Libro;

import com.JosueGarNu.Biblioteca.Domain.Model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Override
    @Query("SELECT l FROM Libro l ORDER BY l.idioma")
    List<Libro> findAll();

    boolean existsByTitulo(String titulo);
    List<Libro> findByIdiomaOrderByDescargasDesc(Idioma idioma);


}
