package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.osvaldovillalobosperez.proyectofinalp77b.DB.DataBaseProject;

import java.util.ArrayList;
import java.util.List;

public class DAONota {
    SQLiteDatabase _sqlSqLiteDatabase;

    public DAONota(Context context) {
        this._sqlSqLiteDatabase = new DataBaseProject(context).getWritableDatabase();
    }

    public long Insert(Nota nota) {
        ContentValues cnt = new ContentValues();
        cnt.put(DataBaseProject.COLUMNS_NOTAS[0], nota.getTitulo());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[1], nota.getDescripcion());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[2], nota.getTipo());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[3], nota.getFechaCreacion());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[4], nota.getFechaRecordatorio());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[5], nota.getEstado());

        return _sqlSqLiteDatabase.insert(DataBaseProject.TABLE_NAME_NOTAS, null, cnt);
    }

    public ArrayList<Nota> SeleccionarTodos() {
        ArrayList<Nota> lista = new ArrayList<Nota>();
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_NOTAS, DataBaseProject.COLUMNS_NOTAS, null, null, null, null, null);
        while (c.moveToNext()) {
            lista.add(new Nota(c.getString(0), c.getString(1), c.getString(2), c.getString(3)
                    , c.getString(4), c.getString(5)));
        }
        return lista;
    }

    public ArrayList<Nota> SeleccionarTodos(String titulo) {
        ArrayList<Nota> lista = new ArrayList<Nota>();
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_NOTAS, DataBaseProject.COLUMNS_NOTAS, "titulo like '%" + titulo + "%'", null, null, null, null);
        while (c.moveToNext()) {
            lista.add(new Nota(c.getString(0), c.getString(1), c.getString(2), c.getString(3)
                    , c.getString(4), c.getString(5)));
        }
        return lista;
    }

    public Nota seleccionarFicha(String titulo) {
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_NOTAS, DataBaseProject.COLUMNS_NOTAS, DataBaseProject.COLUMNS_NOTAS[0] + "=?", new String[]{titulo}, null, null, null);
        Nota fi = null;
        while (c.moveToNext()) {
            fi = new Nota(c.getString(0), c.getString(1), c.getString(2), c.getString(3)
                    , c.getString(4), c.getString(5));
        }
        return fi;
    }

    public boolean eliminar(Nota nota) {
        int no = _sqlSqLiteDatabase.delete(DataBaseProject.TABLE_NAME_ARCHIVOS, DataBaseProject.COLUMNS_ARCHIVOS[4] + "=?", new String[]{nota.getTitulo()});
        if (no > 0) {
            int no1 = _sqlSqLiteDatabase.delete(DataBaseProject.TABLE_NAME_NOTAS, DataBaseProject.COLUMNS_NOTAS[0] + "=?", new String[]{nota.getTitulo()});
            if (no1 > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean actualizar(Nota nota) {
        ContentValues cnt = new ContentValues();
        cnt.put(DataBaseProject.COLUMNS_NOTAS[1], nota.getDescripcion());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[2], nota.getTipo());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[3], nota.getFechaCreacion());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[4], nota.getFechaRecordatorio());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[5], nota.getEstado());
        long no = _sqlSqLiteDatabase.update(DataBaseProject.TABLE_NAME_NOTAS, cnt, DataBaseProject.COLUMNS_NOTAS[0] + "=?", new String[]{nota.getTitulo()});
        if (no > 0) {
            return true;
        } else {
            return false;
        }
    }
}
