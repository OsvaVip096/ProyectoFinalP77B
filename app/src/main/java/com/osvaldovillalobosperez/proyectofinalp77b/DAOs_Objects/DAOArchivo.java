package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.osvaldovillalobosperez.proyectofinalp77b.Archivo;
import com.osvaldovillalobosperez.proyectofinalp77b.DB.DataBaseProject;

import java.util.ArrayList;

public class DAOArchivo extends AppCompatActivity {
    private SQLiteDatabase bd;

    public DAOArchivo(Context context) {
        this.bd = new DataBaseProject(context).getWritableDatabase();
    }

    public long insertarArchivo(Archivo archivo) {
        ContentValues cnt = new ContentValues();
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[1], archivo.getDescripcion());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[2], archivo.getTipo());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[3], archivo.getRuta());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[4], archivo.getTitulo());
        return bd.insert(DataBaseProject.TABLE_NAME_ARCHIVOS, null, cnt);
        //pañaleros
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

    public int delete(String id) {
        return bd.delete(DataBaseProject.TABLE_NAME_ARCHIVOS, "_idArchivo=?", new String[]{id});
    }
}
