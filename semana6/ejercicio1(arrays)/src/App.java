import java.util.Scanner;
import model.Coche;
import model.Concesionario;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Concesionario concesionario = new Concesionario();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1:
                    anadirCoche();
                    break;
                case 2:
                    listarCoches();
                    break;
                case 3:
                    buscarCoche();
                    break;
                case 4:
                    modificarCoche();
                    break;
                case 5:
                    eliminarCoche();
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
        System.out.println("=== STOCK DEL CONCESIONARIO (Arrays) ===");
        System.out.println("1. Anadir coche");
        System.out.println("2. Listar coches");
        System.out.println("3. Buscar coche por matricula");
        System.out.println("4. Modificar coche");
        System.out.println("5. Eliminar coche");
        System.out.println("0. Salir");
    }

    private static void anadirCoche() {
        if (concesionario.estaLleno()) {
            System.out.println("El stock esta lleno, no caben mas coches.");
            return;
        }
        String matricula = leerTexto("Matricula: ");
        if (concesionario.buscar(matricula) != null) {
            System.out.println("Ya existe un coche con esa matricula.");
            return;
        }
        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        int anio = leerEntero("Anio: ");
        double precio = leerDecimal("Precio: ");
        concesionario.crear(new Coche(matricula, marca, modelo, anio, precio));
        System.out.println("Coche anadido.");
    }

    private static void listarCoches() {
        if (concesionario.getTotal() == 0) {
            System.out.println("No hay coches en el stock.");
            return;
        }
        System.out.println("Coches en stock (" + concesionario.getTotal() + "):");
        for (Coche coche : concesionario.listar()) {
            System.out.println(" - " + coche);
        }
    }

    private static void buscarCoche() {
        String matricula = leerTexto("Matricula a buscar: ");
        Coche coche = concesionario.buscar(matricula);
        if (coche == null) {
            System.out.println("No existe ningun coche con esa matricula.");
        } else {
            System.out.println(coche);
        }
    }

    private static void modificarCoche() {
        String matricula = leerTexto("Matricula del coche a modificar: ");
        if (concesionario.buscar(matricula) == null) {
            System.out.println("No existe ningun coche con esa matricula.");
            return;
        }
        String marca = leerTexto("Nueva marca: ");
        String modelo = leerTexto("Nuevo modelo: ");
        int anio = leerEntero("Nuevo anio: ");
        double precio = leerDecimal("Nuevo precio: ");
        concesionario.actualizar(matricula, marca, modelo, anio, precio);
        System.out.println("Coche modificado.");
    }

    private static void eliminarCoche() {
        String matricula = leerTexto("Matricula del coche a eliminar: ");
        if (concesionario.eliminar(matricula)) {
            System.out.println("Coche eliminado.");
        } else {
            System.out.println("No existe ningun coche con esa matricula.");
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

    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un numero valido.");
            }
        }
    }
}
