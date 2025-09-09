// Description: Exercise N°3
/*
3. Calculadora Elemental. Realizar una calculadora  básica suma, resta, multiplicación, división.
Debe imprimir un menú con las opciones incluyendo una opción salir. Validar que la opción esté
disponible. Imprimir resultados.

*/

// Author: Davis Arapa
// Creation Date: 23/08/2025
// Last Modification Date: 23/08/2025

// Muestra el menú de opciones de la calculadora
fun menuInfo(){
    val menuOpc =
        """
            [1] SUMA
            [2] RESTA
            [3] MULTIPLICACIÓN
            [4] DIVISIÓN
            [0] SALIR  
        """.trimIndent()
    println("=".repeat(8) + " M E N U " + "=".repeat(8))
    println(menuOpc)
    println("=".repeat(25))
    print("   Digite su opcion >>> ")
}

// Operaciones básicas definidas como funciones simples
fun suma(num1: Int, num2:Int) = num1 + num2
fun resta(num1: Int, num2:Int) = num1 - num2
fun mult(num1: Int, num2:Int) = num1 * num2
// Manejo especial para división: evita división por cero
fun division(num1: Int, num2:Int): Float{
    if(num2==0){
        println("ERROR!# - El denominador tiene que ser diferente de 0")
        return 0.toFloat()
    }

    return num1.toFloat() / num2.toFloat()
}

// Ejecuta la operación según la opción elegida
// Retorna true si debe continuar, false si se elige salir
fun calculadora(opcion: Int): Boolean{
    var num1:Int
    var num2:Int

    if (opcion == 0){
        println("  + Saliendo....")
        return false // Finaliza el bucle principal
        }

    if (opcion>4){
        println("ERROR! Opcion Fuera de Rango...")
        return true // Continúa pidiendo opción
        }

    print("  + Ingrese el primer número... : ")
    num1 = readln().toInt()
    print("  + Ingrese el segundo número... : ")
    num2 = readln().toInt()

    print("  - RESULTADO DE LA OPERACIÓN : ")
    when (opcion) {
        1 -> print("$num1 + $num2 = ${suma(num1, num2)} ")
        2 -> print("$num1 - $num2 = ${resta(num1, num2)} ")
        3 -> print("$num1 * $num2 = ${mult(num1, num2)} ")
        4 -> print("$num1 / $num2 = ${division(num1, num2)} ")
    }
    println("\n")
    return true // Continuar en el bucle
}

fun main(){
    var opcion: Int
    do {
        menuInfo()
        opcion = readln().toInt()
    } while( calculadora(opcion) ) // Repite mientras no se elija salir

}