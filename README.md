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
- **Consumo de API Completo**: Cliente HTTP que descarga TODOS los usuarios mediante paginación automática
- **Paginación Transparente**: Múltiples llamadas HTTP internas concatenadas en una sola lista
- **Arquitectura MVVM**: Separación clara de responsabilidades
- **Carga Offline**: Los datos permanecen disponibles sin conexión una vez cargados

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

La aplicación consume datos de [DummyJSON](https://dummyjson.com/), una API REST gratuita para pruebas y prototipos.

**Endpoints utilizados:**
- `GET https://dummyjson.com/users` - Obtiene la primera página de usuarios
- `GET https://dummyjson.com/users?limit=100&skip=X` - Obtiene páginas específicas para carga completa

**Funcionalidad de Paginación:**
- La aplicación descarga automáticamente TODOS los usuarios disponibles
- Utiliza múltiples llamadas HTTP internas con paginación de 100 usuarios por página
- Concatena todos los resultados en una sola lista para la interfaz de usuario
- El usuario ve una carga única y completa de todos los datos

## Funcionalidades de la Aplicación

### Pantalla Principal (UserListScreen)
- Muestra una lista scrolleable con TODOS los usuarios de la API
- Cada usuario se presenta en una tarjeta con:
  - Avatar circular con borde degradado
  - Nombre completo
  - Nombre de la empresa
  - Indicador de estado en línea
  - Flecha de navegación
- Header fijo con contador total real de usuarios cargados
- Carga automática de todos los usuarios mediante paginación transparente

### Pantalla de Detalles (UserDetailScreen)
- Información completa y detallada del usuario seleccionado:
  - Avatar grande con efectos visuales mejorados
  - **Información Personal**: Nombre, apellido, edad, género, email, teléfono
  - **Información Profesional**: Empresa, departamento, título del trabajo
  - **Apariencia Física**: Altura, peso, color de ojos, tipo de cabello
  - **Ubicación**: Dirección completa, ciudad, estado, código postal, coordenadas
  - **Información Bancaria**: Número de tarjeta, IBAN, moneda
  - **Criptomonedas**: Moneda, wallet, red blockchain
- Navegación sin consultas adicionales (usa datos ya cargados)
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

## Historial de Versiones y Mejoras

### 📋 Versión 1.0 - Implementación Inicial
**Funcionalidades básicas:**
- Lista simple de usuarios desde JSONPlaceholder API
- Navegación básica entre pantallas
- Diseño estándar con Material Design
- Carga de solo la primera página de usuarios (limitado)
- Información mínima en pantalla de detalles

### 🎨 Versión 2.0 - Mejoras Visuales
**Cambios implementados:**
- ✅ **Avatares Mejorados**: Bordes circulares con degradado de colores
- ✅ **Indicadores de Estado**: Puntos verdes que muestran estado "en línea"
- ✅ **Efectos Visuales**: Sombras y elevación para mayor profundidad
- ✅ **Pantalla de Detalles Mejorada**: Diseño más atractivo y organizado
- ✅ **Optimización de UI**: Eliminación de elementos innecesarios
- ✅ **Responsive Design**: Mejor adaptación a diferentes tamaños de pantalla

### 🚀 Versión 3.0 - Funcionalidad Completa (Actual)
**Cambios arquitectónicos y funcionales:**

#### 🔄 Migración de API
- **ANTES**: JSONPlaceholder (datos limitados)
- **AHORA**: DummyJSON (datos completos y realistas)

#### 📊 Sistema de Paginación Completa
- **ANTES**: Solo primera página (10-30 usuarios)
- **AHORA**: Descarga automática de TODOS los usuarios disponibles
- **Implementación**: 
  - Función `getUsersPage(limit, skip)` para páginas específicas
  - Función `getAllUsers()` que concatena todas las páginas automáticamente
  - Paginación transparente de 100 usuarios por llamada
  - Total de usuarios reales mostrado en header

#### 📱 Pantalla de Lista Optimizada
- **ANTES**: Información básica (nombre, email)
- **AHORA**: Información relevante (nombre, empresa, avatar mejorado)
- **CONTADOR**: Header muestra cantidad total real de usuarios cargados

#### 📄 Pantalla de Detalles Expandida
- **ANTES**: Datos básicos del usuario
- **AHORA**: Información completa organizada en secciones:
  - 👤 **Personal**: Nombre, edad, género, contacto
  - 💼 **Profesional**: Empresa, departamento, título
  - 🎯 **Física**: Altura, peso, color de ojos, cabello
  - 📍 **Ubicación**: Dirección completa con coordenadas
  - 💳 **Bancaria**: Tarjeta, IBAN, moneda
  - ₿ **Crypto**: Wallet, moneda, red blockchain

#### ⚡ Optimizaciones de Rendimiento
- **Navegación Sin Red**: Detalles usan datos ya cargados
- **Persistencia**: Datos disponibles offline una vez descargados
- **Gestión de Estado**: Mejor manejo de loading y errores
- **Arquitectura**: Separación clara entre paginación y presentación

### 🔧 Cambios Técnicos Específicos

#### Archivos Modificados:
1. **`ApiClient.kt`**:
   - ➕ Agregada función `getUsersPage(limit: Int, skip: Int)`
   - ➕ Implementada función `getAllUsers()` con lógica de paginación
   - 🔄 Mantenida compatibilidad con `getUsers()` original

2. **`UserViewModel.kt`**:
   - 🔄 Cambiado `apiClient.getUsers()` por `apiClient.getAllUsers()`
   - ⚡ Optimizada carga para manejar mayor cantidad de datos

3. **`UserListScreen.kt`**:
   - 📊 Header actualizado para mostrar total real de usuarios
   - 🎨 Mantenido diseño visual mejorado
   - 📱 Optimizada para listas grandes con scroll eficiente

4. **`UserDetailScreen.kt`**:
   - 📄 Expandida para mostrar toda la información disponible
   - 🎨 Organizada en secciones temáticas
   - 💫 Mantenidos efectos visuales mejorados

### 📈 Métricas de Mejora
- **Usuarios mostrados**: De ~30 a 200+ usuarios
- **Información por usuario**: De 4 campos a 20+ campos
- **Llamadas de red en detalles**: De 1 adicional a 0
- **Experiencia offline**: De limitada a completa
- **Tiempo de carga inicial**: Optimizado para carga completa

## Autor

**Desarrollado por:** 
Santiago Avila Barbudo
Sandra Vanesa Florez Mayorga
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