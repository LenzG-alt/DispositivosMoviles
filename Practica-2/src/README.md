# 📚 Practica 2 : Programación Orientada a Objetos Kotlin
Este proyecto está desarrollado en **Kotlin** y muestra el uso de **Programación Orientada a Objetos (POO)** como:

- Clases y objetos
- Propiedades con validaciones
- Herencia y clases abstractas
- Interfaces
- Constructores secundarios
- Data classes
- Uso de colecciones (listas y mapas)
- Encapsulamiento


---

## 🧑‍💻 Autor
- **Nombre:** Davis Arapa  
- **Fecha de Creación:** 23/08/2025  
- **Última Modificación:** 23/08/2025  

---

## 📂 Estructura del Proyecto

| Módulo | Descripción |
|-------|-------------|
| `CuentaBancaria` | Simulación de operaciones bancarias (depósito, retiro, límite) |
| `Producto` | Gestión de productos con precio y descuento |
| `Figura` | Cálculo de área y perímetro de figuras geométricas |
| `Biblioteca` | Sistema de gestión de préstamos y usuarios |

---

## 1. 💳 Cuenta Bancaria

### Descripción
Simula una cuenta bancaria básica con funcionalidades de depósito, retiro y control de límites.

### Características
- Saldo inicial positivo.
- Límite de retiro diario (por defecto: $500).
- Validación de montos negativos y fondos insuficientes.
- Uso de `private set` para proteger propiedades críticas.

### Clase Principal
```bash
class CuentaBancaria(saldo: Double, limRetiro: Double = 500.0)
```

### Métodos
- **depositar(monto)**: Aumenta el saldo si el monto es positivo
- **retirar(monto)**: Disminuye el saldo si hay fondos y no excede el límite
- **mostrarLimRetiro()** : Muestra el límite máximo de retiro

### Ejemplo de uso

```bash
val cuenta = CuentaBancaria(1000.0)
cuenta.depositar(100.0)   // Saldo: 1100
cuenta.retirar(300.0)     // Saldo: 800
cuenta.retirar(600.0)     // Error: excede límite
```


## 2. 🛒 Producto con Descuento
### Descripción
Representa un producto con precio y descuento, permitiendo calcular el precio final tras aplicar el descuento.

### Características
- Validación de precio positivo y descuento no negativo.
- Soporte para nombre opcional mediante constructor secundario.
- Cálculo automático del precio con descuento.

### Clase Principal
```bash
class Producto(nombre: String, precio: Double, descuento: Double)
```
### Métodos
```bash
calcularDescuento()
Devuelve el precio final aplicando el descuento (%)
mostrarInfo()
Muestra toda la información del producto
```

### Ejemplo de uso
```bash
val manzana = Producto("Manzana", 2.0, 30.0)
manzana.mostrarInfo()
// Salida:
// ========= Manzana =========
// El precio del producto es: $ 2.0
// Descuento es: 30.0 %
// precio total del producto es: $ 1.4
```

## 3. 📐 Figuras Geométricas
### Descripción
Sistema basado en herencia y clases abstractas para calcular el área y perímetro de figuras.

### Características
- Clase base abstracta Figura con métodos obligatorios.
I- mplementaciones para `Cuadrado`, `Rectángulo` y `Círculo`.
- Uso de PI de kotlin.math.

### Clases

| Figura | Area | Perimetro |
|-------|-------------|-------|
| Cuadrado(lado) | lado² | 4 × lado |
| Rectangulo(base, altura) | base × altura | 2×(base + altura) |
| Circulo(radio) | π × radio² | 2 × π × radio |

### Ejemplo de uso
```bash
val cuadrado = Cuadrado(4.0)
cuadrado.mostrarInfo()
// Salida:
// ========= CUADRADO =========
// El area total es: 16.0
// Perimetro total es: 16.0
```
## 4. 🏛️ Sistema de Biblioteca

### Descripción
Un sistema de gestión de biblioteca que permite registrar usuarios, materiales, realizar préstamos y devoluciones.

### Características
- Herencia con clase abstracta Material.
- Polimorfismo en Libro y Revista.
- Uso de data class para Usuario.
- Interfaz iBiblioteca para definir metodos.
- Colecciones: List, MutableMap.

### Estructura de Clases

#### 🔹 Material (abstracta): Clase base para todos los materiales bibliográficos.

#### 🔹 Libro: Extiende Material con propiedades:
  - genero: String
  - numeroPaginas: Int
    
#### 🔹 Revista: Extiende Material con propiedades:
  - issn: Int
  - volumen, numero, editorial
  - 
#### 🔹 Usuario: data class que representa a un usuario con:
  - nombre, apellido, edad
    
#### 🔹 Biblioteca (implementa iBiblioteca)
**Gestiona:**
- Materiales disponibles
- Usuarios registrados
- Préstamos activos (con mapa usuario → lista de materiales)
- Métodos de la Interfaz iBiblioteca
**registrarMaterial()**: Agrega un libro o revista al catálogo
**registrarUsuario()**: Registra un nuevo usuario
**realizarPrestamo()**: Presta un material a un usuario registrado
**procesarDevolucion()**: Devuelve un material y lo vuelve disponible
**materialDisponible()**: Muestra todos los materiales disponibles
**materialReservado(usuario)**: Muestra los materiales prestados a un usuario

### Ejemplo de uso
```bash
val biblioteca = Biblioteca()
val usuario = Usuario("Lucía", "Pérez", 21)
val libro = Libro("1984", "George Orwell", "1949", "Distopía", 328)

biblioteca.registrarUsuario(usuario)
biblioteca.registrarMaterial(libro)
biblioteca.realizarPrestamo(usuario, libro)
biblioteca.materialDisponible() // Muestra solo lo disponible
biblioteca.procesarDevolucion(usuario, libro)
```

## 🛠️ Cómo Ejecutar el Proyecto
### Requisitos
- Kotlin instalado (versión 1.8+)
- JVM (Java 8 o superior)
- Opciones de Ejecución
  
### 1. Desde terminal (Kotlin REPL o compilación)
**Compilar**
```bash
kotlinc *.kt -include-runtime -d biblioteca.jar
```
**Ejecutar**
```bash
java -jar biblioteca.jar
```

### 2. Usar kotlin directamente (si está en PATH)
- kotlin CuentaBancaria.kt
- kotlin Producto.kt
- kotlin Figura.kt
- kotlin Biblioteca.kt
  
**⚠️ Solo un main() puede ejecutarse a la vez. Comenta los otros main si corres todo en un solo archivo.**

### 3. Usar un IDE
```bash
Abre el proyecto en IntelliJ IDEA o Android Studio.
Ejecuta cualquiera de los bloques main() haciendo clic en ▶️.
```
