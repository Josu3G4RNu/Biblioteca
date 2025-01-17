package com.JosueGarNu.Biblioteca.Domain.Model;

public enum Idioma {
    ESPAÑOL("es"),
    INGLÉS("en"),
    PORTUGUÉS("pt"),
    FRANCÉS("fr");

    private String abreviatura;

    Idioma(String abreviatura){
        this.abreviatura = abreviatura;
    }

    public static Idioma fromAbreviatura(String abreviatura){
        for (Idioma idioma : Idioma.values()){
            if (idioma.abreviatura.equalsIgnoreCase(abreviatura)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("No se encontró el idioma: " + abreviatura);
    }
}
