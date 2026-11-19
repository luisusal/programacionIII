package view;

import controller.FacturasController;
import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;
import java.util.Locale;
import model.Factura;

public class FacturasView {

    private FacturasController controlador;

    public void setControlador(FacturasController controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN DE FACTURAS ---");
            System.out.println("1) Importar facturas desde archivo TSV (Escritorio)");
            System.out.println("2) Introducir importe mínimo y listar clientes que lo superan");
            System.out.println("3) Mostrar listado total de facturas");
            System.out.println("4) Exportar facturas a archivo HTML");
            System.out.println("5) Exportar facturas a archivo CSV");
            System.out.println("6) Salir");

            int opcion = Esdia.readInt("Seleccione una opción: ", 1, 6);

            switch (opcion) {
                case 1:
                    importarTsv();
                    break;
                case 2:
                    filtrarPorImporteMinimo();
                    break;
                case 3:
                    mostrarListadoTotal();
                    break;
                case 4:
                    exportarHtml();
                    break;
                case 5:
                    exportarCsv();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void importarTsv() {
        String nombreArchivo = Esdia.readString_ne("Nombre del archivo TSV en el Escritorio (ej. facturas.tsv): ");
        int resultado = controlador.importarDesdeTsv(nombreArchivo);
        if (resultado < 0) {
            System.err.println("Error al importar el archivo TSV. Compruebe que existe y es un fichero válido.");
        } else {
            System.out.println("Se han importado " + resultado + " facturas.");
        }
    }

    private void filtrarPorImporteMinimo() {
        double minimo = Esdia.readDouble("Introduzca el importe mínimo de factura: ");
        controlador.establecerImporteMinimo(minimo);
        int totalFiltradas = controlador.calcularFacturasSuperioresAlMinimo();
        ArrayList<Factura> filtradas = controlador.obtenerFacturasFiltradas();

        System.out.printf(Locale.ENGLISH, "\n--- CLIENTES CON FACTURAS > %.2f ---\n", minimo);
        if (totalFiltradas == 0 || filtradas.isEmpty()) {
            System.out.println("No hay facturas que superen el importe mínimo indicado.");
            return;
        }
        for (Factura f : filtradas) {
            System.out.printf(Locale.ENGLISH, "Cliente: %s | NIF: %s | Importe final: %.2f%n",
                    f.getNombreCliente(), f.getNif(), f.calcularImporteFinal());
        }
    }

    private void mostrarListadoTotal() {
        ArrayList<Factura> todas = controlador.obtenerFacturas();
        if (todas.isEmpty()) {
            System.out.println("No hay facturas cargadas en el sistema.");
            return;
        }
        System.out.println("\n--- LISTADO TOTAL DE FACTURAS ---");
        System.out.printf(Locale.ENGLISH, "%-20s | %-8s | %-10s | %-8s | %-12s | %-18s | %-10s%n",
                "Concepto", "Dto.", "Fecha", "Importe", "NIF", "Cliente", "Total");
        System.out.println("-".repeat(95));
        for (Factura f : todas) {
            System.out.printf(Locale.ENGLISH, "%-20.20s | %-8.2f | %-10s | %-8.2f | %-12s | %-18.18s | %-10.2f%n",
                    f.getConcepto(), f.getDescuento(), f.getFecha(), f.getImporte(),
                    f.getNif(), f.getNombreCliente(), f.calcularImporteFinal());
        }
    }

    private void exportarHtml() {
        String nombreArchivo = Esdia.readString_ne("Nombre del archivo HTML en el Escritorio (ej. facturas.html): ");
        int resultado = controlador.exportarAHtml(nombreArchivo);
        if (resultado < 0) {
            System.err.println("Error al exportar el archivo HTML.");
        } else {
            System.out.println("Exportadas " + resultado + " facturas a " + nombreArchivo);
        }
    }

    private void exportarCsv() {
        String nombreArchivo = Esdia.readString_ne("Nombre del archivo CSV en el Escritorio (ej. facturas.csv): ");
        int resultado = controlador.exportarACsv(nombreArchivo);
        if (resultado < 0) {
            System.err.println("Error al exportar el archivo CSV.");
        } else {
            System.out.println("Exportadas " + resultado + " facturas a " + nombreArchivo);
        }
    }
}