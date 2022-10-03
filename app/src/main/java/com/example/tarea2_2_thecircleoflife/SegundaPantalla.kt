package com.example.tarea2_2_thecircleoflife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class SegundaPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_pantalla)
    }


    override fun onDestroy() {
        // Se crea un mensaje pequeño abajo
        Toast.makeText(this@SegundaPantalla, "Hasta la próxima", Toast.LENGTH_LONG).show()

        super.onDestroy()
    }

}