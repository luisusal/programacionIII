package ejerciciocrudcollections;

import static es.usal.progiii.tools.Esdia.*;
import java.util.HashSet;

/**
 *
 * 
 * Ejercicio CRUD Collections. (Con la colección HashSet)
 * 
 * Este ejemplo muestra como hacer en un CRUD en un HashSet con sus
 * peculiaridades.
 * 
 * Al decir que no existan dos objetos iguales, es necesario abordar
 * el tema referente a como definir cuando dos objetos son iguales.
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
public class EjercicioCRUDHashSet {
    
    private static HashSet<Persona> personas = new HashSet<>();

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
                case 1: agregarPersona(); break;
                case 2: eliminarPersona(); break;
                case 3: modificarPersona(); break;
                case 4: listarPersonas(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona: ");
        int edad = readInt("Ingrese la edad de la persona: ");
        double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ");

        Persona nuevaPersona = new Persona(nombre, edad, altura);
        // Add devuelve false si la persona añadida ya está en el Set
        // Para que la persona sea igual a otra es necesario implementar equals y hash
        // Consulta la clase Persona y los métodos implementados al final de esta.
        if (!personas.add(nuevaPersona)) {
            System.out.println("Persona con ese nombre ya existe.");
        }
    }

    public static void eliminarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona a eliminar: ");
        Persona personaAEliminar = new Persona(nombre, 0, 0); // Valores temporales solo para comparación
        // Equals y HashCode se han implementado solo teniendo en cuenta el nombre
        if (!personas.remove(personaAEliminar)) {
            System.out.println("Persona no encontrada.");
        } else {
            System.out.println("Persona eliminada.");
        }
    }

    public static void modificarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona a modificar: ");

        Persona personaAModificar = new Persona(nombre, 0, 0); // Valores temporales solo para comparación
        // Aquí sucede lo mismo.
        if (!personas.contains(personaAModificar)) {
            System.out.println("Persona no encontrada.");
            return;
        }

        // Continuación de la lógica para modificar los datos
        String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
        int nuevaEdad = readInt("Ingrese la nueva edad: ");
        System.out.print("Ingrese la nueva altura (ej. 1.75): ");
        double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ");

        // Solo es necesario el nombre para que dos Personas sean iguales
        personas.remove(personaAModificar);
        personas.add(new Persona(nuevoNombre, nuevaEdad, nuevaAltura));
    }

    public static void listarPersonas() {

        // Si está vacío, no se puede recorrer
        if (personas.isEmpty()) {
            System.out.println("No hay personas para mostrar.");
            return;
        }

        for (Persona persona : personas) {
            System.out.println(String.format("HashCode:%10d - %s",persona.hashCode(), persona.getEstadoComoString()));
        }
    }
    
}
