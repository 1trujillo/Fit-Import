# 🛠️ Proyecto Microservicios - Evaluación Parcial N°2

Este repositorio contiene el desarrollo de tres microservicios implementados en Spring Boot como parte de la Evaluación Parcial N°2 del ramo de Desarrollo Fullstack. Los microservicios corresponden a:

- 👤 **Usuarios**
- 📦 **Inventario**
- 🛒 **Carrito de Compras**

---

## 📁 Estructura del Repositorio

Fit-Import3-main/
│
├── usuario/ # Microservicio Usuarios
├── inventario/ # Microservicio Inventario
├── carrito/ # Microservicio Carrito de Compras
│
├── script_creacion_tablas.sql # Script SQL de base de datos
├── informe.pdf # Informe técnico del proyecto
├── endpoints.xlsx # Excel con pruebas de Postman
└── README.md # Este archivo


---

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA / Hibernate
- MySQL
- Postman
- Git y GitHub

---

## 📌 Descripción de los Microservicios

### 👤 Microservicio Usuario

- CRUD completo de usuarios.
- Endpoint base: `http://localhost:8086/api/usuarios`
- Datos: nombre, apellido, email, contraseña, teléfono, dirección, fecha de nacimiento y género.

### 📦 Microservicio Inventario

- Gestión de productos en stock.
- Endpoint base: `http://localhost:8087/api/inventario`
- Atributos clave: nombre, descripción, precio, cantidad disponible.

### 🛒 Microservicio Carrito

- Agrega, lista y elimina productos del carrito.
- Se conecta con los microservicios Usuario e Inventario para validar operaciones.
- Endpoint base: `http://localhost:8088/api/carrito`

---

## 🧪 Pruebas con Postman

- Se utilizó Postman para validar los endpoints de cada microservicio.
- Se adjunta una colección exportada con pruebas `POST`, `GET`, `PUT` y `DELETE`.
- También se incluye un archivo Excel con al menos 5 pruebas por microservicio.

---

## 🧱 Base de Datos

El archivo `script_creacion_tablas.sql` contiene:

- La creación de las tablas `usuarios`, `inventario`, y `carrito`.
- Llaves primarias, foráneas, restricciones `NOT NULL`, `UNIQUE`, y tipos de datos compatibles con las entidades de Java (JPA).

---

## 🛠️ Configuración y Ejecución

Cada microservicio es independiente y se ejecuta por separado en VS Code:

1. Abrir cada carpeta (`usuario/`, `inventario/`, `carrito/`) como proyecto individual.
2. Ejecutar con el plugin de Spring Boot o usando Maven:
   ```bash
   ./mvnw spring-boot:run
3. Cada servicio se conecta a su propia base de datos MySQL.
Repositorio Git
Rama main: versión final con entregables.

Rama develop: espacio de trabajo colaborativo.

Control de versiones realizado con Git, incluyendo múltiples commits y seguimiento de cambios.

👨‍💻 Integrantes del grupo
José Larenas Farías
Angel Castillo 
Diony Peguero


📅 Fecha de entrega
🗓️ Domingo 15 de junio de 2025
📧 Colección Postman enviada a: rox.lopezv@profesor.duoc.cl

✅ Estado del proyecto
✔️ Entregado con todos los requerimientos:

 3 microservicios funcionales

 CRUD + conexión a BD

 Pruebas con Postman

 Script SQL

 Informe PDF

 Excel con endpoints

 Estructura de proyecto Spring Boot



