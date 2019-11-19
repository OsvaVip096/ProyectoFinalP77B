package com.osvaldovillalobosperez.proyectofinalp77b.Fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.Archivo;
import com.osvaldovillalobosperez.proyectofinalp77b.R;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAudio extends Fragment {
    private Archivo archivo;
    private Button btnReproducir;
    private Button btnPausar;
    private MediaPlayer mediaPlayer=new MediaPlayer();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_audio,container,false);
        btnReproducir=(Button)vista.findViewById(R.id.btnReproducirAudio);
        btnPausar=(Button)vista.findViewById(R.id.btnPausarAudio);
        Uri uri=Uri.parse(archivo.getRuta());
        try {
            mediaPlayer.setDataSource(getContext(),uri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPlayer=new MediaPlayer();
                mediaPlayer.start();
            }
        });
        return vista;
    }
    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
}

