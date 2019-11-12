package com.osvaldovillalobosperez.proyectofinalp77b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DaoNotas {
    private SQLiteDatabase db;
    public DaoNotas(Context context){
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
