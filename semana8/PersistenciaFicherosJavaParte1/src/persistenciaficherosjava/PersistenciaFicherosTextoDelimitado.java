/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistenciaficherosjava;

import static es.usal.progiii.tools.OpMat.*;
import es.usal.progiii.tools.Rutas;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Persona;

/**
 *
 * Proyecto de ejemplo de de persistencia en ficheros.
 *
 * En esta clase se muestra como exportar/importar (escribir/leer) en ficheros
 * de texto con formato delimitado por un caracter seleccionado.
 * 
 * 
 * Mejoras que implementar:
 * 
 * Trasladar esto a un proyecto MVC con las restricciones que ello conlleva.
 * Pensad como devolver si una operación ha ido bien o ha ido mal en el modelo y 
 * como se traslada esto a la vista.
 * 
 * 
 * @author Loza
 */
public class PersistenciaFicherosTextoDelimitado {
    
    public static void main(String[] args) {
        
        List<Persona> personas = List.of(
                new Persona("Felipe Juan Froilán de Marichalar y Borbón", 25,1.75f),
                new Persona("Carlos", 35,1.75f)
        );
        
        ejemploSinBiblioteca(personas);
        ejemploConBIblioteca(personas);
    }

    public static void ejemploSinBiblioteca(List<Persona> personas) {
        // Establecemos la ruta al fichero, esta vez con la clase utilidad Paths
        Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.txt");
        
        String delimitador = ";";
        
        exportarDelimitado(ruta, personas, delimitador);
        
        List<Persona> personasLeidas = importarDelimitado(ruta, delimitador);
        System.out.println("Personas leidas:"+personasLeidas.size());
    }

    public static void ejemploConBIblioteca(List<Persona> personas) {

        File f = Rutas.fileToFileOnDesktop("datos2.txt");
        
        String delimitador2 = "#";
        
        exportarDelimitadoBiblioteca(f.toPath(), personas, delimitador2);
        
        List<Persona> personasLeidasConBiblioteca = importarDelimitadoBiblioteca(f.toPath(), delimitador2);
        
        // Mostramos con métodos de Biblioteca_progiii.jar
        String [][] tabla = new String[personasLeidasConBiblioteca.size()][];
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = personasLeidasConBiblioteca.get(i).getInstanceAsArrayOfStrings();
        }
        
        try {
            // Comprobad métodos en Biblioteca_progiii.jar y como trabajan
            printToScreen2(tabla);
        } catch (Exception ex) {
            System.out.println("Error mostrando tabla");
        }
    }

    public static void exportarDelimitado(Path ruta, List<Persona> personas, String delimitador) {

        ArrayList<String> lineas = new ArrayList<>();
        for (Persona persona : personas) {
            lineas.add(persona.getInstanceAsDelimitedString(delimitador));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            System.out.println("Datos exportados exitosamente a: " + ruta.toFile().getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ocurrió un error al intentar exportar las personas: " + e.getMessage());
        }
        
    }
    
    public static List<Persona> importarDelimitado(Path ruta, String delimitador) {

        ArrayList<Persona> personas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(ruta);
            for (String linea : lineas) {
                Persona p = Persona.getPersonFromDelimitedString(linea, delimitador);
                if(p != null){
                    personas.add(p);
                }
            }
        } catch (IOException e) {
            // En otros ejemplos propagaremos una exception
            return null;
        }
         
        return personas;
    }
    
    public static void exportarDelimitadoBiblioteca(Path ruta, List<Persona> personas, String delimitador) {

        // Biblioteca trabaja con matrices (se podría pasar directamente al método)
        String [][] matrix = new String[personas.size()][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = personas.get(i).getInstanceAsArrayOfStrings();
        }
        
        try {
            exportToDisk(matrix, ruta.toFile(), delimitador);
            System.out.println("Datos exportados exitosamente a: " + ruta.toFile().getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Ocurrió un error al intentar exportar las personas: " + e.getMessage());
        }
    }
    
    public static List<Persona> importarDelimitadoBiblioteca(Path ruta, String delimitador) {
        
        ArrayList<Persona> personasLeidas = new ArrayList<>();
        try {
            String [][] matrix = importFromDisk(ruta.toFile(), delimitador);
            
            for (int i = 0; i < matrix.length; i++) {
                // Usamos join para crear una delimitada y aprovechar el fctory
                // TODO: crear un factory a partir de String[]
                Persona p = Persona.getPersonFromDelimitedString(String.join(delimitador, matrix[i]),delimitador);
                if(p != null){
                    personasLeidas.add(p);
                }
            }
            
        } catch (Exception ex) {
            return null;
        }
        
        return personasLeidas;
    }
    
    
}
