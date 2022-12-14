package com.example.tarea2_2_thecircleoflife

import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.widget.Toast;
import androidx.core.widget.ImageViewCompat

import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {




    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library


        //Se crea el canal para enlazarlo con la notificación
        val name = "Gallina"
        val descriptionText = "xd"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("2", name, importance).apply {
            description = descriptionText
        }

    }



    private fun mostrarImagen(){

        setContentView(R.layout.activity_main);

        val constraintLayout = findViewById(R.id.primeraPantalla) as ConstraintLayout

        val imageView = ImageView(this)

        imageView.setImageResource(R.drawable.`as`)
        constraintLayout.addView(imageView)

        }


    // Se crea un cuadro de texto con un mensaje
    fun mensajeTexto(){
        val mensaje = AlertDialog.Builder(this)
        mensaje.setTitle("Aplicación en pausa")
        mensaje.setMessage("Pausado por problemas técnicos")
        mensaje.show()
    }

    fun cambiarPantalla(){


        val cambiarPantalla = Intent(this,SegundaPantalla ::class.java).apply {

        }

        startActivity(cambiarPantalla)


    }



    //Se pone las propiedades de la notifiación
    var builder = NotificationCompat.Builder(this, "2")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("My notification")
        .setContentText("Much longer text that cannot fit one line...")
        .setStyle(NotificationCompat.BigTextStyle()
            .bigText("Much longer text that cannot fit one line..."))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "Ciclo de vida - onCreate  - David Perea García");

        //Se inicia el método con el canal cuando se inicia la aplicacion
        createNotificationChannel()



    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Ciclo de vida - onRestart  - David Perea García");


    }

    override fun onStart() {
        super.onStart()




        Log.d(TAG, "Ciclo de vida - onStart  - David Perea García");

        //
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(2, builder.build())
        }


    }





    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Ciclo de vida - onResume  - David Perea García");



    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Ciclo de vida - onPause  - David Perea García");

        mostrarImagen()

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Ciclo de vida - onStop  - David Perea García");

        cambiarPantalla()
    }

    override fun onDestroy() {
        // Se crea un mensaje pequeño abajo
        Toast.makeText(this@MainActivity, "Hasta la próxima", Toast.LENGTH_LONG).show()

        super.onDestroy()
        Log.d(TAG, "Ciclo de vida - onDestroy  - David Perea García");


    }


    companion object {
        private const val TAG = "MainActivity"
    }

}