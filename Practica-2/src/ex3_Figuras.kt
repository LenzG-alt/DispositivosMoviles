/*
Author: Davis Arapa
Creation Date: 31/08/2025
Last Modification Date: 31/08/2025

Description:
Figuras: Cree una clase abstracta “shape” la cual contenga las propiedades área, perímetro y las funciones
para calcular estos valores e imprimir el resultado de cada operación. Adicional crea tres subclases
cuadrado, círculo y rectángulo que reciban los valores de sus lados, el radio en el caso del círculo con
constructores secundarios y heredando la clase “shape” y sus métodos. Crear instancias de las subclases y
ejecutar las operaciones de área y perímetro para cada instancia.

 */
import kotlin.math.PI

// Clase abstracta Figura que define propiedades comunes y métodos abstractos
abstract class Figura(var nombre: String) {
    var area: Double = 0.0 // Propiedad para almacenar el área calculada
    var perimetro: Double = 0.0 // Propiedad para almacenar el perímetro calculado

    // Métodos abstractos que deben implementar las subclases para calcular área y perímetro
    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    // Metodo que llama a los cálculos y muestra la información de la figura
    fun mostrarInfo() {
        calcularArea() // Calcula el área para la figura
        calcularPerimetro() // Calcula el perímetro para la figura

        println("========= $nombre =========")
        println("El area total es: $area")
        println("Perimetro total es: $perimetro")
    }
}

// Subclase Cuadrado que hereda de Figura y define cómo calcular área y perímetro
class Cuadrado(var lado: Double) : Figura("CUADRADO") {
    override fun calcularArea() {
        area = lado * lado // Área del cuadrado: lado al cuadrado
    }
    override fun calcularPerimetro() {
        perimetro = lado * 4 // Perímetro del cuadrado: 4 veces el lado
    }
}

// Subclase Rectangulo que hereda de Figura y define cálculo de área y perímetro
class Rectangulo(var base: Double, var altura: Double) : Figura("RECTANGULO") {
    override fun calcularArea() {
        area = base * altura // Área del rectángulo: base por altura
    }
    override fun calcularPerimetro() {
        perimetro = 2 * altura + 2 * base // Perímetro: suma de todos los lados
    }
}

// Subclase Circulo que hereda de Figura y define cálculo de área y perímetro
class Circulo(var radio: Double) : Figura("CIRCULO") {
    override fun calcularArea() {
        area = PI * radio * radio // Área del círculo: π por radio al cuadrado
    }
    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio // Perímetro (circunferencia): 2πr
    }
}

// Función principal para crear instancias y mostrar información
fun main() {
    val cuadrado = Cuadrado(4.0) // Crear cuadrado con lado 4.0
    val rectangulo = Rectangulo(4.0, 10.0) // Crear rectángulo con base 4.0 y altura 10.0
    val circulo = Circulo(4.0) // Crear círculo con radio 4.0

    // Mostrar información de cada figura (área y perímetro)
    cuadrado.mostrarInfo()
    rectangulo.mostrarInfo()
    circulo.mostrarInfo()
}