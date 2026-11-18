# Ejercicio 1: MVC simlpe + CRUD colecciones + Serialiacion + CSV + JSON/XML

Ejercicio completo con todo lo tratado hasta la fecha:

- MVC simple
- CRUD de colecciones
- Serialización
- CSV
- JSON/XML

## Enunciado

Realiza un programa en Java que, siguiendo el patrón MVC tratado en clase y sus restricciones, permita
realizar todas las operaciones CRUD sobre una colección (ArrayList) de objetos de tipo Libro y todos los
tipos de importación/exportación tratados hasta la fecha. El programa deberá comprobar en su
inicialización si existe un fichero libros.bin (binario serializado) en el escritorio del usuario. De
ser así cargará los libros en el modelo y en caso contrario notificará al usuario por pantalla
indicando que no ha encontrado dicho fichero (esto en la clase correcta según el MVC). La vista
ofrecerá las siguientes opciones:

1. Mostrar el listado de libros en formato tabla.
2. Añadir nuevo libro al modelo
3. Eliminar libro de una lista de libros disponibles (se deberá mostrar lista de libros y elegir cual
eliminar)
4. Modificar libro de una lista de libros disponibles (se deberá mostrar lista de libros y elegir cual
modificar)
5. Exportar libros en formato delimitado por comas CSV.
5. Exportar libros en formato JSON (libros.json en el escritorio)
6. Exportar libros en formato XML (libros.xml en el escritorio)
7. Importar libros de un fichero JSON (llamado libros.json en el escritorio). Se añadirán a la
colección existente evitando duplicados. (Revisad contains y la implementación de equals y hashCode)
8. Importar libros de un fichero XML (llamado libros.xml en el escritorio). Misma política que antes.
9. Importar libros de un fichero en formato delimitado por comas CSV (libros.csv en el escritorio).
Misma política.
10. Salir del programa.

Al cerrar la aplicación, se deberá guardar el estado del modelo (la colección de libros) en el fichero
libros.bin utilizando la serialización en Java. El programa deberá tener una E/S por consola robusta
y deberá controlar debidamente las excepciones que se pudieran producir, dando feedback al usuario
en la clase correspondiente del MVC.
TIPS:
Es posible y recomendable apoyarse en códigos proporcionados de ejemplo y en bibliotecas externas
como Biblioteca.jar y sus clases de utilidad para la realización de este ejercicio.
Realizad el ejercicio de forma incremental, añadiendo y probando cada opción del menú de forma
unitaria.


# Solución

![PlantUML](https://www.plantuml.com/plantuml/png/hLJRJXiz4BxFK_XoqS-V9wWg8AKj5O6eYL2bgXUJzIHnw_MajZT0KVhizOw3TvqiKLLnmOA_mtWy1ywS1-lhIWzA3Sw9aghX4fqdgzNSaXjM954FFp1qpT2uGSJJuBSujnOUhvNpRvXvAw8dC1FmAx4Ednbz6L_dmAVfxKsEZAPtEN2X3DZ7mN_YyDu3f3W9kWqfAK1AnWl-9jXYHHliO-gr1B_773vgYJvUnpSfumK-hCdw2w8VZfDFXAeIyTvIbQZS4qlmakaO5shP7x1BEDZWr8F7syLiXUVhTM8qWTndjeENEhzHU3-y2n_kzOYCjwGrMb4-ruzdPuoc3d7-Zr1C62pd5RFgO_YHYSA7lwD2FLi6Ib-3Lh_0nWRkz-rK6P_44ZLwR88qPOnpSzG0KZRg6KLjmYjota9t_gYO4sa4ayRAeHyLRRrQV4NtLsP1OtGEbbXClLLccT6NrfBD-MCj2YqKJy7_v3nuLMvtEO8oE_FNRyViPSfnsARBtJxSkogWF0oRS5-hxlnP79XE6qDwdpBAnvaxlcIlkyw7-_hQIna2_kE-RWV7_-lo8xWViPlYQdfnqvwyyhMczWnr2D0UKQfmLg03r2G0vf4czLoh4af5PeUQkfh0KXbm0LXe0Y_M5eCWf1tlZmKzsJl7IqvxVuMu_CFXJhhp6ICiB5NlKAjAUPJHaySBdlGerw_iXaq5WRd6ZmWIRP65c3N4PxfFpLY1Mur88WEx_HNuimRjYjlvTonzwszciobyEvbk1qG-LywuAPasGhtgywPbcJWYVThBvtvc-eGc3x-GW-SDpspxNB1qd3TfA3gc38vw7XXsJ7XcEke4iOHdVN26HjQL_WC0)