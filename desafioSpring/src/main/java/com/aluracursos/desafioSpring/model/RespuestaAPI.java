package com.aluracursos.desafioSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record RespuestaAPI(
        List<DatosPersonajes> items
) {
}
