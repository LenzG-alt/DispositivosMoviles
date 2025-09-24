# 📝 App de Ejercicios - Formulario y Editor de Notas

Este proyecto Android contiene dos funcionalidades principales:

1. **Ejercicio 1**: Formulario de usuario y resumen.
2. **Ejercicio 2**: Editor de notas con opción de compartir y editar.

## 📦 Estructura del Proyecto

### 1. `MainActivity.kt`

- Actividad principal que presenta dos botones para acceder a:
  - `PC1_FormularioActivity`
  - `PC2_EditorActivity`
- Usa `ActivityResultLauncher` para manejar resultados al volver.

---

### 2. `PC1_FormularioActivity.kt`

- Contiene un formulario para ingresar:
  - Nombre
  - Edad
  - Ciudad
  - Email
- Valida los campos y crea un objeto `PC1_Usuario`.
- Envía los datos a `PC1_ResumenActivity`.
- Permite volver al menú principal.

---

### 3. `PC1_ResumenActivity.kt`

- Recibe un objeto `PC1_Usuario` mediante `Intent` (Serializable).
- Muestra los datos en `TextView`s.
- Dos botones:
  - **Confirmar** → Finaliza y devuelve `RESULT_OK`.
  - **Editar** → Finaliza y devuelve `RESULT_CANCELED`.

---

### 4. `PC2_EditorActivity.kt`

- Pantalla para escribir una nota.
- Permite:
  - Compartir la nota a `PC2_OpcionesActivity`.
  - Volver al menú principal.
- Usa `onSaveInstanceState` para mantener el contenido.

---

### 5. `PC2_OpcionesActivity.kt`

- Muestra la nota recibida.
- Opciones:
  - **Compartir por correo** (muestra un `Toast`).
  - **Editar de nuevo** → Devuelve la nota editada.

---

### 6. `PC1_Usuario.kt`

```kotlin
data class PC1_Usuario(
    val nombre: String = "",
    val edad: Int = 0,
    val ciudad: String = "",
    val email: String = ""
) : Serializable
```