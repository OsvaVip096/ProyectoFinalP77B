package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.osvaldovillalobosperez.proyectofinalp77b.DB.DataBaseProject;
import com.osvaldovillalobosperez.proyectofinalp77b.Nota;

public class DAONotas {
    private SQLiteDatabase db;
    public DAONotas(Context context){
        this.db = new DataBaseProject(context).getWritableDatabase();
    }

    public long Insert(Nota nota){
        ContentValues cnt=new ContentValues();

        cnt.put(DataBaseProject.COLUMNS_NOTAS[0],nota.getTitulo());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[1],nota.getDescripcion());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[2],nota.getTipo());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[3],nota.getFechaCreacion());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[4],nota.getFechaRecordatorio());
        cnt.put(DataBaseProject.COLUMNS_NOTAS[5],nota.getEstado());

        return  db.insert(DataBaseProject.TABLE_NAME_NOTAS,null,cnt);
    }


}
