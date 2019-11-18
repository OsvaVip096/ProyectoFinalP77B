package com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects;

import java.util.Calendar;

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

    public Recordatorio() {

    }

    public long milis() {
        Calendar fechaActual = Calendar.getInstance();
        long millis = 0;
        int hora = fechaActual.get(Calendar.HOUR);
        int minute = fechaActual.get(Calendar.MINUTE);
        int year = fechaActual.get(Calendar.YEAR);
        int month = fechaActual.get(Calendar.MONTH);
        int day = fechaActual.get(Calendar.DAY_OF_MONTH);
        millis += Math.abs(this.hora - hora);
        millis += Math.abs(this.minuto - minute) * 60 * 1000;
        return millis;
    }
}
