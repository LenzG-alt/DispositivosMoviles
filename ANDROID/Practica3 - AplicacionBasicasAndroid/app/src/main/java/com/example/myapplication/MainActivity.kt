/*
Autor: Davis Arapa
Fecha de Creación: 09/09/2025
Fecha de Última Modificación: 09/09/2025
*/

package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity

import android.content.Intent
import android.widget.Button

// MainActivity: Esta es la pantalla principal de la aplicación.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño para esta actividad
        setContentView(R.layout.activity_main)

        // Obtiene referencias a los botones en el diseño
        val btnImagen = findViewById<Button>(R.id.btnImagen)
        val btnReproductor = findViewById<Button>(R.id.btnReproductor)

        // Establece un listener de clic para el botón "Imagen"
        btnImagen.setOnClickListener {
            // Crea un Intent para iniciar ImagenActivity
            val intent = Intent(this, ImagenActivity::class.java)
            startActivity(intent)
        }

        // Establece un listener de clic para el botón "Reproductor de Música"
        btnReproductor.setOnClickListener {
            // Crea un Intent para iniciar MusicaActivity
            val intent = Intent(this, MusicaActivity::class.java)
            startActivity(intent)
        }

    }
}
