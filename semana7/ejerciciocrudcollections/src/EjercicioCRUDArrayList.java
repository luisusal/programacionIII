package semana7.ejerciciocrudcollections.src;
import static es.usal.progiii.tools.Esdia.*;

package semana7.ejerciciocrudcollections.src;
import ejerciciocrudcollections.vista.Vista;
import ejerciciocrudcollections.model.Model;
import ejerciciocrudcollections.controlador.Controlador;

/**
 *
 * 
 * Ejercicio CRUD Collections. (Con la colección ArrayList)
 * 
 * Ejercicio para ejemplificar altas, bajas, modificaciones y listados
 * empleando Colecciones.
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
public class EjercicioCRUDArrayList {

    // Ahora lo haremos con colecciones, en concreto ArrayList
    // Empleamos <Persona> para indicar el tipo de la colección.
    // Fijaos que la colección podrá crecer siempre y cuando haya memoria
    // disponible dinámicamente.
    private static ArrayList<Persona> personas = new ArrayList<>();

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
                    //eliminarPersonaConIterator();
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
        String nombre = readString_ne("Ingrese el nombre de la persona: ");
        int edad = readInt("Ingrese la edad de la persona: ", 1, 150);
        double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ", 0, 3);
        personas.add(new Persona(nombre, edad, altura));
    }

    public static void eliminarPersonaConIterator() {
        String nombre = readString_ne("Ingrese el nombre de la persona a eliminar: ");
        boolean eliminado = false;
        Iterator<Persona> iterator = personas.iterator();
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equals(nombre)) {
                iterator.remove();
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void eliminarPersona() {

        String nombre = readString_ne("Ingrese el nombre de la persona a eliminar: ");
        Persona personaAEliminar = null;

        // Atención se debe tener especial cuidado cuando se recorre una
        // colección y se elimina uno de sus elementos. No deberíamos
        // eliminar un elemento empleando el bucle for each
        // Como alternativa se podría eliminar utilizando un iterator.
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personaAEliminar = persona;
                break;
            }
        }
        if (personaAEliminar != null) {
            personas.remove(personaAEliminar);
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void modificarPersona() {

        String nombre = readString_ne("Ingrese el nombre de la persona a modificar: ");
        Persona personaAModificar = null;
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personaAModificar = persona;
                break;
            }
        }
        if (personaAModificar != null) {
            String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
            int nuevaEdad = readInt("Ingrese la nueva edad: ");
            double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ");

            personaAModificar.setNombre(nuevoNombre);
            personaAModificar.setEdad(nuevaEdad);
            personaAModificar.setAltura(nuevaAltura);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void listarPersonas() {

        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
            return;
        }

        for (Persona persona : personas) {
            System.out.println(persona.getEstadoComoString());
        }
    }

}
