package com.JosueGarNu.Biblioteca.Domain.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE :anio BETWEEN a.anio_nacimiento AND a.anio_fallecimiento ORDER BY a.anio_nacimiento DESC")
    List<Autor> findAutoresByAnioNacimientoBetween(int anio);
}
