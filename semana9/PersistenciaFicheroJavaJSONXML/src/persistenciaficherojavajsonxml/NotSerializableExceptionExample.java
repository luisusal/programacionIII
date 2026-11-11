package persistenciaficherojavajsonxml;

import java.io.File;
import java.nio.file.Path;

import model.Persona;

public class NotSerializableExceptionExample {
    static File f = Path.of(System.getProperty("user.home"), "Desktop", "persona.bin").toFile();

    public static void main(String[] args) {

        // Hacer que Persona no implemente la interfaz Serializable
        // (Quitar implements Serializable de la clase Persona)

        // Exportar a un fichero binario de un objeto
        exportarPersonaAFichero();

    }

    private static void exportarPersonaAFichero() {
        Persona p = new Persona("Benito", 22, 1.77f);
        PersistenciaFicheroJavaSerializacion.exportarPersonaABinario(p,f);
    }

}
