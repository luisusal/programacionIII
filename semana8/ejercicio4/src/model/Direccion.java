package model;

import java.util.Locale;
import java.util.Random;

public class Direccion {

    private String calle;
    private int numero;
    private int piso;
    private String letra;

    private static final String[] CALLES_EJEMPLO = {
            "Calle Mayor", "Avenida de Portugal", "Paseo de Carmelitas",
            "Calle Toro", "Calle Zamora", "Avenida Villamayor"
    };
    private static final String[] LETRAS_EJEMPLO = {"A", "B", "C", "D", "Izda", "Dcha"};

    public Direccion() {
    }

    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    // Factory method que crea una Direccion con valores aleatorios razonables usando Random
    public static Direccion crearAleatoria(Random random) {
        String calleAleatoria = CALLES_EJEMPLO[random.nextInt(CALLES_EJEMPLO.length)];
        // Entero entre 1 y 150 inclusive: min + random.nextInt(max - min + 1)
        int numeroAleatorio = 1 + random.nextInt(150 - 1 + 1);
        // Entero entre 1 y 10 inclusive
        int pisoAleatorio = 1 + random.nextInt(10 - 1 + 1);
        String letraAleatoria = LETRAS_EJEMPLO[random.nextInt(LETRAS_EJEMPLO.length)];
        return new Direccion(calleAleatoria, numeroAleatorio, pisoAleatorio, letraAleatoria);
    }

    public String toCsvLine() {
        return String.format(Locale.ENGLISH, "%s,%d,%d,%s", calle, numero, piso, letra);
    }

    public String asTablePart() {
        return String.format(Locale.ENGLISH, "| %-20s | %4d | %3d | %-5s |", calle, numero, piso, letra);
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getPiso() { return piso; }
    public void setPiso(int piso) { this.piso = piso; }
    public String getLetra() { return letra; }
    public void setLetra(String letra) { this.letra = letra; }
}