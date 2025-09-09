// Description: Exercise N°2
/*
2. Piedra, Papel, Tijera. Escriba un programa que realice el juego de piedra, papel o tijera.
La computadora debe elegir de manera aleatoria la opción a elegir. Después debe preguntar al
usuario que opción quiere. Imprimir si ganó, perdió o empató.

*/

// Author: Davis Arapa
// Creation Date: 23/08/2025
// Last Modification Date: 23/08/2025

import kotlin.random.Random

// Convierte un número (1,2,3) en su representación textual (PIEDRA, PAPEL, TIJERA)
fun eleccion(option:Int): String{
    var objeto: String = ""
    when {
        option == 1 -> objeto = "PIEDRA"
        option == 2 -> objeto = "PAPEL."
        option == 3 -> objeto = "TIJERA"
    }
    return objeto
}

// Lógica principal del juego: compara elección del usuario vs programa
fun yanKenPo(userOption:Int){
    var progOption = (1..3).random()

    println("\n [     YOU     ] VS [   PROGRAM   ] ")
    println(" [   (${eleccion(userOption)})  ] VS [   (${eleccion(progOption)})  ]")

    // Lógica para determinar ganador: (user+1)%3 == prog-1 → gana usuario
    if((userOption+1)%3 == progOption-1){
        print("+".repeat(10))
        print(" G A N A S T E !!!! >:D ")
        print("+".repeat(10) + "\n")
    }
    else if((progOption+1)%3 == userOption-1){
        print("-".repeat(10))
        print(" P E R D I S T E !!!! :(")
        print("-".repeat(10)+ "\n")
    }
    else{
        print("=".repeat(10))
        print(" E M P A T E !!! -_-")
        print("=".repeat(10)+ "\n")
    }

}

// Muestra el menú y obtiene la opción del usuario con validación
fun inputOption(): Int{
    var userOption: Int
    println("=".repeat(40))
    println(" [1] PIEDRA [2] PAPEL [3] TIJERA [0] SAlIR")
    print("        | Ingrese su opcion >>> ")
    userOption = readln().toInt()

    // Validación: opción debe ser 0, 1, 2 o 3
    while(userOption>=4){
        println("Opcion invalida - vuelva a ingresar: ")
        print("        | Ingrese su opcion >>> ")
        userOption = readln().toInt()
    }

    return userOption
}
fun main(){
    var userOption = -1
    while(true){
        userOption = inputOption()
        if(userOption==0) break // Salir del juego
        yanKenPo(userOption)
        println(" ")
    }
    println("Saliendo .... ")
}