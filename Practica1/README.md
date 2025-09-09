# 📚 Ejercicios de Programación en Kotlin

Este repositorio contiene una serie de ejercicios básicos implementados en **Kotlin**, enfocados en practicar estructuras de control, funciones, entrada/salida, validaciones y lógica de programación. Cada ejercicio resuelve un problema específico.

---

## 🧑‍💻 Autor
- **Nombre:** Davis Arapa  
- **Fecha de Creación:** 22/08/2025  
- **Última Modificación:** 23/08/2025  

---

## 📂 Ejercicios Incluidos

### 1. 📊 Cálculo de Rendimiento y Bonificación

**Descripción:**  
Este programa calcula el nivel de rendimiento de un trabajador según una puntuación (0-10) y su salario mensual. Luego determina la bonificación que recibirá basada en la fórmula:  
`Dinero = Salario × (Puntuación / 10)`.

**Niveles de Rendimiento:**
- `0-3`: Inaceptable
- `4-6`: Aceptable
- `7-10`: Meritorio

**Validaciones:**
- Puntuación fuera del rango [0-10] → mensaje de error.
- Salario negativo → advertencia.

**Ejemplo de salida:**
```bash
Ingrese la puntuación entre [ 0 - 10 ] : 8
Ingrese el salario mensual: 10000
========== RESULTADO ==========
El rendimiento del trabajador es:
Meritorio
El dinero total del trabajador es:
8000.0
```

---

### 2. 🪨📄✂️ Juego: Piedra, Papel o Tijera

**Descripción:**  
Implementación del clásico juego "Piedra, Papel o Tijera" donde el usuario elige una opción y juega contra la computadora, que selecciona aleatoriamente.

**Opciones:**
- 1 → Piedra
- 2 → Papel
- 3 → Tijera
- 0 → Salir

**Ejemplo de salida:**
```bash
[ YOU ] VS [ PROGRAM ]
[ (PAPEL) ] VS [ (PIEDRA) ]
++++++++++ G A N A S T E !!!! >:D ++++++++++
```

El juego continúa hasta que el usuario elija salir (0).

---

### 3. 🧮 Calculadora Elemental

**Descripción:**  
Una calculadora básica que permite realizar operaciones aritméticas: suma, resta, multiplicación y división.

**Funcionalidades:**
- Menú interactivo.
- Validación de opciones (0 a 4).

**Operaciones:**
- Suma (`+`)
- Resta (`-`)
- Multiplicación (`×`)
- División (`÷`) → Resultado en `Float`.

**Ejemplo de salida:**
```bash
======== M E N U ========
[1] SUMA
[2] RESTA
[3] MULTIPLICACIÓN
[4] DIVISIÓN
[0] SALIR
Digite su opcion >>> 1

Ingrese el primer número... : 5
Ingrese el segundo número... : 3
RESULTADO DE LA OPERACIÓN : 5 + 3 = 8
```

El programa se cierra al seleccionar `0`.

---

### 4. 🔢 Adivina el Número

**Descripción:**  
Juego en el que el programa genera un número aleatorio entre 1 y 30. El usuario tiene **5 intentos** para adivinarlo. Después de cada intento, se da una pista: "mayor" o "menor".

**Reglas:**
- 5 intentos máximos.
- Si adivina → mensaje de felicitación.
- Si falla los 5 intentos → "Game Over".

**Ejemplo de salida:**
```bash
Ingresa un número para adivinar entre [1 - ... - 30]
Ingresar número >>> 15

El número aleatorio es mayor ...
Intentos: [ 1 / 5 ]
...
el numero aleatorio es [ 27 ]
GANASTE....
```