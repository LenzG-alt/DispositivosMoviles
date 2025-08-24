// Description: Exercise N°4
/*
Adivina Número. Escribe un programa que genere un número aleatorio entre 1 y 30,
luego pida al usuario que adivine el número. Proporciona pistas indicando si el
número a adivinar es mayor o menor que el número ingresado por el usuario. Continúa
solicitando intentos hasta que el usuario adivine correctamente el número.
Tienes 5 intentos, si se acaba debe imprimir game over. De lo contrario mostrar
un mensaje de felicitación por ganar el juego.

*/

// Author: Davis Arapa
// Creation Date: 23/08/2025
// Last Modification Date: 23/08/2025

import kotlin.random.Random

fun findNum(num:Int ,opcion:Int): Boolean{
    when{
        opcion<num -> println("  + El número aleatorio es mayor ...")
        opcion>num -> println("  + El número aleatorio es menor ...")
        else -> {
            println("  + Encontraste el número aleatorio ...")
            return false }
    }
    return true
}
fun Game(numRandom:Int,limSup:Int): Boolean{
    var opcion = 0
    var intentos = 0
    var flag = true

    while(flag && intentos < 5){
        print("Ingresar número >>> ")
        opcion = readln().toInt()
        if(opcion > limSup){
            println(" - - Recuerde elegir un numero entre [1 - ... - $limSup]") }
        flag = findNum(numRandom,opcion)
        intentos++
        println("  - Intentos: [ $intentos / 5 ]")
    }
    return flag

}
fun info(){
    var limSup = 30
    val numRandom = (1..limSup).random()

    var flag = false

    println("Ingresa un número para adivinar entre [1 - ... - $limSup]")
    flag = Game(numRandom,limSup)
    println("=".repeat(30))
    println("el numero aleatorio es [ $numRandom ]")
    println("=".repeat(30))

    if(flag){ println("PERDISTE...") }
    else{ println("GANASTE....") }
}

fun main(){
    info()
}