package com.JosueGarNu.Biblioteca.Domain.Autor;

import com.fasterxml.jackson.annotation.JsonAlias;

public record APIAutor(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") int anio_nacimiento,
    @JsonAlias("death_year") int anio_fallecimiento
) { }
