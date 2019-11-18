package com.osvaldovillalobosperez.proyectofinalp77b;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.Archivo;
import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.ArchivoAdapter;
import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.DAOArchivo;
import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.DAONota;
import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.Nota;
import com.osvaldovillalobosperez.proyectofinalp77b.Fragments.FragmentDetalle;
import com.osvaldovillalobosperez.proyectofinalp77b.Fragments.FragmentSelector;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {
    private Nota nota;
    private ArrayList<Archivo> archivoArrayList;
    private TextView titulo;
    private TextView descripcion;
    private RadioButton Rnota;
    private RadioButton Rtarea;
    private TextView recordatorio;
    private String titulo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        Bundle bundle = getIntent().getExtras();
        titulo1 = bundle.getString("titulo");

        titulo = findViewById(R.id.txtTituloM);
        descripcion = findViewById(R.id.txtDescripcionM);
        Rnota = findViewById(R.id.rdNotaM);
        Rnota.setEnabled(false);
        Rtarea = findViewById(R.id.rdTareaM);
        Rtarea.setEnabled(false);
        recordatorio = findViewById(R.id.lblRecordatorioM);
        llenarCampos();
    }

    public void llenarCampos() {
        DAOArchivo daoArchivo = new DAOArchivo(getApplicationContext());
        DAONota daoNota = new DAONota(getApplicationContext());
        Toast.makeText(this, titulo1, Toast.LENGTH_SHORT).show();
        nota = daoNota.seleccionarFicha(titulo1);
        archivoArrayList = daoArchivo.seleccionarArchivos(nota);
        titulo.setText(nota.getTitulo());
        descripcion.setText(nota.getDescripcion());
        if (nota.getTipo().equals("nota")) {
            Rnota.setChecked(true);
        } else if (nota.getTipo().equals("tarea")) {
            Rtarea.setChecked(true);
            recordatorio.setText(nota.getFechaRecordatorio());
        }
        ArchivoAdapter adapter = new ArchivoAdapter(this, archivoArrayList);
        if (findViewById(R.id.contenedor) != null && (getSupportFragmentManager().findFragmentById(R.id.contenedor) == null)) {
            FragmentSelector primerFragment = new FragmentSelector();
            primerFragment.setLista(archivoArrayList);
            primerFragment.setAdapter(adapter);
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor, primerFragment).commit();
        }
    }

    public void mostrarDetalle(Archivo archivo) {
        if (archivo.getTipo().equals("imagen")) {
            FragmentDetalle detalle = new FragmentDetalle();
            detalle.setArchivo(archivo);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.contenedor, detalle);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (archivo.getTipo().equals("video")) {
            FragmentVideo detalle1 = new FragmentVideo();
            detalle1.setArchivo(archivo);
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.contenedor, detalle1);
            transaction1.addToBackStack(null);
            transaction1.commit();
        } else if (archivo.getTipo().equals("audio")) {
            FragmentAudio detalle2 = new FragmentAudio();
            detalle2.setArchivo(archivo);
            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
            transaction2.replace(R.id.contenedor, detalle2);
            transaction2.addToBackStack(null);
            transaction2.commit();
        }
    }
}
