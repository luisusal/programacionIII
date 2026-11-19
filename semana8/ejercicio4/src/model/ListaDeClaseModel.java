package model;

import es.usal.progiii.tools.Rutas;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ListaDeClaseModel {

    public static final int NUM_ALUMNOS_INICIAL = 20;

    private ArrayList<DatosDeAlumno> alumnos;
    private Random random;

    public ListaDeClaseModel() {
        this.alumnos = new ArrayList<>();
        this.random = new Random();
        generarListaAleatoria(NUM_ALUMNOS_INICIAL);
    }

    // Crea una colección nueva de 'cantidad' alumnos con valores aleatorios y NIF no repetido
    public int generarListaAleatoria(int cantidad) {
        this.alumnos.clear();
        Set<String> nifsUsados = new HashSet<>();
        for (int i = 0; i < cantidad; i++) {
            this.alumnos.add(DatosDeAlumno.crearAleatorio(this.random, nifsUsados));
        }
        return this.alumnos.size();
    }

    public ArrayList<DatosDeAlumno> getAlumnos() {
        return new ArrayList<>(this.alumnos);
    }

    // Opción 3: Exportar datos personales a CSV en el Escritorio[cite: 115, 136]
    public int exportarDatosPersonalesCsv(String nombreArchivo) {
        Path ruta = Rutas.pathToFileOnDesktop(nombreArchivo);
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("Nombre,Apellidos,Edad,NIF");
        for (DatosDeAlumno alumno : this.alumnos) {
            lineas.add(alumno.getDatosPersonales().toCsvLine());
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return this.alumnos.size();
        } catch (IOException e) {
            return -1;
        }
    }

    // Opción 4: Exportar direcciones a CSV en el Escritorio[cite: 115, 136]
    public int exportarDireccionesCsv(String nombreArchivo) {
        Path ruta = Rutas.pathToFileOnDesktop(nombreArchivo);
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("Calle,Numero,Piso,Letra");
        for (DatosDeAlumno alumno : this.alumnos) {
            lineas.add(alumno.getDireccion().toCsvLine());
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return this.alumnos.size();
        } catch (IOException e) {
            return -1;
        }
    }
}