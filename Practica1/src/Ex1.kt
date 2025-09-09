// Description: Exercise N°1
/*
1.	Escribir un programa que lea la puntuación del usuario y su salario mensual e imprima su nivel de rendimiento,
así como la cantidad de dinero que recibirá el usuario.
Ejemplo: Salario 10,000; Puntuación 8. Dinero = 10,000 * (8/10)= 8000. Resultado: Nivel de Rendimiento
Aceptable, Cantidad de Dinero Recibido $8000.
*/

// Author: Davis Arapa
// Creation Date: 22/08/2025
// Last Modification Date: 23/08/2025

// Calcula la bonificación basada en el salario y la puntuación (escala de 0 a 10)
fun calcDinero(sal: Float, punt: Int) = sal * (punt.toFloat()/10)

// Determina el nivel de rendimiento según la puntuación
fun calcRendimineto(punt: Int): String {
    var rend: String

    when (punt) {
        0,1,2,3 -> rend = "Inaceptable"
        4,5,6 -> rend = "Aceptable"
        7,8,9,10 -> rend = "Meritorio"
        else -> rend = "Fuera de Rango"
    }
    return rend
}

// Valida que la puntuación esté entre 0 y 10, y que el salario no sea negativo
// Retorna true si hay error (para repetir el ingreso)
fun verificacion(puntuacion: Int, salario: Float): Boolean {
    if (puntuacion > 10 || puntuacion<0){
        println("puntuacion $puntuacion fuera de rango....")
    }
    else if (salario < 0.0){
        println("el monto del salario es negativo: $salario")
    }
    else{
        return false // Datos válidos
    }
    println("Vuelva a ingresar los datos....")
    return true // Datos inválidos, repetir entrada

}
fun main(){
    var puntuacion: Int
    var salario: Float

    // Bucle que se repite hasta que los datos ingresados sean válidos
    do {
        println("Ingrese la puntuación entre [ 0 - 10 ] : ")
        puntuacion = readln().toInt()
        println("Ingrese el salario mensual: ")
        salario = readln().toFloat()

    } while ( verificacion(puntuacion, salario) )


    println("=".repeat(10) + " RESULTADO " + "=".repeat(10))
    println("El rendimiento del trabajor es: ")
    println( calcRendimineto(puntuacion) )
    println("El dinero total del trabajor es: ")
    println( calcDinero(salario, puntuacion) )
}

