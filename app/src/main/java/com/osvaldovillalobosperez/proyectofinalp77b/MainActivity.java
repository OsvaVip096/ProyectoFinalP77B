package com.osvaldovillalobosperez.proyectofinalp77b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.DAONota;
import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.Nota;
import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.NotaAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Nota> lista = new ArrayList<>();
    private RecyclerView recyclerView;
    private EditText txtBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcclrFicha);
        txtBuscar = findViewById(R.id.txtBuscar);
        ActualizarRecycler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itmAgregar:
                Intent inte = new Intent(getApplicationContext(), Agregar.class);
                startActivity(inte);
                return true;
            case R.id.itmAcercaDe:
                Toast.makeText(getApplicationContext(), "Bere, Jesús, Nahum", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void ActualizarRecycler() {
        DAONota dao = new DAONota(this);
        lista = dao.SeleccionarTodos();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        NotaAdapter adapter = new NotaAdapter(this, lista);

        recyclerView.setAdapter(adapter);
        adapter.setOnItemLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final View n = v;
                AlertDialog.Builder menu = new AlertDialog.Builder(v.getContext());
                Resources res = getResources();
                CharSequence[] opciones = {res.getString(R.string.ver), res.getString(R.string.modificar), res.getString(R.string.eliminar), res.getString(R.string.marcar)};
                menu.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int opcion) {
                        switch (opcion) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(), Mostrar.class);
                                intent.putExtra("titulo", lista.get(recyclerView.getChildAdapterPosition(n)).getTitulo());
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(getApplicationContext(), Actualizar.class);
                                intent1.putExtra("titulo", lista.get(recyclerView.getChildAdapterPosition(n)).getTitulo());
                                startActivity(intent1);
                                break;
                            case 2:
                                DAONota daonuevo = new DAONota(getApplicationContext());
                                if (daonuevo.eliminar(lista.get(recyclerView.getChildAdapterPosition(n)))) {
                                    Toast.makeText(getApplicationContext(), "Se elimino", Toast.LENGTH_LONG).show();
                                }
                                ActualizarRecycler();
                                break;
                            case 3:
                                DAONota daoAc = new DAONota(getApplicationContext());
                                Nota notaA = lista.get(recyclerView.getChildAdapterPosition(n));
                                notaA.setEstado("false");
                                daoAc.actualizar(notaA);
                                ActualizarRecycler();
                                break;
                        }
                    }
                });
                menu.create().show();
                return true;
            }
        });
    }

    public void btnBuscar(View view) {
        actualizarRecyclerBuscar();
    }

    public void actualizarRecyclerBuscar() {
        DAONota dao = new DAONota(this);
        lista = dao.SeleccionarTodos(txtBuscar.getText().toString());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        NotaAdapter adapter = new NotaAdapter(this, lista);

        recyclerView.setAdapter(adapter);
        adapter.setOnItemLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final View n = v;
                AlertDialog.Builder menu = new AlertDialog.Builder(v.getContext());
                CharSequence[] opciones = {"Ver", "Modificar", "Eliminar", "Marcar como terminado"};
                menu.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int opcion) {
                        switch (opcion) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(), Mostrar.class);
                                intent.putExtra("titulo", lista.get(recyclerView.getChildAdapterPosition(n)).getTitulo());
                                startActivity(intent);
                                break;
                            case 1:
                                Toast.makeText(getApplicationContext(), "Modificar", Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                DAONota daonuevo = new DAONota(getApplicationContext());
                                if (daonuevo.eliminar(lista.get(recyclerView.getChildAdapterPosition(n)))) {
                                    Toast.makeText(getApplicationContext(), "Se elimino", Toast.LENGTH_LONG).show();
                                }
                                ActualizarRecycler();
                                break;
                            case 3:
                                DAONota daoAc = new DAONota(getApplicationContext());
                                Nota notaA = lista.get(recyclerView.getChildAdapterPosition(n));
                                notaA.setEstado("false");
                                daoAc.actualizar(notaA);
                                ActualizarRecycler();
                                break;
                        }
                    }
                });
                menu.create().show();
                return true;
            }
        });
    }
}
