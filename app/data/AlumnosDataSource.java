package com.tiernoparla.educonex.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.tiernoparla.educonex.Alumno;

public class AlumnosDataSource {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public AlumnosDataSource(Context context) {
        // Inicializa la base de datos
        DbHelper dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase(); // o dbHelper.getReadableDatabase();
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertAlumno(Alumno alumno) {
        ContentValues values = new ContentValues();
        values.put(DbContract.AlumnoEntry.COLUMN_NOMBRE, alumno.getNombre());
        values.put(DbContract.AlumnoEntry.COLUMN_CORREO, alumno.getCorreo());
        values.put(DbContract.AlumnoEntry.COLUMN_CONTRASENA, alumno.getContrasena());
        values.put(DbContract.AlumnoEntry.COLUMN_ID_AULA, alumno.getIdAula());

        return database.insert(DbContract.AlumnoEntry.TABLE_NAME, null, values);
    }


    public Cursor getAllAlumnos() {
        String[] projection = {
                DbContract.AlumnoEntry._ID,
                DbContract.AlumnoEntry.COLUMN_NOMBRE,
                DbContract.AlumnoEntry.COLUMN_CORREO,
                DbContract.AlumnoEntry.COLUMN_CONTRASENA,
                DbContract.AlumnoEntry.COLUMN_ID_AULA
        };

        return database.query(
                DbContract.AlumnoEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    // Otros métodos según tus necesidades
}
