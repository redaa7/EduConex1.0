package com.tiernoparla.educonex;

public class Profesor {
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;  // Agregado: Atributo para la contraseña del profesor

    // Constructor
    public Profesor(int id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
