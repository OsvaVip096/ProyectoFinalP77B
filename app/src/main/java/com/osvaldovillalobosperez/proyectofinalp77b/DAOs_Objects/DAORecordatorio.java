package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.osvaldovillalobosperez.proyectofinalp77b.DB.DataBaseProject;

import java.util.ArrayList;

public class DAORecordatorio {
    private SQLiteDatabase _sqlSqLiteDatabase;

    public DAORecordatorio(Context context) {
        this._sqlSqLiteDatabase = new DataBaseProject(context).getWritableDatabase();
    }

    public long Insert(Recordatorio recordatorio) {
        ContentValues cnt = new ContentValues();
        cnt.put(DataBaseProject.COLUMNS_RECORDATORIOS[1], recordatorio.getDia());
        cnt.put(DataBaseProject.COLUMNS_RECORDATORIOS[2], recordatorio.getMes());
        cnt.put(DataBaseProject.COLUMNS_RECORDATORIOS[3], recordatorio.getAnio());
        cnt.put(DataBaseProject.COLUMNS_RECORDATORIOS[4], recordatorio.getHora());
        cnt.put(DataBaseProject.COLUMNS_RECORDATORIOS[5], recordatorio.getMinuto());
        cnt.put(DataBaseProject.COLUMNS_RECORDATORIOS[6], recordatorio.getTituloFicha());

        return _sqlSqLiteDatabase.insert(DataBaseProject.TABLE_NAME_RECORDATORIOS, null, cnt);
    }

    public ArrayList<Recordatorio> seleccionar(Nota nota) {
        ArrayList<Recordatorio> lista = new ArrayList<>();
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_RECORDATORIOS, DataBaseProject.COLUMNS_RECORDATORIOS, DataBaseProject.COLUMNS_RECORDATORIOS[6] + "=?", new String[]{nota.getTitulo()}, null, null, null);
        while (c.moveToNext()) {
            lista.add(new Recordatorio(c.getInt(0), c.getInt(1), c.getInt(2), c.getInt(3), c.getInt(4), c.getInt(5), c.getString(6)));
        }
        return lista;
    }
}
