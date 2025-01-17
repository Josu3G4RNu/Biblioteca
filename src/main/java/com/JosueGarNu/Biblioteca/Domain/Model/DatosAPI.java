package com.JosueGarNu.Biblioteca.Domain.Model;

import com.JosueGarNu.Biblioteca.Domain.Libro.APILibro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAPI(
        @JsonAlias("results")List<APILibro> datosLibro,
        @JsonAlias("download_count") Long descargas
) { }
