/*
Author: Davis Arapa
Creation Date: 31/08/2025
Last Modification Date: 31/08/2025

Description:
Sistema de Gestión de Biblioteca: Diseña un sistema de gestión de biblioteca que incluya las siguientes clases e interfaces:

Material: Una clase base abstracta que tiene propiedades como título, autor, anioPublicacion, y un metodo abstracto para mostrarDetalles().
Libro: Una subclase de Material que tiene propiedades adicionales como género, número páginas y un metodo para mostrar los detalles del libro.
Revista: Una subclase de Material que tiene propiedades como issn, volumen, número, editorial y un metodo para mostrar los detalles de la revista.
Usuario: Una data class que tiene propiedades como nombre, apellido, edad.
IBiblioteca: Una interfaz que contenga los métodos registrar material, registrar usuario, préstamo, devolución, mostrar materiales disponibles
y mostrar materiales reservados por usuario.
Biblioteca: Una clase que gestiona las operaciones de préstamo y devolución. Debe implementar la interfaz anterior. Debe tener una lista de
materiales disponibles, así como un Map de usuarios donde la clase es el usuario y el valor una lista de materiales que tiene en préstamo.

Crear instancias de las subclases y ejecutar las operaciones de préstamo y devolución para cada instancia.

 */


abstract class Material(titulo: String, autor: String, anioPublicacion: String) {
    // Propiedades del material
    var titulo: String = ""
    var autor: String = ""
    var anioPublicacion: String = ""

    // Inicializador para asignar los valores
    init {
        this.titulo = titulo
        this.autor = autor
        this.anioPublicacion = anioPublicacion
    }

    // Metodo para mostrar la información del material
    fun mostrarInfo() {
        println("   + titulo: $titulo")
        println("   + autor: $autor")
        println("   + año de publicacion: $anioPublicacion")
    }

    // Metodo abstracto
    abstract fun mostrarDetalles()
}

// Clase que representa un libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: String,
    var genero: String,
    var numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {

    // Metodo específico para mostrar los detalles de un libro
    fun detallesLibro() {
        println("   + genero : $genero")
        println("   + numero de paginas: $numeroPaginas \n")
    }

    // Implementación del metodo abstracto de Material
    override fun mostrarDetalles() {
        mostrarInfo()
        detallesLibro()
    }
}

// Clase que representa una revista
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: String,
    var issn: Int,
    var volumen: String,
    var numero: String,
    var editorial: String
) : Material(titulo, autor, anioPublicacion) {

    // Metodo para mostrar los detalles de una revista
    fun detallesRevista() {
        println("   + issn: $issn")
        println("   + volumen: $volumen")
        println("   + numero: $numero")
        println("   + editorial: $editorial \n")
    }

    // metodo abstracto de Material
    override fun mostrarDetalles() {
        mostrarInfo()
        detallesRevista()
    }
}

// Clase para representar un usuario
data class Usuario(
    var nombre: String = "",
    var apellido: String = "",
    var edad: Int = 0
)

// Interfaz del comportamiento de una biblioteca
interface iBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun realizarPrestamo(usuario: Usuario, material: Material)
    fun procesarDevolucion(usuario: Usuario, material: Material)
    fun materialDisponible()
    fun materialReservado(usuario: Usuario)
}

// Implementación
class Biblioteca : iBiblioteca {
    // Lista de materiales disponibles
    var materialDisponible = mutableListOf<Material>()

    // Lista de usuarios registrados
    var usuarios = mutableListOf<Usuario>()

    // Mapa de préstamos: usuario -> lista de materiales prestados
    var prestamos: MutableMap<Usuario, MutableList<Material>> = mutableMapOf()

    // Agrega un material a la lista de disponibles
    override fun registrarMaterial(material: Material) {
        materialDisponible.add(material)
        println(" '${material.titulo}' agregado correctamente")
    }

    // Registra un usuario en la biblioteca
    override fun registrarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        println(" usuario ${usuario.nombre} agregado correctamente")
    }

    // Realiza un préstamo de material a un usuario
    override fun realizarPrestamo(usuario: Usuario, material: Material) {
        if (usuario !in usuarios) {
            println("Usuario no registrado.")
            return
        }

        if (material !in materialDisponible) {
            println("El material no está disponible.")
            return
        }

        materialDisponible.remove(material)
        if (usuario in prestamos) {
            prestamos[usuario]?.add(material)
        } else {
            prestamos[usuario] = mutableListOf(material)
        }
        println("Se presto '${material.titulo}' a ${usuario.nombre}")
    }

    // Procesa la devolución de un material prestado
    override fun procesarDevolucion(usuario: Usuario, material: Material) {
        val materialPrestado = prestamos[usuario]
        if (materialPrestado != null && materialPrestado.contains(material)) {
            materialPrestado.remove(material)
            materialDisponible.add(material)
            println("'${material.titulo}' devuelto por ${usuario.nombre}")
        } else {
            println("El usuario no tiene este material en préstamo.")
        }
    }

    // Muestra los materiales disponibles
    override fun materialDisponible() {
        println("\nMateriales disponibles:")
        if (materialDisponible.isEmpty()) {
            println("   (No hay materiales disponibles)")
        }
        for (material in materialDisponible) {
            material.mostrarDetalles()
        }

    }

    // Muestra los materiales prestados a un usuario
    override fun materialReservado(usuario: Usuario) {
        println("\nMateriales prestados a ${usuario.nombre}:")
        val materiales = prestamos[usuario]
        if (materiales == null || materiales.isEmpty()) {
            println("   (Ningún material en préstamo)")
        } else {
            for (material in materialDisponible) {
                material.mostrarDetalles()
            }

        }
    }
}


fun main() {
    val biblioteca = Biblioteca()

    // Crear usuarios
    val usuario1 = Usuario("Lucía", "Pérez", 21)
    val usuario2 = Usuario("Carlos", "García", 35)

    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    // Crear materiales (libros y revistas)
    val libro1 = Libro("1984", "George Orwell", "1949", "Distopía", 328)
    val libro2 = Libro("El Principito", "Antoine de Saint-Exupéry", "1943", "Fábula", 96)
    val revista1 = Revista("National Geographic", "Varios", "2023", 123456, "Vol. 150", "N° 3", "NatGeo")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(libro2)
    biblioteca.registrarMaterial(revista1)

    biblioteca.materialDisponible() // Mostrar materiales antes de préstamo

    // Realizar préstamos
    biblioteca.realizarPrestamo(usuario1, libro1)
    biblioteca.realizarPrestamo(usuario2, revista1)

    biblioteca.materialDisponible() // Mostrar materiales después de préstamo
    biblioteca.materialReservado(usuario1)
    biblioteca.materialReservado(usuario2)

    // Devolución de un libro
    biblioteca.procesarDevolucion(usuario1, libro1)
    biblioteca.materialDisponible() // Mostrar materiales después de devolución
}

