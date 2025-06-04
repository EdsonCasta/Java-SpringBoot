package com.aluracursos.desafioSpring.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
