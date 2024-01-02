package com.tiernoparla.educonex;

public class Aula {
    private int id;
    private String nombre;
    private int capacidad;  // Agregado: Atributo para la capacidad del aula

    // Constructor
    public Aula(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Otros métodos si es necesario
}
