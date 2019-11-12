package com.osvaldovillalobosperez.proyectofinalp77b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class DaoArchivo  extends AppCompatActivity {
    private SQLiteDatabase bd;

    public DaoArchivo(Context context){
        this.bd =  new  DataBaseProject(context).getWritableDatabase();
    }

    public long insertarArchivo(Archivo archivo){
        ContentValues cnt=new ContentValues();
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[1],archivo.getDescripcion());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[2],archivo.getTipo());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[3],archivo.getRuta());
        cnt.put(DataBaseProject.COLUMNS_ARCHIVOS[4],archivo.getTitulo());
        return  bd.insert(DataBaseProject.TABLE_NAME_ARCHIVOS,null,cnt);
        //pañaleros
    }

}
