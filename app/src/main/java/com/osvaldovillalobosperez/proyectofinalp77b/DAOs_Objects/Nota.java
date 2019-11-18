package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

public class Nota {
    String titulo;
    String descripcion;
    String tipo;
    String fechaCreacion;
    String fechaRecordatorio;
    String estado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaRecordatorio() {
        return fechaRecordatorio;
    }

    public void setFechaRecordatorio(String fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Nota(String titulo, String descripcion, String tipo, String fechaCreacion,
                String fechaRecordatorio, String estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecordatorio = fechaRecordatorio;
        this.estado = estado;
    }
}
