/*
Autor: Davis Arapa
Fecha de Creación: 09/09/2025
Fecha de Última Modificación: 09/09/2025

Descripción:
Programar la funcionalidad para que al hacer clic en la imagen, se muestre un Toast con un mensaje personalizado.
 */


package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity


// ImagenActivity: Esta actividad muestra una imagen y muestra un mensaje Toast cuando se hace clic en la imagen.
class ImagenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño para esta actividad
        setContentView(R.layout.activity_imagen)

        // Obtiene una referencia al ImageView en el diseño
        val ivImagen = findViewById<ImageView>(R.id.ivImagen)

        // Establece un listener de clic para el ImageView
        ivImagen.setOnClickListener {
            // Muestra un mensaje Toast cuando se hace clic en la imagen
            Toast.makeText(this, "Imagen inspirada en el pintor Vincent van Gogh", Toast.LENGTH_SHORT).show()
        }
    }
}
