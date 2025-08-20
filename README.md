# Taller Móvil 1 - Lista de Usuarios

## Descripción del Proyecto

Esta aplicación Android desarrollada en Kotlin con Jetpack Compose muestra una lista de usuarios obtenidos desde una API externa. El proyecto implementa navegación entre pantallas, gestión de estado con ViewModel, y una interfaz de usuario moderna con Material Design 3.

## Características Principales

### 🎨 Interfaz de Usuario
- **Lista de Usuarios**: Pantalla principal que muestra todos los usuarios en tarjetas con diseño moderno
- **Detalles de Usuario**: Pantalla de detalle que muestra información completa del usuario seleccionado
- **Avatares Mejorados**: Imágenes de perfil con bordes degradados y indicadores de estado en línea
- **Diseño Responsivo**: Interfaz adaptable con Material Design 3

### 🔧 Funcionalidades Técnicas
- **Navegación**: Sistema de navegación entre pantallas usando Navigation Compose
- **Gestión de Estado**: Implementación con ViewModel y StateFlow
- **Carga de Imágenes**: Integración con Coil para carga asíncrona de imágenes
- **Consumo de API**: Cliente HTTP para obtener datos de usuarios desde JSONPlaceholder
- **Arquitectura MVVM**: Separación clara de responsabilidades

### 📱 Mejoras Visuales Implementadas
- **Avatares con Gradiente**: Bordes circulares con degradado de colores
- **Indicadores de Estado**: Puntos verdes que muestran el estado "en línea" de los usuarios
- **Sombras y Elevación**: Efectos visuales que mejoran la profundidad de la interfaz
- **Transiciones Suaves**: Animaciones entre pantallas

## Estructura del Proyecto

```
app/src/main/java/com/example/userlistapp/
├── data/
│   └── User.kt                 # Modelo de datos del usuario
├── navigation/
│   └── Navigation.kt           # Configuración de navegación
├── network/
│   └── ApiClient.kt           # Cliente para consumo de API
├── ui/
│   ├── UserListScreen.kt      # Pantalla principal con lista
│   └── UserDetailScreen.kt    # Pantalla de detalles
├── viewmodel/
│   └── UserViewModel.kt       # Lógica de negocio y estado
└── MainActivity.kt            # Actividad principal
```

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework de UI declarativo
- **Material Design 3**: Sistema de diseño de Google
- **Navigation Compose**: Navegación entre pantallas
- **ViewModel**: Gestión de estado y ciclo de vida
- **Retrofit**: Cliente HTTP para consumo de APIs
- **Coil**: Carga de imágenes asíncrona
- **Kotlinx Serialization**: Serialización JSON

## Instalación y Ejecución

### Prerrequisitos
- Android Studio Arctic Fox o superior
- JDK 11 o superior
- SDK de Android API 24 o superior

### Pasos para ejecutar

1. **Clonar el repositorio**
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd TallerMovil1
   ```

2. **Abrir en Android Studio**
   - Abrir Android Studio
   - Seleccionar "Open an existing project"
   - Navegar hasta la carpeta del proyecto

3. **Sincronizar dependencias**
   ```bash
   ./gradlew build
   ```

4. **Ejecutar la aplicación**
   - Conectar un dispositivo Android o iniciar un emulador
   - Hacer clic en "Run" o usar el comando:
   ```bash
   ./gradlew app:installDebug
   ```

## API Utilizada

La aplicación consume datos de [JSONPlaceholder](https://jsonplaceholder.typicode.com/), una API REST gratuita para pruebas y prototipos.

**Endpoint utilizado:**
- `GET https://jsonplaceholder.typicode.com/users` - Obtiene la lista de usuarios

## Funcionalidades de la Aplicación

### Pantalla Principal (UserListScreen)
- Muestra una lista scrolleable de usuarios
- Cada usuario se presenta en una tarjeta con:
  - Avatar circular con borde degradado
  - Nombre completo
  - Email
  - Indicador de estado en línea
  - Flecha de navegación
- Header fijo con contador total de usuarios

### Pantalla de Detalles (UserDetailScreen)
- Información completa del usuario seleccionado:
  - Avatar grande con efectos visuales mejorados
  - Datos personales (nombre, email, teléfono)
  - Información de dirección
  - Datos de la empresa
  - Sitio web
- Botón de regreso a la lista principal

## Arquitectura del Código

### Patrón MVVM
- **Model**: Clases de datos (`User.kt`)
- **View**: Composables de UI (`UserListScreen.kt`, `UserDetailScreen.kt`)
- **ViewModel**: Lógica de negocio (`UserViewModel.kt`)

### Gestión de Estado
- Uso de `StateFlow` para estado reactivo
- `collectAsState()` para observar cambios en la UI
- Estados de carga, éxito y error

## Mejoras Implementadas

### Versión Inicial
- Lista básica de usuarios
- Navegación simple
- Diseño estándar

### Mejoras Visuales
- ✅ Avatares con bordes degradados
- ✅ Indicadores de estado en línea
- ✅ Sombras y efectos de profundidad
- ✅ Mejoras en la pantalla de detalles
- ✅ Eliminación de funcionalidades innecesarias

## Autor

**Desarrollado por:** 
-Santiago Avila Barbudo
-Sandra Vanesa Florez Mayorga
## Contribución

Este proyecto fue desarrollado como parte del Taller Móvil 1, enfocándose en:
- Implementación de interfaces modernas con Jetpack Compose
- Consumo de APIs REST
- Navegación entre pantallas
- Gestión de estado con ViewModel
- Aplicación de principios de Material Design

## Licencia

Este proyecto es de uso educativo para el Taller Móvil 1.

---

**Desarrollado con ❤️ por Santiago Y Vanesa usando Kotlin y Jetpack Compose**
