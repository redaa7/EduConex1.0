package com.tiernoparla.educonex.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.tiernoparla.educonex.Profesor;

public class ProfesoresDataSource {

    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public ProfesoresDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    // Métodos para abrir y cerrar la conexión a la base de datos
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Método para insertar un profesor en la base de datos
    public long insertProfesor(Profesor profesor) {
        ContentValues values = new ContentValues();
        values.put(DbContract.ProfesorEntry.COLUMN_NOMBRE, profesor.getNombre());
        values.put(DbContract.ProfesorEntry.COLUMN_CORREO, profesor.getCorreo());
        values.put(DbContract.ProfesorEntry.COLUMN_CONTRASENA, profesor.getContrasena());

        return database.insert(DbContract.ProfesorEntry.TABLE_NAME, null, values);
    }

    // Métodos adicionales según sea necesario
}
