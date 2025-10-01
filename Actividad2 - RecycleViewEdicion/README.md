# 📱 Práctica Guiada: RecyclerView con Edición y Long Click

## 📘 Introducción

`RecyclerView` es un componente poderoso de Android para mostrar listas de datos de manera eficiente. Cada elemento de la lista se maneja mediante un `ViewHolder`, y un `Adapter` es responsable de enlazar los datos con las vistas correspondientes.

---

## Objetivos de la práctica

1. Detectar un **long click** sobre un elemento del `RecyclerView`.
2. Mostrar un **menú de opciones** con `AlertDialog` (Editar o Eliminar).
3. Abrir un **diálogo personalizado** para editar un usuario (nombre, edad, correo).
4. Actualizar los datos del `RecyclerView` usando `notifyItemChanged()`.

---

## Introducción a los diálogos en Android

Un **diálogo** en Android es una ventana emergente que aparece sobre la pantalla actual. Se utiliza para mostrar mensajes, confirmar acciones o pedir información del usuario sin necesidad de cambiar de pantalla.

### Ejemplo básico de `AlertDialog`:

```kotlin
AlertDialog.Builder(this)
    .setTitle("Confirmación")
    .setMessage("¿Seguro que quieres continuar?")
    .setPositiveButton("Sí") { _, _ ->
        // Acción si acepta
    }
    .setNegativeButton("No", null)
    .show()
```

## Archivos Modificados
```
app/
├── java/com.example.actividad2_recycleview/
│ ├── UsuarioAdapter.kt
│ ├── UsuarioViewHolder.kt
│ ├── Usuario.kt
└── res/layout/
├── activity_main.xml
├── item_usuario.xml
├── dialog_edit_usuario.xml
```