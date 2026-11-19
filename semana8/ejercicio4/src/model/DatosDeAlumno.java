package model;

import java.util.Random;
import java.util.Set;

public class DatosDeAlumno {

    private DatosPersonales datosPersonales;
    private Direccion direccion;

    public DatosDeAlumno() {
    }

    public DatosDeAlumno(DatosPersonales datosPersonales, Direccion direccion) {
        this.datosPersonales = datosPersonales;
        this.direccion = direccion;
    }

    public static DatosDeAlumno crearAleatorio(Random random, Set<String> nifsUsados) {
        DatosPersonales dp = DatosPersonales.crearAleatorio(random, nifsUsados);
        Direccion dir = Direccion.crearAleatoria(random);
        return new DatosDeAlumno(dp, dir);
    }

    // Fila completa que incluye tanto datos personales como dirección (Opción 2)
    public String asFullTableRow() {
        return "| " + datosPersonales.asTablePart() + " " + direccion.asTablePart().substring(2);
    }

    public DatosPersonales getDatosPersonales() { return datosPersonales; }
    public void setDatosPersonales(DatosPersonales datosPersonales) { this.datosPersonales = datosPersonales; }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }
}