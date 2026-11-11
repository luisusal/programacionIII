package persistenciaficherojavajsonxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Persona;

/**
 *
 * @author Loza
 */
public class PersistenciaFicheroJavaSerializacion {
    
    /***
     * 
     * 
     * En este fuente se ejemplifica la utilización del mecanismo de
     * serialización de Java.
     * 
     * Será necesario que la clase que se vaya a serializar implemente
     * la interfaz Serializable (ver clase Persona).
     * 
     * En el caso de serializar una colección, si navegamos al código fuente
     * de, por ejemplo, ArrayList, veremos que implementa la interfaz serializable
     * por lo que no hay que hacer nada extra.
     * 
     * Veremos ejemplos de cómo serializar y deserializar objetos y colecciones.
     * 
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        // Exportación a un fichero binario de un objeto
        
        Persona p = new Persona("Benito", 22, 1.77f);
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "persona.bin");
        File f = ruta.toFile();

        if (!exportarPersonaABinario(p, f)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Exportado con éxito");
            System.out.println("Vea el resultado en:"+f.getAbsolutePath());
        }

        // Importación de un fichero binario
        if (f.isFile() && f.exists()) {
            Persona persona = importarPersonaDeBinario(f);
            if (persona != null) {
                System.out.println(persona.getPersonaAsString());
            } else {
                System.out.println("Error en la importación");
            }
        }

        // Exportación a un fichero de una lista (colección) de objetos
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Benito", 22, 1.77f));
        personas.add(new Persona("Gustavo", 23, 1.88f));
        personas.add(new Persona("Ramón María", 24, 1.99f));

        Path ruta2 = Paths.get(System.getProperty("user.home"), "Desktop", "personas.bin");
        File f2 = ruta2.toFile();

        if (!exportarListaDePersonasABinario(personas, f2)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Exportado con éxito");
            System.out.println("Vea el resultado en:"+f2.getAbsolutePath());
        }

        // Importación de un fichero JSON
        if (f2.isFile() && f2.exists()) {
            List<Persona> personasImportadas = importarListaDePersonasDeBinario(f2);
            if (personasImportadas != null) {
                System.out.println("Personas importadas:" + personasImportadas.size());
                for (Persona personaImportada : personasImportadas) {
                    System.out.println(personaImportada.getPersonaAsString());
                }
            } else {
                System.out.println("Error en la importación");
            }
        }
        
    }
    
    
    // Serializa una Persona a un archivo binario
    public static boolean exportarPersonaABinario(Persona p, File f) {
        
        
        // Se ha empleado una estructura try-cath-finally.
        // Cuando se traten exepciones se verá en profundidad este tipo de estructura
        // y como utilizar nuevas estructuras del lenguaje como try-catch with resources
        // Especialmente indicado para hacer este código menos verboso.
        // Por el momento lo mantendremos así.
        
        // El bloque finally se ejecuta siempre y se emplea para cerrar el stream
        // independientemente de si hubiera una excepción o no.
        
        
        // TODO: Prueba a poner un punto de parada para comprobarlo!!!!!
        
        ObjectOutputStream oos = null;
        try {
            // Se crea un FileOutputStream a partir de fichero y a partir 
            // de dicho FileOutputStram un ObjectOuputStream, haciendo que
            // La serialización se vuelque a un fichero.
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(p);
            return true;
        } catch (IOException ex) {
            System.err.println("Error durante la serialización: " + ex.getMessage());
            ex.printStackTrace(System.err);
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                }
            }
        }
    }

    // Deserializa una Persona de un archivo binario
    public static Persona importarPersonaDeBinario(File f) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(f));
            return (Persona) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error durante la deserialización: " + ex.getMessage());
            return null;
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                }
            }
        }
    }

    // Serializa una lista de Personas a un archivo binario
    public static boolean exportarListaDePersonasABinario(List<Persona> personas, File f) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(personas);
            return true;
        } catch (IOException ex) {
            System.err.println("Error durante la serialización: " + ex.getMessage());
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                }
            }
        }
    }

    // Deserializa una lista de Personas de un archivo binario
    public static List<Persona> importarListaDePersonasDeBinario(File f) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(f));
            return (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error durante la deserialización: " + ex.getMessage());
            return null;
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                }
            }
        }
    }

    
}
