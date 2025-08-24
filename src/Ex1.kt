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

fun calcDinero(sal: Float, punt: Int) = sal * (punt.toFloat()/10)
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
fun verificacion(puntuacion: Int, salario: Float): Boolean {
    if (puntuacion > 10 || puntuacion<0){
        println("puntuacion $puntuacion fuera de rango....")
    }
    else if (salario < 0.0){
        println("el monto del salario es negativo: $salario")
    }
    else{
        return false
    }
    println("Vuelva a ingresar los datos....")
    return true

}
fun main(){
    var puntuacion: Int
    var salario: Float

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

