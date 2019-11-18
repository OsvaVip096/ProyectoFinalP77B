package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.osvaldovillalobosperez.proyectofinalp77b.R;

import java.util.ArrayList;

public class ArchivoAdapter extends RecyclerView.Adapter<ArchivoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Archivo> lista;
    private View.OnLongClickListener onLongClickListener;

    public ArchivoAdapter(Context context, ArrayList<Archivo> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_archivo, viewGroup, false);
        itemView.setOnLongClickListener(onLongClickListener);
        //itemView.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.titulo.setText(lista.get(i).getDescripcion());
        if (lista.get(i).getTipo().equals("imagen")) {
            viewHolder.icono.setImageResource(R.drawable.imagen);
        } else if (lista.get(i).getTipo().equals("video")) {
            viewHolder.icono.setImageResource(R.drawable.video);
        } else if (lista.get(i).getTipo().equals("audio")) {
            viewHolder.icono.setImageResource(R.drawable.audio);
        } else {
            viewHolder.icono.setImageResource(R.drawable.nota);
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView icono;

        public ViewHolder(View item) {
            super(item);
            titulo = (TextView) item.findViewById(R.id.lblDescripcionAr);
            icono = (ImageView) item.findViewById(R.id.imgvwIconoAr);
        }
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }
}
