# Practica en Android Studio

Esta es una aplicación de Android simple que demuestra dos características: una imagen interactiva y un reproductor de música.

## Características

*   **Imagen Interactiva:** Muestra una imagen que, al hacer clic, muestra un mensaje Toast.
*   **Reproductor de Música:** Un reproductor de música simple con funcionalidad de reproducción, pausa y detención.

## Cómo Usar

1.  Clona el repositorio.
2.  Abre el proyecto en Android Studio.
3.  Ejecuta la aplicación en un emulador de Android o en un dispositivo físico.
4.  Desde la pantalla principal, puedes navegar a las secciones "Imagen Interactiva" o "Reproductor de Música".

## Estructura del Proyecto

*   `MainActivity.kt`: El punto de entrada principal de la aplicación. Contiene botones para navegar a las otras actividades.
*   `ImagenActivity.kt`: Esta actividad muestra una imagen. Cuando el usuario hace clic en la imagen, se muestra un mensaje Toast.
*   `MusicaActivity.kt`: Esta actividad contiene un reproductor de música simple. Los usuarios pueden reproducir, pausar y detener una pista de música predefinida.
*   `activity_main.xml`: El archivo de diseño para `MainActivity`.
*   `activity_imagen.xml`: El archivo de diseño para `ImagenActivity`.
*   `activity_musica.xml`: El archivo de diseño para `MusicaActivity`.
*   `res/drawable`: Contiene la imagen y los recursos de iconos utilizados en la aplicación.
*   `res/raw`: Contiene el archivo de música para el reproductor de música.
