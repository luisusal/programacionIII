package model;

import es.usal.progiii.tools.Rutas;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersonaModel {

    private ArrayList<Persona> personas;

    public PersonaModel() {
        this.personas = new ArrayList<>();
    }

    // Carga inicial al arrancar desde datos.txt en el Escritorio (formato TSV)
    public int cargarDatosIniciales() {
        return importarDesdeTsvEnEscritorio("datos.txt");
    }

    // Importa personas desde un archivo TSV ubicado en el Escritorio
    public int importarDesdeTsvEnEscritorio(String nombreArchivo) {
        Path ruta = Rutas.pathToFileOnDesktop(nombreArchivo);
        if (!Files.exists(ruta) || !Files.isRegularFile(ruta)) {
            return -1;
        }
        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            int anadidas = 0;
            for (String linea : lineas) {
                Persona p = Persona.fromTsvLine(linea);
                if (p != null) {
                    this.personas.add(p);
                    anadidas++;
                }
            }
            return anadidas;
        } catch (IOException e) {
            return -1;
        }
    }

    public ArrayList<Persona> getPersonas() {
        return new ArrayList<>(this.personas);
    }
}