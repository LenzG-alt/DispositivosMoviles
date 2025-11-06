/*
Autor: Davis Arapa
Fecha de Creación: 23/09/2025
Fecha de Última Modificación: 23/09/2025

Descripción:
Muestra la nota recibida.

 */

package com.example.practica4_comunicacionactividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.widget.TextView

class PC2_OpcionesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pc2_activity_opciones)

        // Referencias a vistas
        val textViewNota = findViewById<TextView>(R.id.textViewNota)
        val buttonCompartirCorreo = findViewById<Button>(R.id.buttonCompartirCorreo)
        val buttonEditarDeNuevo = findViewById<Button>(R.id.buttonEditarDeNuevo)

        // Obtener nota recibida
        val notaRecibida = intent.getStringExtra("nota") ?: ""
        textViewNota.text = notaRecibida

        // Botón "Compartir por correo" (solo muestra Toast)
        buttonCompartirCorreo.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
        }

        // Botón "Editar de nuevo"
        buttonEditarDeNuevo.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("nota_editada", notaRecibida)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
