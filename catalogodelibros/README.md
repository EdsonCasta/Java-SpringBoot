# 📚 Catálogo de Libros

Proyecto realizado en Java con Spring Boot que permite gestionar un catálogo de libros y autores obtenidos desde una API externa.  
Es una aplicación de consola que interactúa con el usuario para guardar y consultar información en una base de datos.

---

## ✨ Funcionalidades principales

✅ **Búsqueda y almacenamiento**
- 🔍 Buscar libros por título y guardarlos en la base de datos.
- 📖 Guardar también el autor relacionado.

✅ **Consultas y listados**
- 📚 Listar todos los libros almacenados.
- 🌍 Filtrar libros por idioma.
- 🖊️ Listar todos los autores.
- 🎂 Listar autores vivos en un año específico.

✅ **Estadísticas**
- 📊 Mostrar cantidad de libros por idioma.

---

## ⚙️ Tecnologías usadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Consumo de API externa (Gutendex)
- Streams de Java

---

## 🚀 Cómo ejecutar

1️⃣ Clona el repositorio:
```bash
git clone https://github.com/EdsonCasta/Java-SpringBoot.git
```
2️⃣ Entra a la carpeta del proyecto:
```bash
cd Java-SpringBoot/catalogo-de-libros
```
3️⃣ Abre el proyecto en IntelliJ IDEA o tu IDE favorito.

4️⃣ Ejecuta la clase principal (desde el IDE o desde línea de comandos):
```plaintext
CatalogodelibrosApplication.java
```
5️⃣ Usa el menú en consola para interactuar:
```bash
===== CATALOGO DE LIBROS =====

1 - Buscar libros por título
2 - Lista de todos los libros
3 - Lista de libros por idioma
4 - Lista de autores
5 - Listar autores vivos en determinado año
6 - Mostrar estadísticas de libros por idioma

0 - Salir
```
---

## 🧠 Detalles técnicos

- Se utiliza **JPA** para mapear entidades `Book` y `Author`.
- Uso de **Derived Queries** para consultas personalizadas.
- Uso de **Streams de Java** para agrupar datos y mostrar estadísticas.
- Se considera solo el **primer autor** y el **primer idioma** que devuelve la API para simplificar.
- Manejo de errores y validaciones para evitar que entradas incorrectas afecten la aplicación.

---

## 🙌 Autor

Desarrollado por **Edson Castañeda**  
✨ [LinkedIn](https://www.linkedin.com/in/edsoncasta%C3%B1eda/) | ✏️ [Portafolio](https://portafolio-edson-castaneda.vercel.app/)

