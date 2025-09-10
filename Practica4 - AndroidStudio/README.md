# 📱 Ciclo de Vida de una Activity en Android

## 📌 Descripción
Este proyecto es una práctica guiada para comprender el **ciclo de vida de una Activity** en Android.  
La aplicación muestra un **contador** que aumenta al presionar un botón y **conserva su valor**, gracias al uso de `onSaveInstanceState` y `onRestoreInstanceState`.  

Además, se muestran mensajes en:
- 📝 **Consola (Logcat)** → usando `Log.d` con la etiqueta `CICLO`.  
- 🔔 **Pantalla (Toast)** → en cada etapa del ciclo de vida.

---

## 🚀 Funcionalidades
1. **Contador interactivo** → aumenta al presionar el botón.   
2. **Mensajes de depuración** → visualización de cada método del ciclo de vida.  

---

## 🛠️ Tecnologías y librerías usadas
- **Lenguaje:** Kotlin  
- **IDE:** Android Studio  

## 🔄 Ciclo de vida implementado
En MainActivity.kt se usan los siguientes métodos:

- onCreate()
- onStart()
- onResume()
- onPause()
- onStop()
- onDestroy()
- onSaveInstanceState()
- onRestoreInstanceState()

Cada uno muestra mensajes con Toast y en Logcat.
