package model;

import java.util.Locale;

public class Factura {

    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe,
                   String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    // Cálculo pedido en el enunciado: importe * (1 - descuento) * (1 + IVA)[cite: 126, 134]
    public double calcularImporteFinal() {
        return this.importe * (1.0 - this.descuento) * (1.0 + this.iva);
    }

    // Factory Method simple para crear una Factura desde una línea TSV (separada por tabulador "\t")
    public static Factura fromTsvLine(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return null;
        }
        String[] partes = linea.split("\t", -1);
        if (partes.length != 8) {
            return null;
        }
        try {
            String concepto = partes[0].trim();
            double descuento = Double.parseDouble(partes[1].trim().replace(',', '.'));
            String fecha = partes[2].trim();
            double importe = Double.parseDouble(partes[3].trim().replace(',', '.'));
            String nif = partes[4].trim();
            String nombreCliente = partes[5].trim();
            String direccion = partes[6].trim();
            double iva = Double.parseDouble(partes[7].trim().replace(',', '.'));

            return new Factura(concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Convierte la factura a una línea CSV delimitada por comas
    public String toCsvLine() {
        return String.format(Locale.ENGLISH, "%s,%s,%s,%.2f,%s,%s,%s,%.2f",
                escaparCsv(concepto),
                String.format(Locale.ENGLISH, "%.2f", descuento),
                escaparCsv(fecha),
                importe,
                escaparCsv(nif),
                escaparCsv(nombreCliente),
                escaparCsv(direccion),
                iva);
    }

    private String escaparCsv(String campo) {
        if (campo == null) {
            return "";
        }
        if (campo.contains(",") || campo.contains("\"") || campo.contains("\n")) {
            return "\"" + campo.replace("\"", "\"\"") + "\"";
        }
        return campo;
    }

    // Genera las celdas <td>...</td> de esta factura para la tabla HTML
    public String toHtmlTableRow() {
        return "<tr>"
                + "<td>" + escaparHtml(concepto) + "</td>"
                + "<td>" + String.format(Locale.ENGLISH, "%.2f", descuento) + "</td>"
                + "<td>" + escaparHtml(fecha) + "</td>"
                + "<td>" + String.format(Locale.ENGLISH, "%.2f", importe) + "</td>"
                + "<td>" + escaparHtml(nif) + "</td>"
                + "<td>" + escaparHtml(nombreCliente) + "</td>"
                + "<td>" + escaparHtml(direccion) + "</td>"
                + "<td>" + String.format(Locale.ENGLISH, "%.2f", iva) + "</td>"
                + "<td>" + String.format(Locale.ENGLISH, "%.2f", calcularImporteFinal()) + "</td>"
                + "</tr>\n";
    }

    private String escaparHtml(String texto) {
        if (texto == null) {
            return "";
        }
        return texto.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;");
    }

    public String getConcepto() { return concepto; }
    public double getDescuento() { return descuento; }
    public String getFecha() { return fecha; }
    public double getImporte() { return importe; }
    public String getNif() { return nif; }
    public String getNombreCliente() { return nombreCliente; }
    public String getDireccion() { return direccion; }
    public double getIva() { return iva; }
}