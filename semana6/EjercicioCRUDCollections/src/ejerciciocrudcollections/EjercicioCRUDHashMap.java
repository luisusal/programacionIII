package ejerciciocrudcollections;

import static es.usal.progiii.tools.Esdia.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 * Ejercicio CRUD Collections. (Con la colección HashMap)
 * 
 * Ejercicio para ejemplificar altas, bajas, modificaciones y listados
 * empleando un HashMap.
 * 
 * Se puede comprobar como es mucho más sencilla la gestión de nuevos elementos
 * en la colección de forma dinámica.
 * 
 * 
 * No se sigue ningún patrón arquitectónico en este ejercicio.
 * 
 * Se realiza todo en la misma clase para mayor claridad, sin embargo
 * esto se aplica a las colecciones que residan en cualquier otro objeto del programa.
 * 
 * 
 * @author Loza
 */
public class EjercicioCRUDHashMap {

    private static HashMap<String, Persona> personas = new HashMap<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Listar personas");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    eliminarPersona();
                    break;
                case 3:
                    modificarPersona();
                    break;
                case 4:
                    listarPersonas();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarPersona() {
        String dni = readString_ne("Ingrese el dni de la persona: ");
        String nombre = readString_ne("Ingrese el nombre de la persona: ");
        int edad = readInt("Ingrese la edad de la persona: ");
        double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ");
        personas.put(dni, new Persona(nombre, edad, altura));
    }

    public static void eliminarPersona() {
        String dni = readString_ne("Ingrese el dni de la persona a eliminar: ");
        if (personas.containsKey(dni)) {
            personas.remove(dni);
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void modificarPersona() {
        String dni = readString_ne("Ingrese el dni de la persona a modificar: ");

        if (personas.containsKey(dni)) {

            String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
            int nuevaEdad = readInt("Ingrese la nueva edad: ");
            double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ");

            Persona personaModificada = new Persona(nuevoNombre, nuevaEdad, nuevaAltura);
            personas.put(dni, personaModificada);

        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void listarPersonas() {

        // Si está vacío, no se puede recorrer
        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
            return;
        }

        for (Map.Entry<String, Persona> entry : personas.entrySet()) {
            String dni = entry.getKey();
            Persona value = entry.getValue();
            System.out.println(String.format("DNI:%9s - %s",dni,value.getEstadoComoString()));
        }
    }

}
