package com.aluracursos.desafioSpring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosPersonajes(
        @JsonAlias("name") String nombre,
        @JsonAlias("race") String raza,
        @JsonAlias("gender") String genero,
        @JsonAlias("ki") String ki
) {
}
