package persistenciaficherojavajsonxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.ArrayList;

import model.Persona;


/**
 *
 * @author Loza
 */
public class PersistenciaFicheroJavaJSONXML {

    /**
     *
     * En este fuente se ejemplifica la utilización de XML y JSON.
     *
     * + La biblioteca GSON para transformar objetos y colecciones en JSON y
     * viceversa.
     *
     * + La biblioteca Jackson para transformar objetos y colecciones en XML y
     * viceversa. También se utiliza para JSON pero en este caso la utilizaremos
     * para XML. 
     * 
     * Vale la pena conocer ambas ya que son de las más famosas.
     *
     * Para utilizarlas será necesario importar los jar en el proyecto como ya se ha
     * hecho anteriormente con biblioteca.jar.
     *
     * Para obtener los jar es posible dirigirse a la página oficial o bajarlos
     * de Studium.
     *
     * Gson: https://mavenlibs.com/jar/file/com.google.code.gson/gson
     * gson-2.10.1.jar
     *
     * Jackson: Aquí necesitaremos varios jar (core, databind,annotations, dataformat xml y stax)
     * 
     * jackson-core-2.15.3.jar
     * jackson-annotations-2.15.3.jar
     * jackson-databind-2.15.3.jar
     * jackson-dataformat-xml-2.15.3.jar
     * stax2-api.4.0.0.jar
     * 
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.15.3
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml/2.15.3
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.15.3
     * https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.15.3
     * https://mvnrepository.com/artifact/org.codehaus.woodstox/stax2-api/4.0.0
     *
     * (apartado files --> jar o bundle)
     *
     * Vemos como según se van necesitando más bibliotecas esto se vuelve muy
     * laborioso. En futuros proyectos proyectos en java u otros lenguajes
     * utilizaréis habitualmente gestores de dependencias y build tools como
     * Maven, Gradle, etc. No como lo hacemos aquí, manualmente.
     * Aquí utilizaremos simples .jar para que veáis el proceso desde cero de 
     * añadir dependencias de clases que necesitará nuestro proyecto.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* 
           Estas bibliotecas tienen mucha más funcionalidad (anotaciones, etc)
           sin embargo se utilizarán empleando el mínimo código posible por simplicidad.
           Para casos concretos o más avanzados será necesario consultar la documentación.
         */
        
        // Descomenta y comenta cada uno de estos para ver un ejemplo.
        // Revisa el path para ver lo que se vuelca en el fichero
        
        //ejemploJSON();

        //ejemploXML(); 
    }

    private static void ejemploJSON() {

        // Exportación a un fichero JSON de un objeto
        Persona p = new Persona("Benito", 22, 1.77f);
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "persona.json");
        File f = ruta.toFile();

        if (!exportarPersonaAJSON(p, f)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Exportado con éxito");
            System.out.println("Vea el resultado en:"+f.getAbsolutePath());
        }

        // Importación de un fichero JSON
        if (f.isFile() && f.exists()) {
            Persona persona = importarPersonaDeJSON(f);
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

        Path ruta2 = Paths.get(System.getProperty("user.home"), "Desktop", "personas.json");
        File f2 = ruta2.toFile();

        if (!exportarListaDePersonasAJSON(personas, f2)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Vea el resultado en:"+f2.getAbsolutePath());
        }

        // Importación de un fichero JSON
        if (f2.isFile() && f2.exists()) {
            List<Persona> personasImportadas = importarListaDePersonasDeJSON(f2);
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

    private static void ejemploXML() {

        // Exportación a un fichero XML de un objeto
        Persona p = new Persona("Benito", 22, 1.77f);
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "persona.xml");
        File f = ruta.toFile();

        if (!exportarPersonaAXML(p, f)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Exportado con éxito");
            System.out.println("Vea el resultado en:"+f.getAbsolutePath());
        }

        // Importación de un fichero XML
        if (f.isFile() && f.exists()) {
            Persona persona = importarPersonaDeXML(f);
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

        Path ruta2 = Paths.get(System.getProperty("user.home"), "Desktop", "personas.xml");
        File f2 = ruta2.toFile();

        if (!exportarListaDePersonasAXML(personas, f2)) {
            System.out.println("Hubo un problema con la exportación");
        }else{
            System.out.println("Exportado con éxito");
            System.out.println("Vea el resultado en:"+f2.getAbsolutePath());
        }

        // Importación de un fichero XML
        if (f2.isFile() && f2.exists()) {
            List<Persona> personasImportadas = importarListaDePersonasDeXML(f2);
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

    public static boolean exportarPersonaAJSON(Persona p, File f) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(p);
            Files.write(f.toPath(), json.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
    }

    public static boolean exportarListaDePersonasAJSON(List<Persona> personas, File f) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(personas);
            Files.write(f.toPath(), json.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
    }

    public static Persona importarPersonaDeJSON(File f) {
        try {
            Gson gson = new Gson();
            // Lee todo el archivo en un String
            String json = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            return gson.fromJson(json, Persona.class);
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return null;
        }
    }

    public static List<Persona> importarListaDePersonasDeJSON(File f) {
        try {
            Gson gson = new Gson();
            // Lee todo el archivo en un String
            String json = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            // Obtiene el tipo de la lista
            Type tipoDeLista = new TypeToken<List<Persona>>() {}.getType();
            return gson.fromJson(json, tipoDeLista);
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return null;
        }
    }

    public static boolean exportarPersonaAXML(Persona p, File f) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(p);
            Files.write(f.toPath(), xml.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (JsonProcessingException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return false;
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
    }

    public static boolean exportarListaDePersonasAXML(List<Persona> personas, File f) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(personas);
            Files.write(f.toPath(), xml.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (JsonProcessingException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return false;
        } catch (IOException ex) {
            // Lo mismo aquí
            System.err.println("Error:" + ex.getMessage());
            return false;
        }
    }

    public static Persona importarPersonaDeXML(File f) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            return xmlMapper.readValue(xml, Persona.class);
        } catch (IOException ex) {
            // Lo mismo aquí
            System.err.println("Error:" + ex.getMessage());
            return null;
        }
    }

    public static List<Persona> importarListaDePersonasDeXML(File f) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            // Utiliza TypeFactory para obtener el tipo de lista correcto
            return xmlMapper.readValue(xml, xmlMapper.getTypeFactory().constructCollectionType(List.class, Persona.class));
        } catch (IOException ex) {
            // TODO veremos como cambiar esto cuando tratemos excepciones
            // de momento retornaremos null si hay algún problema
            System.err.println("Error:" + ex.getMessage());
            return null;
        }
    }

}
