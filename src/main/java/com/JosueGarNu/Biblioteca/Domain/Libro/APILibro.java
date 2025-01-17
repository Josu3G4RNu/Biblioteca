package com.JosueGarNu.Biblioteca.Domain.Libro;

import com.JosueGarNu.Biblioteca.Domain.Autor.APIAutor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record APILibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<APIAutor> autor,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Long veces_descargado
) { }
