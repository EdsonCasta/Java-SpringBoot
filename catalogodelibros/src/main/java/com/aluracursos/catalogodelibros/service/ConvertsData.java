package com.aluracursos.catalogodelibros.service;

import com.aluracursos.catalogodelibros.model.ResponseAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertsData {

    private ObjectMapper objectMapper = new ObjectMapper();

    public ResponseAPI getData(String json){
        try {
            return objectMapper.readValue(json, ResponseAPI.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir JSON a objeto: " + e.getMessage(), e);
        }
    }
}
