/*
Autor: Davis Arapa
Fecha de Creación: 23/09/2025
Fecha de Última Modificación: 23/09/2025

Descripción:
Permitir al usuario escribir una nota, enviarla a otra actividad para elegir compartirla o volver a editar.


 */

package com.example.practica4_comunicacionactividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts


class PC2_EditorActivity : ComponentActivity() {
    lateinit var editTextNota: EditText
    lateinit var btnCompartir: Button

    // Recibe resultado de PC2_OpcionesActivity
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val notaEditada = result.data?.getStringExtra("nota_editada")
            if (!notaEditada.isNullOrBlank()) {
                editTextNota.setText(notaEditada)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pc2_activity_editor)

        // Referencias a vistas
        editTextNota = findViewById(R.id.editTextNota)
        btnCompartir = findViewById(R.id.buttonCompartir)
        val btnVolver = findViewById<Button>(R.id.btnEjercicio)

        // Restaurar nota si hay estado guardado
        if (savedInstanceState != null) {
            editTextNota.setText(savedInstanceState.getString("nota", ""))
        }

        // Botón "Compartir"
        btnCompartir.setOnClickListener {
            val nota = editTextNota.text.toString()
            val intent = Intent(this, PC2_OpcionesActivity::class.java).apply {
                putExtra("nota", nota)
            }
            launcher.launch(intent)
        }

        // Botón "Volver"
        btnVolver.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }

    // Guardar nota escrita
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nota", editTextNota.text.toString())
    }
}