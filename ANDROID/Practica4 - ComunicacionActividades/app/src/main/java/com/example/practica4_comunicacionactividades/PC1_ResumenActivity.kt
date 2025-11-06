/*
Autor: Davis Arapa
Fecha de Creación: 20/09/2025
Fecha de Última Modificación: 23/09/2025

Descripción:
Muestra un resumen de los datos escritos.

 */

package com.example.practica4_comunicacionactividades

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class PC1_ResumenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pc1_activity_resumen)

        val usuario = intent.getSerializableExtra("USUARIO") as? PC1_Usuario ?: return

        // Mostrar datos en TextViews individuales
        findViewById<TextView>(R.id.tvNombre).text = "Nombre: ${usuario.nombre}"
        findViewById<TextView>(R.id.tvEdad).text = "Edad: ${usuario.edad} años"
        findViewById<TextView>(R.id.tvCiudad).text = "Ciudad: ${usuario.ciudad}"
        findViewById<TextView>(R.id.tvCorreo).text = "Email: ${usuario.email}"

        val confirmar = findViewById<Button>(R.id.btnConfirmar)
        val editar = findViewById<Button>(R.id.btnConfirmar)

        // Botón Confirmar → devuelve resultado OK y cierra
        confirmar.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        // Botón Volver a editar → devuelve resultado CANCELED y cierra
        editar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

    }
}