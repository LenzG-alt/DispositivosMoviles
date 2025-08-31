/*
Author: Davis Arapa
Creation Date: 31/08/2025
Last Modification Date: 31/08/2025

Description:
Clase para Producto: Diseña una clase Producto que tenga un precio y un descuento aplicable.
Implementa métodos set y get para establecer y obtener el precio y el descuento, y añade un
metodo para calcular el precio final después de aplicar el descuento. Utilice el set para validar datos.
 */

class Producto(precio: Double, descuento: Double = 0.0) {
    // Propiedad del precio, validada para que sea mayor que 0.
    var precio: Double = precio
        private set(value) {
            require(value > 0.0) { "Error: precio debe ser positivo" }
            field = value
        }

    // Propiedad del descuento, validada para que no sea negativo.
    var descuento: Double = descuento
        private set(value) {
            require(value >= 0.0) { "Error: descuento debe ser positivo" }
            field = value
        }

    // Bloque init que se ejecuta al crear un objeto de esta clase
    init {
        this.precio = precio
        this.descuento = descuento
    }

    // Nombre del producto (solo accesible dentro de la clase)
    private var nombre: String = "Producto"

    // Constructor secundario que permite incluir el nombre
    constructor(nombre: String, precio: Double, descuento: Double) : this(precio, descuento) {
        this.nombre = nombre
    }

    // Función que calcula el precio final después de aplicar el descuento
    fun calcularDescuento(): Double {
        return precio * (1 - descuento / 100)
    }

    // Función que muestra la información del producto en consola
    fun mostrarInfo()
    {
        println("\n ========= $nombre =========")
        println("El precio del producto es: $ $precio")
        println("Descuento es:  $descuento %")
        println("precio total del producto es: $ ${calcularDescuento()}")
    }
}

fun main()
{
    // Se crea una instancia de Producto con nombre, precio y descuento
    val manzana = Producto("Manzana", 2.0, 30.0)
    manzana.mostrarInfo() // Muestra los datos de la manzana

    // Otra instancia con diferentes valores
    val sandia = Producto("Sandia", 8.0, 10.0)
    sandia.mostrarInfo() // Muestra los datos de la sandía
}