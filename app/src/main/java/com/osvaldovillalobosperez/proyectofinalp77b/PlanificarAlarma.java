package com.osvaldovillalobosperez.proyectofinalp77b;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.osvaldovillalobosperez.proyectofinalp77b.DAOs_Objects.Nota;

public class PlanificarAlarma extends BroadcastReceiver {
    Nota nota;
    String titulo = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        lanzarNotificacion(context);
        Bundle bundle = intent.getExtras();
        titulo = bundle.getString("titulo");
    }

    public void lanzarNotificacion(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "nota")
                .setSmallIcon(R.drawable.nota)
                .setContentTitle("Nota")
                .setContentText("Descripcion")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        int consecutivo = (int) System.currentTimeMillis() / 1000;
        notificationManagerCompat.notify(1001, mBuilder.build());
    }

    public void setMensaje(Nota nota) {
        this.nota = nota;
    }
}
