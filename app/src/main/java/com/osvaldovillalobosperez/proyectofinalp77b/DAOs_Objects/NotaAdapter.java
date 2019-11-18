package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.osvaldovillalobosperez.proyectofinalp77b.R;

import java.util.ArrayList;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Nota> lista;
    private View.OnLongClickListener onLongClickListener;

    public NotaAdapter(Context context, ArrayList<Nota> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public NotaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ficha, parent, false);
        itemView.setOnLongClickListener(onLongClickListener);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.ViewHolder holder, int position) {
        holder.titulo.setText(lista.get(position).getTitulo());
        if (lista.get(position).getTipo().equals("nota")) {
            holder.icono.setImageResource(R.drawable.nota);
        } else if (lista.get(position).getTipo().equals("tarea")) {
            holder.icono.setImageResource(R.drawable.tarea);
        }
        if (lista.get(position).getEstado().equals("true")) {
            holder.estado.setChecked(false);
        } else if (lista.get(position).getEstado().equals("false")) {
            holder.estado.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView icono;
        CheckBox estado;

        public ViewHolder(View item) {
            super(item);
            titulo = item.findViewById(R.id.lblTituloIcono);
            icono = item.findViewById(R.id.imgvwIcono);
            estado = item.findViewById(R.id.chckbxEstado);
        }
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }
}
