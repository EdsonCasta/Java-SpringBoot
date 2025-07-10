package com.aluracursos.catalogodelibros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    private String nombre;
    private Integer anoDeNacimiento;
    private Integer anoDeFallecimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnoDeNacimiento() {
        return anoDeNacimiento;
    }

    public void setAnoDeNacimiento(Integer anoDeNacimiento) {
        this.anoDeNacimiento = anoDeNacimiento;
    }

    public Integer getAnoDeFallecimiento() {
        return anoDeFallecimiento;
    }

    public void setAnoDeFallecimiento(Integer anoDeFallecimiento) {
        this.anoDeFallecimiento = anoDeFallecimiento;
    }

    @Override
    public String toString(){
        return "AUTOR: " +
                "| name: " + nombre +
                " | Año de Nacimiento: " + anoDeNacimiento +
                " | Año de Fallecimiento: " + anoDeFallecimiento;
    }
}
