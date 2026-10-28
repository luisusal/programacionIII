package semana7.almacenlibros.src.almacenlibrosmvc.view;

import static es.usal.progiii.tools.Esdia.readInt;
import static es.usal.progiii.tools.Esdia.readString_ne;
import almacenlibrosmvc.controller.AlmacenControlador;
import java.util.ArrayList;
import almacenlibrosmvc.model.Libro;

/**
 *
 * @author Loza
 */
public class AlmacenVista {

    private AlmacenControlador controlador;

    public void mostrarMensajeBienvenida() {

        String version = controlador.obtenerVersionPrograma();
        String mensaje = String.format("AlmacenMVC ver:%s", version);
        String borde = "+".repeat(mensaje.length() + 4);
        System.out.printf("%s%n", borde);
        System.out.printf("+ %s +%n", mensaje);
        System.out.printf("%s%n", borde);
    }

    public void mostrarMenuPrincipal() {

        int opcion;
        do {
            System.out.println("\n--- MENU ALMACEN MVC ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro por título");
            System.out.println("3. Actualizar libro por título");
            System.out.println("4. Listar libros");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibroPorTitulo();
                    break;
                case 3:
                    modificarLibroPorTitulo();
                    break;
                case 4:
                    mostrarLibros();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

    }

    private void agregarLibro() {
        String titulo = readString_ne("Introduzca el título del libro:");
        String autor = readString_ne("Introduzca el nombre del autor:");

        String resultado = controlador.agregarLibro(new Libro(titulo, autor));
        System.out.printf("Resultado: %s", resultado);

    }

    private void eliminarLibroPorTitulo() {
        String titulo = readString_ne("Introduzca el título del libro a borrar:");
        String resultado = controlador.eliminarLibroPorTitulo(titulo);
        System.out.printf("Resultado: %s", resultado);
    }

    private void modificarLibroPorTitulo() {

        // En este caso comprobamos antes si existe para no pedir toda
        // la información al usuario en valde.
        String titulo = readString_ne("Introduzca el título del libro a modificar:");
        if (controlador.comprobarExistenciaLibroPorTitulo(titulo)) {
            System.out.println("Libro encontrado, introduzca los datos a modificar:");
            String autor = readString_ne("Introduzca el autor:");
            controlador.actualizarLibro(new Libro(titulo, autor));
        } else {
            System.out.println("No hay un libro con ese título.");
        }

    }

    public void mostrarLibros() {

        ArrayList<Libro> librosDisponibles = controlador.obtenerLibros();

        if (!librosDisponibles.isEmpty()) {
            String cabecera = String.format("|%-81s|", "Libros disponibles");
            System.out.println("-".repeat(cabecera.length()));
            System.out.println(cabecera);
            System.out.println("-".repeat(cabecera.length()));
            for (Libro libro : librosDisponibles) {
                System.out.printf("|%40s|%40s|%n", libro.getTitulo(), libro.getAutor());
            }
            System.out.println("-".repeat(cabecera.length()));

        } else {
            System.out.println("|NO HAY LIBROS DISPONIBLES|");
        }

    }

    public void mostrarMensajeDespedida() {
        String mensaje = String.format("Gracias por utilizar la app");
        String borde = "+".repeat(mensaje.length() + 4);
        System.out.printf("%s%n", borde);
        System.out.printf("+ %s +%n", mensaje);
        System.out.printf("%s%n", borde);
    }

    public void setControlador(AlmacenControlador controlador) {
        this.controlador = controlador;
    }

}
