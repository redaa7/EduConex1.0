package com.tiernoparla.educonex;

public class Asignatura {
    private int id;
    private String nombre;

    // Constructor
    public Asignatura(int id, String nombre) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Otros métodos si es necesario
}
