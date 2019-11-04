package com.osvaldovillalobosperez.proyectofinalp77b;

public class Archivo {
    int idArchivo;
    String descripcion;
    String tipo;
    String ruta;
    String titulo;

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Archivo(int idArchivo, String descripcion, String tipo, String ruta, String titulo) {
        this.idArchivo = idArchivo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.ruta = ruta;
        this.titulo = titulo;
    }
}
