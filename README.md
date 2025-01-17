![Java](https://img.shields.io/badge/Language-Java-blue)
![License](https://img.shields.io/badge/License-Apache%202.0-green)
![Changes](https://img.shields.io/badge/Planned%20Changes-Yes-orange)

## Biblioteca

### Descripción
Este programa es un sistema de consola que consume la API Gutenex. A través de un menú almacenado en la variable `menu` del archivo `Principal.java`, los usuarios pueden buscar libros. Al completar una búsqueda, el autor y el libro serán almacenados en distintas tablas de una base de datos en PostgreSQL.

### Funcionalidades
- **Buscar Libro por su Nombre**: Permite a los usuarios buscar libros por su nombre.
- **Listar Libros Buscados**: Muestra una lista de libros que han sido buscados y registrados.
- **Listar Autores Registrados**: Muestra una lista de autores que han sido registrados.
- **Buscar Autores por Año**: Permite buscar autores según la época en la que vivieron.
- **Listar Libros por Idioma**: Permite listar libros por su idioma (Español, Inglés, Portugués y Francés).

### Instalación
Para instalar y configurar el programa, siga los siguientes pasos:
1. Clona el repositorio: `git clone https://github.com/Josu3G4RNu/Biblioteca.git`
2. Navega al directorio del proyecto: `cd Biblioteca`
3. Compila el código: `javac src/main/java/com/JosueGarNu/Biblioteca/Principal/Principal.java`
4. Ejecuta el programa: `java src/main/java/com/JosueGarNu/Biblioteca/Principal/Principal`

### Uso
El programa se ejecuta desde la línea de comandos y ofrece una interfaz interactiva para gestionar la biblioteca. Los comandos disponibles se detallan a continuación:
- `1`: Buscar Libro por su Nombre
- `2`: Lista libros buscados
- `3`: Listar autores registrados
- `4`: Buscar autores por determinado año
- `5`: Listar libros por idioma
- `0`: Salir

### Contribución
Las contribuciones son bienvenidas. Por favor, sigue estos pasos para contribuir:
1. Haz un fork del repositorio.
2. Crea una rama nueva: `git checkout -b mi-rama`
3. Realiza tus cambios y haz commit: `git commit -m 'Descripción de los cambios'`
4. Sube tus cambios a tu fork: `git push origin mi-rama`
5. Abre una pull request en GitHub.

### Licencia
Este proyecto está licenciado bajo la Licencia Apache 2.0. Para más detalles, consulta el archivo LICENSE.

### Planes Futuros
Se planean realizar mejoras y agregar nuevas funcionalidades al programa, incluyendo:
- Ampliar la lista de idiomas.
- Mejorar la redacción del código.
- Añadir el enlace a la página del libro.
- Mejorar la interfaz de la terminal.
