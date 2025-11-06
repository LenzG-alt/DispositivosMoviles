/*
Author: Davis Arapa
Creation Date: 31/08/2025
Last Modification Date: 31/08/2025

Description:
Clase para Cuenta Bancaria: Diseña una clase CuentaBancaria que tenga un saldo y un límite de retiro.
Implementa métodos set y get para establecer y obtener el saldo, y añade un metodo para realizar retiros
que tenga en cuenta el límite de retiro. Utilice el set para validar datos.
 */

// Clase que representa una cuenta bancaria con saldo y límite de retiro
class CuentaBancaria(saldo: Double, limRetiro: Double = 500.0) {

    // Propiedad del saldo actual (con validación privada en el setter)
    var saldo: Double = saldo
        private set(value) {
            require(saldo > 0.0) { "ERROR: Saldo Negativo" }  // Validación
            field = value
        }

    // Límite de retiro diario (también con setter privado y validación)
    var limRetiro: Double = 500.0
        private set(value) {
            require(limRetiro > 0.0) { "ERROR: Límite debe ser positivo" }
            field = value
        }

    // Bloque init: se ejecuta al crear una instancia, asigna valores usando setters
    init {
        this.saldo = saldo
        this.limRetiro = limRetiro
    }

    // Metodo para depositar dinero a la cuenta
    fun depositar(monto: Double) {
        if (monto < 0) {
            println("No puedes depositar un monto negativo")
            return
        }

        saldo += monto
        println("   Operación exitosa: $$monto depositado correctamente")
    }

    // Metodo para retirar dinero de la cuenta
    fun retirar(monto: Double) {
        if (monto < 0) {
            println("No puedes retirar un monto negativo")
            return
        }

        if (saldo < monto) {
            println("Saldo insuficiente, no puedes retirar")
            return
        }

        if (monto > limRetiro) {
            mostrarLimRetiro()
            return
        }

        saldo -= monto
        println("   Operación exitosa: $$monto retirado correctamente")
    }

    // Muestra el límite actual de retiro permitido
    fun mostrarLimRetiro() {
        println("   El límite de retiro es: $ $limRetiro")
    }
}


fun main() {
    // Se crea una cuenta con $1000 de saldo inicial
    val test = CuentaBancaria(1000.0)

    println("Saldo Disponible: $ ${test.saldo}") // Muestra saldo inicial

    test.depositar(10.0)  // Deposita $10
    println("Saldo Disponible: $ ${test.saldo}") // Muestra nuevo saldo

    test.retirar(30.0)  // Retira $30 (válido)
    println("Saldo Disponible: $ ${test.saldo}") // Muestra saldo

    test.retirar(600.0)  // Intenta retirar más del límite ($500 por defecto)
    println("Saldo Disponible: $ ${test.saldo}") // Saldo no cambia
}
