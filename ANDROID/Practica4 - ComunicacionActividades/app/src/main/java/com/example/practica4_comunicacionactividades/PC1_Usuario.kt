package com.example.practica4_comunicacionactividades
import java.io.Serializable

// Clase de datos para representar un usuario
// Implementa Serializable para poder enviarla entre actividades
data class PC1_Usuario(
    val nombre: String = "",
    val edad: Int = 0,
    val ciudad: String = "",
    val email: String = ""
) : Serializable
