# Configurador de Pedido de Comida - Fragments y Navegación Manual

Este proyecto es una aplicación Android en Kotlin que demuestra el uso de Fragments y la navegación manual entre ellos sin utilizar el Navigation Component de Android Jetpack. Ideal para principiantes que desean entender los fundamentos de la gestión de Fragments.

## Objetivo
Permitir al usuario armar un pedido de comida paso a paso:

- Seleccionar el tipo de comida (pizza, hamburguesa o ensalada).
- Elegir extras (bebida, papas, postre).
- Ver un resumen del pedido.
- Confirmar o editar el pedido.

## Características Implementadas
- Navegación entre Fragments usando FragmentManager y FragmentTransaction.
- Paso de datos entre Fragments mediante Bundle y arguments.
- Comunicación de regreso usando setFragmentResult() y setFragmentResultListener().
- Uso de addToBackStack() para permitir la navegación con el botón "Atrás".
- Restauración del estado al editar el pedido.

## Requisitos
- Android Studio (versión Giraffe o superior recomendada)
- SDK de Android (nivel de API 21 o superior)
- Kotlin 1.8+

# Estructura del Proyecto

```
app/
├── java/com/example/practica5_fragmentsnavegacion/
│   ├── MainActivity.kt
│   ├── InicioFragment.kt
│   ├── SeleccionComidaFragment.kt
│   ├── SeleccionExtrasFragment.kt
│   └── ResumenPedidoFragment.kt
└── res/
    ├── layout/
    │   ├── activity_main.xml
    │   ├── fragment_inicio.xml
    │   ├── fragment_seleccion_comida.xml
    │   ├── fragment_seleccion_extras.xml
    │   └── fragment_resumen_pedido.xml
```

