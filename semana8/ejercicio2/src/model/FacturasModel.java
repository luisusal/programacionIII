package model;

import es.usal.progiii.tools.Rutas;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FacturasModel {

    private ArrayList<Factura> facturas;
    private ArrayList<Factura> facturasFiltradas;
    private double importeMinimo;

    public FacturasModel() {
        this.facturas = new ArrayList<>();
        this.facturasFiltradas = new ArrayList<>();
        this.importeMinimo = 0.0;
    }

    // Importa facturas desde un archivo TSV en el Escritorio
    public int importarDesdeTsv(String nombreArchivo) {
        Path ruta = Rutas.pathToFileOnDesktop(nombreArchivo);
        if (!Files.exists(ruta) || !Files.isRegularFile(ruta)) {
            return -1;
        }
        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            this.facturas.clear();
            for (String linea : lineas) {
                Factura f = Factura.fromTsvLine(linea);
                if (f != null) {
                    this.facturas.add(f);
                }
            }
            return this.facturas.size();
        } catch (IOException e) {
            return -1;
        }
    }

    public void setImporteMinimo(double importeMinimo) {
        this.importeMinimo = importeMinimo;
    }

    public double getImporteMinimo() {
        return this.importeMinimo;
    }

    // Filtra las facturas cuyo importe calculado supere el importe mínimo[cite: 126, 134]
    public int calcularFacturasSuperioresAlMinimo() {
        this.facturasFiltradas.clear();
        for (Factura f : this.facturas) {
            if (f.calcularImporteFinal() > this.importeMinimo) {
                this.facturasFiltradas.add(f);
            }
        }
        return this.facturasFiltradas.size();
    }

    public ArrayList<Factura> getFacturas() {
        return new ArrayList<>(this.facturas);
    }

    public ArrayList<Factura> getFacturasFiltradas() {
        return new ArrayList<>(this.facturasFiltradas);
    }

    // Exporta las facturas a un archivo .csv (delimitado por comas) en el Escritorio[cite: 115, 126, 134]
    public int exportarACsv(String nombreArchivo) {
        Path ruta = Rutas.pathToFileOnDesktop(nombreArchivo);
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("Concepto,Descuento,Fecha,Importe,NIF,Nombre,Direccion,IVA");
        for (Factura f : this.facturas) {
            lineas.add(f.toCsvLine());
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return this.facturas.size();
        } catch (IOException e) {
            return -1;
        }
    }

    // Exporta las facturas a un archivo .html usando marcador y String.replace[cite: 115, 129, 130, 134]
    public int exportarAHtml(String nombreArchivo) {
        Path ruta = Rutas.pathToFileOnDesktop(nombreArchivo);

        StringBuilder filasHtml = new StringBuilder();
        for (Factura f : this.facturas) {
            filasHtml.append(f.toHtmlTableRow());
        }

        String tablaHtml = "<table border=\"1\">\n"
                + "<tr>"
                + "<th>Concepto</th><th>Descuento</th><th>Fecha</th><th>Importe</th>"
                + "<th>NIF</th><th>Nombre</th><th>Dirección</th><th>IVA</th><th>Total (€)</th>"
                + "</tr>\n"
                + filasHtml.toString()
                + "</table>\n";

        String plantillaHtml = "<!DOCTYPE html>\n"
                + "<html lang=\"es\">\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Listado de Facturas</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Listado de Facturas</h1>\n"
                + "%%TABLA%%\n"
                + "</body>\n"
                + "</html>\n";

        String htmlFinal = plantillaHtml.replace("%%TABLA%%", tablaHtml);

        try {
            Files.writeString(ruta, htmlFinal, StandardCharsets.UTF_8);
            return this.facturas.size();
        } catch (IOException e) {
            return -1;
        }
    }
}
