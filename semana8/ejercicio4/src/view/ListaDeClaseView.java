package view;

import controller.ListaDeClaseController;
import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;
import java.util.Locale;
import model.DatosDeAlumno;

public class ListaDeClaseView {

    private ListaDeClaseController controlador;

    public void setControlador(ListaDeClaseController controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- LISTA DE CLASE ---");
            System.out.println("1 Volver a crear la lista de alumnos");
            System.out.println("2 Mostrar tabla de alumnos");
            System.out.println("3 Exportar datos personales (CSV)");
            System.out.println("4 Exportar direcciones (CSV)");
            System.out.println("q Salir");

            String entrada = Esdia.readString("Seleccione una opción: ").trim();

            switch (entrada) {
                case "1":
                    volverACrearLista();
                    break;
                case "2":
                    mostrarTablaAlumnos();
                    break;
                case "3":
                    exportarDatosPersonales();
                    break;
                case "4":
                    exportarDirecciones();
                    break;
                case "q":
                case "Q":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Introduzca 1, 2, 3, 4 o q.");
                    break;
            }
        }
    }

    private void volverACrearLista() {
        int total = controlador.volverACrearLista();
        System.out.println("Se ha vuelto a crear la lista con " + total + " alumnos aleatorios.");
    }

    private void mostrarTablaAlumnos() {
        ArrayList<DatosDeAlumno> lista = controlador.obtenerAlumnos();
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos en la lista.");
            return;
        }
        String cabecera = String.format(Locale.ENGLISH,
                "| %-12s | %-18s | %4s | %-10s | %-20s | %4s | %3s | %-5s |",
                "Nombre", "Apellidos", "Edad", "NIF", "Calle", "Núm.", "Piso", "Letra");
        String separador = "+" + "-".repeat(cabecera.length() - 2) + "+";

        System.out.println("\n" + separador);
        System.out.println(cabecera);
        System.out.println(separador);
        for (DatosDeAlumno alumno : lista) {
            System.out.println(alumno.asFullTableRow());
        }
        System.out.println(separador);
    }

    private void exportarDatosPersonales() {
        String nombreArchivo = Esdia.readString_ne("Nombre del archivo CSV en el Escritorio (ej. datos_personales.csv): ");
        int resultado = controlador.exportarDatosPersonalesCsv(nombreArchivo);
        if (resultado < 0) {
            System.err.println("Error al exportar los datos personales a CSV.");
        } else {
            System.out.println("Exportados " + resultado + " registros de datos personales a " + nombreArchivo);
        }
    }

    private void exportarDirecciones() {
        String nombreArchivo = Esdia.readString_ne("Nombre del archivo CSV en el Escritorio (ej. direcciones.csv): ");
        int resultado = controlador.exportarDireccionesCsv(nombreArchivo);
        if (resultado < 0) {
            System.err.println("Error al exportar las direcciones a CSV.");
        } else {
            System.out.println("Exportados " + resultado + " registros de direcciones a " + nombreArchivo);
        }
    }
}