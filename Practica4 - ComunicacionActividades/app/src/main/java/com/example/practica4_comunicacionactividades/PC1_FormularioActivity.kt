/*
Autor: Davis Arapa
Fecha de Creación: 20/09/2025
Fecha de Última Modificación: 23/09/2025

Descripción:
Crear una app que permita llenar un perfil de usuario, mostrar los datos en otra pantalla y confirmar si está correcto.

 */

package com.example.practica4_comunicacionactividades

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts


class PC1_FormularioActivity : ComponentActivity() {

    // Launcher para recibir resultado de ResumenActivity
    val launcherResumen = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pc1_activity_formulario)

        // Referencias a los campos y botones
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        val btnVolver = findViewById<Button>(R.id.btnEjercicio)

        // Botón "Continuar"
        btnContinuar.setOnClickListener {
            val nombre = txtNombre.text.toString().trim()
            val edadTexto = txtEdad.text.toString().trim()
            val ciudad = txtCiudad.text.toString().trim()
            val email = txtEmail.text.toString().trim()

            // Validaciones básicas
            if (nombre.isEmpty()) {
                txtNombre.error = "Campo requerido"
                return@setOnClickListener
            }
            if (edadTexto.isEmpty()) {
                txtEdad.error = "Campo requerido"
                return@setOnClickListener
            }
            val edad = edadTexto.toIntOrNull()
            if (edad == null || edad < 0) {
                txtEdad.error = "Ingresa una edad válida"
                return@setOnClickListener
            }
            if (ciudad.isEmpty()) {
                txtCiudad.error = "Campo requerido"
                return@setOnClickListener
            }
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                txtEmail.error = "Ingresa un email válido"
                return@setOnClickListener
            }

            // Crear usuario y lanzar ResumenActivity
            val usuario = PC1_Usuario(nombre, edad, ciudad, email)
            val intent = Intent(this, PC1_ResumenActivity::class.java)
            intent.putExtra("USUARIO", usuario)
            launcherResumen.launch(intent)
        }

        // Botón "Volver"
        btnVolver.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Guardar contenido de los campos
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)

        outState.putString("nombre", txtNombre.text.toString())
        outState.putString("edad", txtEdad.text.toString())
        outState.putString("ciudad", txtCiudad.text.toString())
        outState.putString("email", txtEmail.text.toString())
    }
}
