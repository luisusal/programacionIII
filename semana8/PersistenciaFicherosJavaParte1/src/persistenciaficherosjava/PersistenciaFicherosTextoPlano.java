package persistenciaficherosjava;

import static es.usal.progiii.tools.OpMat.printToScreen;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Persona;

/**
 *
 *
 * Proyecto de ejemplo de de persistencia en ficheros.
 *
 * En esta clase se muestra como exportar/importar (escribir/leer) información
 * a/de un fichero de texto plano en Java.
 *
 *
 * Se presentan varios ejemplos:
 *
 * - El primero utiliza Scanner y PrintWriter, clases ya conocidas, para
 * escribir y leer texto plano en un fichero.
 *
 * - El segundo escribe en un fichero un formato denominado .col que consiste en
 * establecer un ancho fijo para las columnas. Se utilizan clases como Files y
 * Paths que al igual que pasaba con Collections y Arrays son clases de utilidad
 * con métodos estáticos muy útiles.
 *
 *
 *
 * @author Loza
 */
public class PersistenciaFicherosTextoPlano {

    /**
     *
     * Método principal. Descomentar ejemplos segun convenga.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Este código es compatble con versiones de JDK 8 o superior
        //ejemplo1();
        //ejemplo2();
    }

    /**
     * *
     *
     * Este ejemplo escribe en un fichero un texto que contiene la información
     * de un objeto Persona. Sin formato, texto libre.
     *
     */
    private static void ejemplo1() {

        // Instanciamos un objeto persona
        Persona p = new Persona("Alvaro", 50, 1.77f);

        // Obtenemos una ruta a una carpeta denominada Desktop en la carpeta home
        // del usuario. Recordad no utilizar separadores específicos de una plataforma
        String rutaCompletaAlArchivo = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "datos.txt";

        // Creamos un objeto file a partir de dicha ruta
        File archivo = new File(rutaCompletaAlArchivo);

        // Creamos una referencia de un PrintWriter nula.
        PrintWriter printWriter = null;

        // ESCRITURA (PrintWriter)
        // Utilizamos una estructura try-catch-finally para capturar
        // posibles excepciones y asegurarnos de que se cierra el stream
        // con finally
        // Cuado se traten excepciones veremos esto de forma más reducida (try catch with resources)
        try {
            // Abrir el stream al fichero con una instancia de PrintWriter
            printWriter = new PrintWriter(archivo);
            printWriter.printf("Hola %s%n", p.getEdad());
            printWriter.printf("Que sepas que tienes %d años y mides %.2f", p.getEdad(), p.getAltura());
            // Mostramos donde se ha escrito el fichero para poder inspeccionarlo
            System.out.println("Persona exportada exitosamente a: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            // Mostramos el mensaje de la excepción
            System.err.println("Ocurrió un error al intentar exportar la persona: " + e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

        // TODO: PON UN PUNTO DE PARADA EN EL SIGUIENTE IF Y BORRA EL FICHERO PARA COMPROBAR QUÉ SUCEDE.
        // LECTURA (Scanner)
        // Leemos el contenido del fichero anterior
        // Utilizaremos un StringBuilder útil para trabajar con cadenas de forma eficiente.
        if (archivo.exists() && archivo.isFile()) {

            Scanner scanner = null;
            try {
                // Abrir el stream al fichero con una instancia de Scanner
                scanner = new Scanner(archivo);

                // StringBuilder para almacenar el contenido del archivo
                StringBuilder contenido = new StringBuilder();

                // Leer del archivo y procesar los datos
                while (scanner.hasNextLine()) {
                    contenido.append(scanner.nextLine()).append(System.lineSeparator());
                }

                // Convertir el contenido a String
                String textoCompleto = contenido.toString();
                System.out.println("Contenido del archivo:");
                System.out.println(textoCompleto);
            } catch (IOException e) {
                System.err.println("Ocurrió un error al intentar leer la persona: " + e.getMessage());
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }

        } else {
            System.out.println("La ruta apunta a un fichero que no existe o no es un fichero");
        }

    }

    private static void ejemplo2() {

        // Establecemos la ruta al fichero, esta vez con la clase utilidad Paths
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.txt");

        // Creamos una lista de personas que volcaremos al fichero
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alvaro", 50, 1.74f));
        personas.add(new Persona("Luis", 52, 1.75f));
        personas.add(new Persona("Alfonso", 53, 1.76f));

        // ESCRITURA
        // Transformamos las personas a una lista de strings que podremos escribir
        ArrayList<String> lineas = new ArrayList<>();
        for (Persona p : personas) {
            lineas.add(p.getAsColumnString());
        }

        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }

        // LECTURA
        ArrayList<Persona> personasLeidas = new ArrayList<>();
        try {
            List<String> lineasLeidas = Files.readAllLines(ruta, StandardCharsets.UTF_8);

            // Se deben procesar todas las lineas, transformando 
            for (String lineasLeida : lineasLeidas) {
                Persona p = Persona.getPersonFromColumnString(lineasLeida);
                if (p != null) {
                    personasLeidas.add(p);
                }
            }

        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }

        // Mostramos con métodos de Biblioteca_progiii.jar
        String[][] tabla = new String[personas.size()][];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = personasLeidas.get(i).getInstanceAsArrayOfStrings();
        }

        try {
            // Comprobad métodos en Biblioteca_progiii.jar y como trabajan
            printToScreen(tabla);
        } catch (Exception ex) {
            System.out.println("Error mostrando tabla");
        }

    }

}
