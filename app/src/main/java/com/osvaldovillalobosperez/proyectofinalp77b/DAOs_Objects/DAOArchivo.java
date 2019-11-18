package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.osvaldovillalobosperez.proyectofinalp77b.DB.DataBaseProject;

import java.util.ArrayList;

public class DAOArchivo extends AppCompatActivity {
    SQLiteDatabase _sqlSqLiteDatabase;

    public DAOArchivo(Context context) {
        this._sqlSqLiteDatabase = new DataBaseProject(context).getWritableDatabase();
    }

    public long insertarArchivo(Archivo archivo) {
        ContentValues cnt = new ContentValues();
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[1], archivo.getDescripcion());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[2], archivo.getTipo());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[3], archivo.getRuta());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[4], archivo.getTitulo());
        return _sqlSqLiteDatabase.insert(DataBaseProject.TABLE_NAME_ARCHIVOS, null, cnt);
    }

    public boolean insertarVariosArchivos(ArrayList<Archivo> lista) {
        int cont = 0;
        for (Archivo ar : lista) {
            if (this.insertarArchivo(ar) > 0) {
                cont++;
            }
        }
        if (cont == lista.size()) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Archivo> seleccionarArchivos(Nota nota) {
        ArrayList<Archivo> lista = new ArrayList<>();
        Cursor c = _sqlSqLiteDatabase.query(DataBaseProject.TABLE_NAME_ARCHIVOS, DataBaseProject.COLUMNS_ARCHIVOS, DataBaseProject.COLUMNS_ARCHIVOS[4] + "=?", new String[]{nota.getTitulo()}, null, null, null);
        Archivo ar = null;
        while (c.moveToNext()) {
            ar = new Archivo(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            lista.add(ar);
        }
        return lista;
    }

    public boolean eliminar(Archivo ar) {
        int no = _sqlSqLiteDatabase.delete(DataBaseProject.TABLE_NAME_ARCHIVOS, DataBaseProject.COLUMNS_ARCHIVOS[0] + "=?", new String[]{ar.getIdArchivo() + ""});
        if (no > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar(Nota nota) {
        int no = _sqlSqLiteDatabase.delete(DataBaseProject.TABLE_NAME_ARCHIVOS, DataBaseProject.COLUMNS_ARCHIVOS[4] + "=?", new String[]{nota.getTitulo()});
        if (no > 0) {
            return true;
        } else {
            return false;
        }
    }
}
