package com.tiernoparla.educonex.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AsignaturasDataSource {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public AsignaturasDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long insertAsignatura(int id, String nombre) {
        ContentValues values = new ContentValues();
        values.put(DbContract.AsignaturaEntry._ID, id);
        values.put(DbContract.AsignaturaEntry.COLUMN_NOMBRE, nombre);
        // ... otros campos si los tienes

        return database.insert(DbContract.AsignaturaEntry.TABLE_NAME, null, values);
    }


    public Cursor getAllAsignaturas() {
        String[] projection = {
                DbContract.AsignaturaEntry._ID,
                DbContract.AsignaturaEntry.COLUMN_NOMBRE,
                DbContract.AsignaturaEntry.COLUMN_ID_PROFESOR
        };

        return database.query(
                DbContract.AsignaturaEntry.TABLE_NAME,
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
