# Sistema de Gestión de Inventario

## 📌 Descripción

Sistema de Gestión de Inventario es una aplicación diseñada para administrar los productos de una empresa o negocio, permitiendo registrar productos, controlar el stock, actualizar información y consultar los movimientos del inventario de manera organizada.

## 🎯 Objetivos

- Registrar y administrar productos.
- Controlar las entradas y salidas de inventario.
- Consultar la cantidad de productos disponibles.
- Identificar productos con stock bajo.
- Mantener organizada la información del inventario.

## ⚙️ Funcionalidades principales

- **Gestión de productos:** registrar, editar, consultar y eliminar productos.
- **Control de stock:** visualizar las cantidades disponibles.
- **Movimientos de inventario:** registrar entradas y salidas de productos.
- **Búsqueda de productos:** localizar productos por nombre o código.
- **Alertas de stock:** identificar productos que necesitan reposición.
- **Reportes:** consultar información general del inventario.

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.5
- Maven
- MySQL

## 📂 Estructura del proyecto

```text
SistemaGestionInventario/
├── src/main/java/com/sistemagestioninventario/
├── src/main/resources/application.properties
├── src/test/java/com/sistemagestioninventario/
├── pom.xml
└── README.md
```

## 🚀 Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
```

### 2. Ingresar al proyecto

```bash
cd SistemaGestionInventario
```

### 3. Configurar la conexión a MySQL

La aplicación usa por defecto la base de datos `sistema_inventario` en `localhost:3306`, con el usuario `root` y contraseña vacía. Puedes personalizar la conexión mediante estas variables de entorno:

- `DB_URL`: URL JDBC de MySQL.
- `DB_USERNAME`: usuario de MySQL.
- `DB_PASSWORD`: contraseña de MySQL.

### 4. Ejecutar y probar

```bash
mvn spring-boot:run
mvn test
```

## 👥 Equipo de desarrollo

| Integrante | Responsabilidad |
|---|---|
| Integrante 1 | Desarrollo del backend |
| Integrante 2 | Desarrollo del frontend |
| Integrante 3 | Base de datos y pruebas |

## 📋 Gestión del proyecto

Las actividades y tareas del equipo se organizan mediante **GitHub Projects**, utilizando un tablero para visualizar el progreso.

Estados de las tareas:

- 📌 Por hacer
- 🔄 En progreso
- 👀 En revisión
- ✅ Completado

## 🧪 Pruebas

Se deben realizar pruebas para verificar:

- El registro correcto de productos.
- La actualización de cantidades en el inventario.
- El control de entradas y salidas.
- La validación de datos incorrectos.
- La prevención de cantidades de stock negativas.

## 🔮 Mejoras futuras

- Implementar autenticación y roles de usuario.
- Generar reportes en PDF o Excel.
- Incorporar códigos de barras.
- Agregar notificaciones de stock mínimo.
- Implementar un historial detallado de movimientos.

## 📄 Licencia

Este proyecto se desarrolla con fines académicos. La licencia definitiva se establecerá según las condiciones acordadas por el equipo.

---

**Sistema de Gestión de Inventario**  
Proyecto de desarrollo de software.
Ultimos cambios
