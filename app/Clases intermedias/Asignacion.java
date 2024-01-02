package com.tiernoparla.educonex;

public class Asignacion {
    private int id;
    private int idAlumno;
    private int idAsignatura;

    // Constructor
    public Asignacion(int id, int idAlumno, int idAsignatura) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    // Otros métodos si es necesario
}
