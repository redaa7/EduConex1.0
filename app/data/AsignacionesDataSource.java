package com.tiernoparla.educonex.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AsignacionesDataSource {

    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public AsignacionesDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Método para insertar una asignación en la base de datos
    public long insertAsignacion(int idAlumno, int idAsignatura) {
        ContentValues values = new ContentValues();
        values.put(DbContract.AsignacionEntry.COLUMN_ID_ALUMNO, idAlumno);
        values.put(DbContract.AsignacionEntry.COLUMN_ID_ASIGNATURA, idAsignatura);

        return database.insert(DbContract.AsignacionEntry.TABLE_NAME, null, values);
    }

    // Método para obtener todas las asignaciones
    public Cursor getAllAsignaciones() {
        String[] projection = {
                DbContract.AsignacionEntry._ID,
                DbContract.AsignacionEntry.COLUMN_ID_ALUMNO,
                DbContract.AsignacionEntry.COLUMN_ID_ASIGNATURA
        };

        return database.query(
                DbContract.AsignacionEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    // Otros métodos según tus necesidades (actualización, eliminación, etc.)
}
