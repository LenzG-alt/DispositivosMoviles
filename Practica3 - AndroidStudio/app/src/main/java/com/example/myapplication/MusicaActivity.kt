/*
Autor: Davis Arapa
Fecha de Creación: 09/09/2025
Fecha de Última Modificación: 09/09/2025

Descripción:
Crea una interfaz de usuario con botones para reproducir, pausar y detener la reproducción de música.
 */

package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.ComponentActivity

// MusicaActivity: Esta actividad permite al usuario reproducir, pausar y detener una pista de música.
class MusicaActivity : ComponentActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño para esta actividad
        setContentView(R.layout.activity_musica)

        // Obtiene referencias a los botones y la barra de búsqueda en el diseño
        val btnPlay = findViewById<ImageButton>(R.id.btnPlay)
        val btnPause = findViewById<ImageButton>(R.id.btnPause)
        val btnStop = findViewById<ImageButton>(R.id.btnStop)
        seekBar = findViewById(R.id.seekBar)

        // Establece un listener de clic para el botón "Play"
        btnPlay.setOnClickListener {
            // Si MediaPlayer no está inicializado, créalo
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.musica)
                Toast.makeText(this, "Reproduciendo", Toast.LENGTH_SHORT).show()

                // Libera el MediaPlayer cuando la canción termina
                mediaPlayer?.setOnCompletionListener {
                    it.release()
                    mediaPlayer = null
                    Toast.makeText(this, "Reproducción finalizada", Toast.LENGTH_SHORT).show()
                }
                // Establece el valor máximo de la barra de búsqueda a la duración de la música
                seekBar.max = mediaPlayer!!.duration
                // Comienza a actualizar la barra de búsqueda
                updateSeekBar()
            }
            // Comienza a reproducir la música
            mediaPlayer?.start()
        }

        // Establece un listener de clic para el botón "Pause"
        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                Toast.makeText(this, "Pausado", Toast.LENGTH_SHORT).show()
            }
        }

        // Establece un listener de clic para el botón "Stop"
        btnStop.setOnClickListener {
            if (mediaPlayer != null) {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
                seekBar.progress = 0
                Toast.makeText(this, "Detenido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // updateSeekBar: Esta función actualiza el progreso de la barra de búsqueda cada segundo.
    private fun updateSeekBar() {
        mediaPlayer?.let {
            seekBar.progress = it.currentPosition
            if (it.isPlaying) {
                handler.postDelayed({ updateSeekBar() }, 1000)
            }
        }
    }

    // onDestroy: Esta función se llama cuando la actividad se destruye.
    override fun onDestroy() {
        super.onDestroy()
        // Libera los recursos de MediaPlayer
        mediaPlayer?.release()
        mediaPlayer = null
    }
}