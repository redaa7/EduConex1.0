package com.tiernoparla.educonex.data;

import android.provider.BaseColumns;

public class DbContract {
    private DbContract() {}  // Para evitar instancias accidentales

    // Definir las constantes para la tabla Aula
    public static final class AulaEntry implements BaseColumns {
        public static final String TABLE_NAME = "aulas";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_CAPACIDAD = "capacidad";
        // Agregar más columnas según sea necesario
    }

    // Definir las constantes para la tabla Profesor
    public static final class ProfesorEntry implements BaseColumns {
        public static final String TABLE_NAME = "profesores";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_CORREO = "correo";
        public static final String COLUMN_CONTRASENA = "contrasena";
        // Agregar más columnas según sea necesario
    }


    // Definir las constantes para la tabla Alumno
    public static final class AlumnoEntry implements BaseColumns {
        public static final String TABLE_NAME = "alumnos";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_CORREO = "correo";
        public static final String COLUMN_CONTRASENA = "contrasena";
        public static final String COLUMN_ID_AULA = "id_aula";
        // Agregar más columnas según sea necesario
    }

    // Definir las constantes para la tabla Asignatura
    public static final class AsignaturaEntry implements BaseColumns {
        public static final String TABLE_NAME = "asignaturas";
        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_ID_PROFESOR = "id_profesor";
        // Agregar más columnas según sea necesario
    }

    // Definir las constantes para la tabla Asignacion
    public static final class AsignacionEntry implements BaseColumns {
        public static final String TABLE_NAME = "asignaciones";
        public static final String COLUMN_ID_ALUMNO = "id_alumno";
        public static final String COLUMN_ID_ASIGNATURA = "id_asignatura";
        // Agregar más columnas según sea necesario
    }
}
