package com.tiernoparla.educonex.data;

import android.content.ContentValues;
import com.tiernoparla.educonex.Aula;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AulasDataSource {

    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public AulasDataSource(Context context) {
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Método para insertar un aula en la base de datos
    public long insertAula(Aula aula) {
        ContentValues values = new ContentValues();
        values.put(DbContract.AulaEntry.COLUMN_NOMBRE, aula.getNombre());

        return database.insert(DbContract.AulaEntry.TABLE_NAME, null, values);
    }

    // Método para obtener todas las aulas
    public Cursor getAllAulas() {
        String[] projection = {
                DbContract.AulaEntry._ID,
                DbContract.AulaEntry.COLUMN_NOMBRE,
                DbContract.AulaEntry.COLUMN_CAPACIDAD
        };

        return database.query(
                DbContract.AulaEntry.TABLE_NAME,
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
