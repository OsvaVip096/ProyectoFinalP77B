package com.osvaldovillalobosperez.proyectofinalp77b;

public class Recordatorio {
    int idRecordatorio;
    int dia;
    int mes;
    int anio;
    int hora;
    int minuto;
    String tituloFicha;

    public int getIdRecordatorio() {
        return idRecordatorio;
    }

    public void setIdRecordatorio(int idRecordatorio) {
        this.idRecordatorio = idRecordatorio;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getTituloFicha() {
        return tituloFicha;
    }

    public void setTituloFicha(String tituloFicha) {
        this.tituloFicha = tituloFicha;
    }

    public Recordatorio(int idRecordatorio, int dia, int mes, int anio, int hora, int minuto, String tituloFicha) {
        this.idRecordatorio = idRecordatorio;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minuto = minuto;
        this.tituloFicha = tituloFicha;
    }
}
