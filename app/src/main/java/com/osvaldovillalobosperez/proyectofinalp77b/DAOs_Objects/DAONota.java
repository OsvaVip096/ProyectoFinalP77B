package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.osvaldovillalobosperez.proyectofinalp77b.DB.DataBaseProject;
import com.osvaldovillalobosperez.proyectofinalp77b.Nota;

import java.util.ArrayList;
import java.util.List;

public class DAONota {
    SQLiteDatabase _sqlSqLiteDatabase;

    public DAONota(Context ctx) {
        DataBaseProject miDB = new DataBaseProject(ctx);
        _sqlSqLiteDatabase = miDB.getWritableDatabase();
    }

    public long insert(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseProject.COLUMNS_NOTAS[1], nota.getTitulo());
        cv.put(DataBaseProject.COLUMNS_NOTAS[2], nota.getDescripcion());
        cv.put(DataBaseProject.COLUMNS_NOTAS[3], nota.getTipo());
        cv.put(DataBaseProject.COLUMNS_NOTAS[4], nota.getFechaCreacion());
        cv.put(DataBaseProject.COLUMNS_NOTAS[5], nota.getFechaRecordatorio());
        cv.put(DataBaseProject.COLUMNS_NOTAS[6], nota.getEstado());
        return _sqlSqLiteDatabase.insert(DataBaseProject.TABLE_NAME_NOTAS, null, cv);
    }

    public int update(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put(DataBaseProject.COLUMNS_NOTAS[1], nota.getTitulo());
        cv.put(DataBaseProject.COLUMNS_NOTAS[2], nota.getDescripcion());
        cv.put(DataBaseProject.COLUMNS_NOTAS[3], nota.getTipo());
        cv.put(DataBaseProject.COLUMNS_NOTAS[4], nota.getFechaCreacion());
        cv.put(DataBaseProject.COLUMNS_NOTAS[5], nota.getFechaRecordatorio());
        cv.put(DataBaseProject.COLUMNS_NOTAS[6], nota.getEstado());

        String idObjetivo = "_idNota = ?";
        String[] argumentosParaActualizar = {String.valueOf(nota.getIdNota())};
        return _sqlSqLiteDatabase.update(DataBaseProject.TABLE_NAME_NOTAS, cv, idObjetivo, argumentosParaActualizar);
    }

    public int delete(Nota nota) {
        String[] argumentosParaEliminar = {String.valueOf(nota.getIdNota())};
        return _sqlSqLiteDatabase.delete(DataBaseProject.TABLE_NAME_NOTAS, "_idNota = ?", argumentosParaEliminar);
    }

    public Cursor filter(String inputText, String filterColumn) throws SQLException {
        Cursor row = null;
        String query = "SELECT * FROM " + DataBaseProject.TABLE_NAME_NOTAS;
        if (inputText == null || inputText.length() == 0) {
            row = _sqlSqLiteDatabase.rawQuery(query, null);
        } else {
            query = "SELECT * FROM " + DataBaseProject.TABLE_NAME_NOTAS +
                    " WHERE " + filterColumn + " like '%" + inputText + "%'";
            row = _sqlSqLiteDatabase.rawQuery(query, null);
        }
        if (row != null) {
            row.moveToFirst();
        }
        return row;
    }

    public List<Nota> getAll() {
        List<Nota> lst = null;
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_NOTAS,
                DataBaseProject.COLUMNS_NOTAS,
                null, null, null, null, null);
        if (c.moveToFirst()) {
            lst = new ArrayList<Nota>();
            do {
                Nota ctc = new Nota(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5),
                        c.getString(6));
                lst.add(ctc);
            } while (c.moveToNext());
        }
        return lst;
    }

    public Cursor getAllCursor() {
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_NOTAS,
                DataBaseProject.COLUMNS_NOTAS,
                null, null, null, null, null);
        return c;
    }
}
