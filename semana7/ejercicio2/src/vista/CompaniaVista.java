package semana7.ejercicio2.src.vista;

package vista;

import com.coti.tools.Esdia; // Importación de la clase Esdia para la lectura de datos desde la consola
import controller.CompaniaControlador;

public class CompaniaVista {
    private CompaniaControlador controlador;

    public void setControlador(CompaniaControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenuPrincipal() {
        String opcion;
        do {
            System.out.println("\n===== GESTIÓN DE ALMACENES =====");
            System.out.println("1.- Leer tabla de ventas");
            System.out.println("2.- Leer tabla de precios");
            System.out.println("3.- Calcular ingresos totales");
            System.out.println("4.- Mostrar resultados");
            System.out.println("q.- Salir");

            opcion = Esdia.readString("Elige una opción: ").trim().toLowerCase();

            switch (opcion) {
                case "1":
                    leerTablaVentas();
                    break;
                case "2":
                    leerTablaPrecios();
                    break;
                case "3":
                    controlador.calcularIngresos();
                    break;
                case "4":
                    controlador.solicitarResultados();
                    break;
                case "q":
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    mostrarError("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("q"));
    }

    private void leerTablaVentas() {
        int numAlmacenes = controlador.getNumAlmacenes();
        int numProductos = controlador.getNumProductos();
        int[][] ventas = new int[numAlmacenes][numProductos];

        System.out.println("\n--- Lectura de tabla de ventas (unidades) ---");
        for (int i = 0; i < numAlmacenes; i++) {
            System.out.println("Almacén " + (i + 1) + ":");
            for (int j = 0; j < numProductos; j++) {
                ventas[i][j] = Esdia.readInt(
                        "  Unidades vendidas del Producto " + (j + 1) + ": ",
                        0,
                        Integer.MAX_VALUE
                );
            }
        }

        controlador.guardarVentas(ventas);
    }

    private void leerTablaPrecios() {
        int numProductos = controlador.getNumProductos();
        double[] precios = new double[numProductos];

        System.out.println("\n--- Lectura de tabla de precios ---");
        for (int j = 0; j < numProductos; j++) {
            precios[j] = Esdia.readDouble(
                    "Precio unitario del Producto " + (j + 1) + " (€): ",
                    0.0,
                    Double.MAX_VALUE
            );
        }

        controlador.guardarPrecios(precios);
    }

    public void mostrarResultados(int[][] ventas, double[] precios, double[] ingresosPorAlmacen, double ingresosTotales) {
        System.out.println("\n========== RESULTADOS DE INGRESOS ==========");
        System.out.printf("Precios unitarios -> Producto 1: %.2f € | Producto 2: %.2f €%n%n",
                precios[0], precios[1]);

        System.out.printf("%-12s %-12s %-12s %-15s%n", "Almacén", "Prod. 1 (u)", "Prod. 2 (u)", "Ingresos (€)");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < ventas.length; i++) {
            System.out.printf("%-12s %-12d %-12d %-15.2f%n",
                    "Almacén " + (i + 1),
                    ventas[i][0],
                    ventas[i][1],
                    ingresosPorAlmacen[i]);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("INGRESOS TOTALES DE LA COMPAÑÍA: %.2f €%n", ingresosTotales);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("[INFO] " + mensaje);
    }

    public void mostrarError(String error) {
        System.out.println("[ERROR] " + error);
    }
}