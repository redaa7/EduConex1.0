package com.tiernoparla.educonex.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "educonex.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas al ejecutar la primera vez
        db.execSQL(createAulaTable());
        db.execSQL(createProfesorTable());
        db.execSQL(createAlumnoTable());
        db.execSQL(createAsignaturaTable());
        db.execSQL(createAsignacionTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí podrías realizar actualizaciones de la base de datos
        // (p.ej., agregar nuevas tablas, modificar columnas, etc.)
    }

    private String createAulaTable() {
        return "CREATE TABLE " + DbContract.AulaEntry.TABLE_NAME + " (" +
                DbContract.AulaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DbContract.AulaEntry.COLUMN_NOMBRE + " TEXT)";
        // La tabla Aula almacena información sobre las aulas.
    }


    private String createProfesorTable() {
        return "CREATE TABLE " + DbContract.ProfesorEntry.TABLE_NAME + " (" +
                DbContract.ProfesorEntry._ID + " INTEGER PRIMARY KEY," +
                DbContract.ProfesorEntry.COLUMN_NOMBRE + " TEXT)";
        // Agregar más columnas según sea necesario
    }

    private String createAlumnoTable() {
        return "CREATE TABLE " + DbContract.AlumnoEntry.TABLE_NAME + " (" +
                DbContract.AlumnoEntry._ID + " INTEGER PRIMARY KEY," +
                DbContract.AlumnoEntry.COLUMN_NOMBRE + " TEXT)";
        // Agregar más columnas según sea necesario
    }

    private String createAsignaturaTable() {
        return "CREATE TABLE " + DbContract.AsignaturaEntry.TABLE_NAME + " (" +
                DbContract.AsignaturaEntry._ID + " INTEGER PRIMARY KEY," +
                DbContract.AsignaturaEntry.COLUMN_NOMBRE + " TEXT)";
        // Agregar más columnas según sea necesario
    }

    private String createAsignacionTable() {
        return "CREATE TABLE " + DbContract.AsignacionEntry.TABLE_NAME + " (" +
                DbContract.AsignacionEntry._ID + " INTEGER PRIMARY KEY," +
                DbContract.AsignacionEntry.COLUMN_ID_ALUMNO + " INTEGER," +
                DbContract.AsignacionEntry.COLUMN_ID_ASIGNATURA + " INTEGER)";
        // Agregar más columnas según sea necesario
    }
}
