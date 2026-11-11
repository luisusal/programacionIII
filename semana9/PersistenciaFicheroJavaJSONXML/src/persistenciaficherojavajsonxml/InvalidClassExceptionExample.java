package persistenciaficherojavajsonxml;

import java.io.File;
import java.nio.file.Path;

import model.Persona;

public class InvalidClassExceptionExample {
    static File f = Path.of(System.getProperty("user.home"), "Desktop", "persona.bin").toFile();

    public static void main(String[] args) {

        // Exportar a un fichero binario de un objeto
        //exportarPersonaAFichero();

        // Modificar la clase Persona (Añade un nuevo atributo por ejemplo)
          
        // Intentar importar el objeto serializado (Comentar y descomentar las siguientes líneas)
        //importarPersonaDeFichero();


    }

    private static void importarPersonaDeFichero() {
        Persona p = PersistenciaFicheroJavaSerializacion.importarPersonaDeBinario(f);
    }

    private static void exportarPersonaAFichero() {
        Persona p = new Persona("Benito", 22, 1.77f);
        PersistenciaFicheroJavaSerializacion.exportarPersonaABinario(p,f);
    }

}
