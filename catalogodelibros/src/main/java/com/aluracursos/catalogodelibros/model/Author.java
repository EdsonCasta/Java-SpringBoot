package com.aluracursos.catalogodelibros.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer anoDeNacimiento;
    private Integer anoDeFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;

    public Author (){}

    public Author(DataAuthor dataAuthor) {
        this.nombre = dataAuthor.nombre();
        this.anoDeNacimiento = dataAuthor.anoDeNacimiento();
        this.anoDeFallecimiento = dataAuthor.anoDeFallecimiento();
    }

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
                "| Nombre: " + nombre +
                " | Nació: " + anoDeNacimiento +
                " | Falleció: " + anoDeFallecimiento;
    }
}
