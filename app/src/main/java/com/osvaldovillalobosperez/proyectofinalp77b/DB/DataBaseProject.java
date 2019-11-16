package com.osvaldovillalobosperez.proyectofinalp77b.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseProject extends SQLiteOpenHelper {
    /*Script para Notas*/
    final private String SCRIPT_TABLE_NOTAS = "CREATE TABLE notas (" +
            "_idNota            INTEGER     PRIMARY KEY     AUTOINCREMENT   NOT NULL," +
            "titulo             TEXT        NOT NULL," +
            "descripcion        TEXT        NOT    NULL," +
            "tipo               TEXT        NOT NULL," +
            "fechaCreacion      TEXT        NOT NULL," +
            "fechaRecordatorio  TEXT        NOT NULL," +
            "estado             TEXT        NOT NULL);";

    public static final String[] COLUMNS_NOTAS = {
            "_idNota",
            "titulo",
            "descripcion",
            "tipo",
            "fechaCreacion",
            "fechaRecordatorio",
            "estado"};

    public static final String TABLE_NAME_NOTAS = "notas";

    /*Script para Archivos*/
    final private String SCRIPT_TABLE_ARCHIVOS = "CREATE TABLE archivos (" +
            "_idArchivo     INTEGER     PRIMARY KEY     AUTOINCREMENT       NOT NULL," +
            "descripcion    TEXT        NOT NULL," +
            "tipo           TEXT        NOT NULL," +
            "ruta           TEXT        NOT NULL," +
            "titulo         TEXT        NOT NULL," +
            "FOREIGN KEY (titulo) REFERENCES notas (titulo));";

    public static final String[] COLUMNS_ARCHIVOS = {
            "_idArchivo",
            "descripcion",
            "tipo",
            "ruta",
            "titulo"};

    public static final String TABLE_NAME_ARCHIVOS = "archivos";

    /*Script para Recordatorios*/
    final private String SCRIPT_TABLE_RECORDATORIOS = "CREATE TABLE recordatorios (" +
            "_idRecordatorio    INTEGER     PRIMARY KEY     AUTOINCREMENT       NOT NULL," +
            "dia                INTEGER     NOT NULL," +
            "mes                INTEGER     NOT NULL," +
            "anio               INTEGER     NOT NULL," +
            "hora               INTEGER     NOT NULL," +
            "minuto             INTEGER     NOT NULL," +
            "tituloFicha        TEXT        NOT NULL," +
            "FOREIGN KEY (tituloFicha) REFERENCES notas (titulo));";

    public static final String[] COLUMNS_RECORDATORIOS = {
            "_idRecordatorio",
            "dia",
            "mes",
            "anio",
            "hora",
            "minuto",
            "tituloFicha"};

    public static final String TABLE_NAME_RECORDATORIOS = "recordatorios";

    /**
     * Constructor default de la Base de Datos del proyecto.
     *
     * @param context Indica el contexto.
     */
    public DataBaseProject(@Nullable Context context) {
        super(context, "DBFile", null, 1);
    }

    /**
     * Creación de las tablas de la BD.
     *
     * @param sqLiteDatabase Parámetro que permite ejecutar instrucciones SQL.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SCRIPT_TABLE_NOTAS);
        sqLiteDatabase.execSQL(SCRIPT_TABLE_ARCHIVOS);
        sqLiteDatabase.execSQL(SCRIPT_TABLE_RECORDATORIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
