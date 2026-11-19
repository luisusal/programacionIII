package model;

import java.util.Locale;

public class Persona {

    private String nombre;
    private String telefono;
    private double peso;

    public Persona() {
    }

    public Persona(String nombre, String telefono, double peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    // Factory method simple para crear una Persona desde una línea delimitada por tabuladores ("\t")
    public static Persona fromTsvLine(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return null;
        }
        String[] campos = linea.split("\t", -1);
        if (campos.length != 3) {
            return null;
        }
        try {
            String nombre = campos[0].trim();
            String telefono = campos[1].trim();
            double peso = Double.parseDouble(campos[2].trim().replace(',', '.'));
            return new Persona(nombre, telefono, peso);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Cabecera de tabla solicitada en el enunciado
    public static String tableHeader() {
        return String.format(Locale.ENGLISH, "| %-25s | %-15s | %10s |",
                "Nombre", "Teléfono", "Peso (kg)");
    }

    // Fila de tabla solicitada en el enunciado
    public String asTableRow() {
        return String.format(Locale.ENGLISH, "| %-25s | %-15s | %10.2f |",
                nombre, telefono, peso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}