/*
Autor: Davis Arapa
Fecha de Creación: 23/09/2025
Fecha de Última Modificación: 23/09/2025

Descripción:
Menu principal para navegar entre ejercicios
 */

package com.example.practica4_comunicacionactividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : ComponentActivity() {

    // Lanza otra actividad y maneja su resultado
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Regresando...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones
        val buttonEjercicio1 = findViewById<Button>(R.id.buttonEjercicio1)
        val buttonEjercicio2 = findViewById<Button>(R.id.buttonEjercicio2)

        // Al hacer clic, abre PC1_FormularioActivity
        buttonEjercicio1.setOnClickListener {
            val intent = Intent(this, PC1_FormularioActivity::class.java)
            launcher.launch(intent)
        }

        // Al hacer clic, abre PC2_EditorActivity
        buttonEjercicio2.setOnClickListener {
            val intent = Intent(this, PC2_EditorActivity::class.java)
            launcher.launch(intent)
        }
    }
}

