package model;

import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class DatosPersonales {

    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

    private static final String[] NOMBRES_EJEMPLO = {
            "Lucía", "Mateo", "Sofía", "Hugo", "Elena", "Daniel", "Valeria", "Alejandro"
    };
    private static final String[] APELLIDOS_EJEMPLO = {
            "García López", "Martínez Ruiz", "Fernández Sánchez", "Pérez Gómez",
            "Rodríguez Díaz", "Sanz Martín", "Álvarez Torres", "Moreno Gil"
    };
    private static final String LETRAS_NIF = "TRWAGMYFPDXBNJZSQVHLCKE";

    public DatosPersonales() {
    }

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    // Factory method que crea DatosPersonales con valores aleatorios y NIF no repetido
    public static DatosPersonales crearAleatorio(Random random, Set<String> nifsUsados) {
        String nombreAleatorio = NOMBRES_EJEMPLO[random.nextInt(NOMBRES_EJEMPLO.length)];
        String apellidosAleatorios = APELLIDOS_EJEMPLO[random.nextInt(APELLIDOS_EJEMPLO.length)];
        // Edad razonable entre 18 y 30 inclusive
        int edadAleatoria = 18 + random.nextInt(30 - 18 + 1);

        String nifGenerado;
        do {
            // Número de 8 dígitos entre 10000000 y 99999999 inclusive
            int numeroDni = 10000000 + random.nextInt(99999999 - 10000000 + 1);
            char letraDni = LETRAS_NIF.charAt(numeroDni % 23);
            nifGenerado = String.format(Locale.ENGLISH, "%08d%c", numeroDni, letraDni);
        } while (nifsUsados != null && nifsUsados.contains(nifGenerado));

        if (nifsUsados != null) {
            nifsUsados.add(nifGenerado);
        }

        return new DatosPersonales(nombreAleatorio, apellidosAleatorios, edadAleatoria, nifGenerado);
    }

    public String toCsvLine() {
        return String.format(Locale.ENGLISH, "%s,%s,%d,%s", nombre, apellidos, edad, nif);
    }

    public String asTablePart() {
        return String.format(Locale.ENGLISH, "%-12s | %-18s | %4d | %-10s", nombre, apellidos, edad, nif);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosPersonales)) return false;
        DatosPersonales that = (DatosPersonales) o;
        return Objects.equals(nif, that.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getNif() { return nif; }
    public void setNif(String nif) { this.nif = nif; }
}