package com.example.ciclodevidaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ciclodevidaapp.ui.theme.CicloDeVidaAppTheme
import kotlin.inc
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
class MainActivity : ComponentActivity() {
    private var contador = 0
    private lateinit var textViewContador: TextView

    // onCreate(): se ejecuta al crear la Activity. Aquí inicializamos la interfaz.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewContador = findViewById(R.id.textViewContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        btnAumentar.setOnClickListener {
            contador++
            textViewContador.text = "Contador: $contador"
        }

        Log.d("CICLO", "onCreate llamado")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }

    // onStart(): la Activity es visible para el usuario.
    override fun onStart() {
        super.onStart()
        Log.d("CICLO", "onStart llamado")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()
    }

    // onResume(): la Activity está activa y lista para usarse.
    override fun onResume() {
        super.onResume()
        Log.d("CICLO", "onResume llamado")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()
    }

    // onPause(): la Activity está a punto de perder el foco (ej. llega una llamada).
    override fun onPause() {
        super.onPause()
        Log.d("CICLO", "onPause llamado")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()
    }

    // onStop(): la Activity ya no es visible.
    override fun onStop() {
        super.onStop()
        Log.d("CICLO", "onStop llamado")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()
    }

    // onDestroy(): la Activity se destruye completamente.
    override fun onDestroy() {
        super.onDestroy()
        Log.d("CICLO", "onDestroy llamado")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()
    }

    // onSaveInstanceState(): se usa para guardar el estado antes de que la Activity sea destruida.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CONTADOR", contador)
        Log.d("CICLO", "onSaveInstanceState llamado, contador guardado = $contador")
    }

    // onRestoreInstanceState(): se usa para restaurar el estado previamente guardado.
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("CONTADOR")
        textViewContador.text = "Contador: $contador"
        Log.d("CICLO", "onRestoreInstanceState llamado, contador restaurado = $contador")
    }
}











