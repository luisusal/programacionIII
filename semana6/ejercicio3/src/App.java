import java.util.Scanner;
import model.Biblioteca;
import model.Libro;
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    anadirLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    modificarLibro();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 0:
                    System.out.println("Hasta pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("=== BIBLIOTECA ===");
        System.out.println("1. Anadir libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Buscar libro por ISBN");
        System.out.println("4. Modificar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("0. Salir");
    }

    private static void anadirLibro() {
        String isbn = leerTexto("ISBN: ");
        if (biblioteca.buscar(isbn) != null) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }
        String titulo = leerTexto("Titulo: ");
        String autor = leerTexto("Autor: ");
        int anio = leerEntero("Anio de publicacion: ");
        biblioteca.crear(new Libro(isbn, titulo, autor, anio));
        System.out.println("Libro anadido.");
    }

    private static void listarLibros() {
        if (biblioteca.getTotal() == 0) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        System.out.println("Libros en la biblioteca (" + biblioteca.getTotal() + "):");
        for (Libro libro : biblioteca.listar()) {
            System.out.println(" - " + libro);
        }
    }

    private static void buscarLibro() {
        String isbn = leerTexto("ISBN a buscar: ");
        Libro libro = biblioteca.buscar(isbn);
        if (libro == null) {
            System.out.println("No existe ningun libro con ese ISBN.");
        } else {
            System.out.println(libro);
        }
    }

    private static void modificarLibro() {
        String isbn = leerTexto("ISBN del libro a modificar: ");
        if (biblioteca.buscar(isbn) == null) {
            System.out.println("No existe ningun libro con ese ISBN.");
            return;
        }
        String titulo = leerTexto("Nuevo titulo: ");
        String autor = leerTexto("Nuevo autor: ");
        int anio = leerEntero("Nuevo anio de publicacion: ");
        biblioteca.actualizar(isbn, titulo, autor, anio);
        System.out.println("Libro modificado.");
    }

    private static void eliminarLibro() {
        String isbn = leerTexto("ISBN del libro a eliminar: ");
        if (biblioteca.eliminar(isbn)) {
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("No existe ningun libro con ese ISBN.");
        }
    }

    private static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El valor no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un numero entero valido.");
            }
        }
    }
}
