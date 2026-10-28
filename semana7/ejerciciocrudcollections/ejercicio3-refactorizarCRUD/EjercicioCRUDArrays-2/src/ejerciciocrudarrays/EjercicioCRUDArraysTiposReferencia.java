package ejerciciocrudarrays;

import static es.usal.progiii.tools.Esdia.*;

/**
 *
 * 
 * Ejercicio CRUD Arrays. (Con tipos de Referencia, en este caso clase Persona)
 * 
 * Ejercicio para ejemplificar altas, bajas, modificaciones y listados
 * empleando Arrays y la clase utilidad Arrays.
 * 
 * Se podrá comprobar que rápidamente la gestión de un simple CRUD se complica
 * demasiado frente al mismo ejercicio realizado con Colecciones como ArrayList
 * 
 * Por lo general se emplearán colecciones para este propósito.
 * 
 * No se sigue ningún patrón arquitectónico en este ejercicio.
 * 
 * Se realiza todo en la misma clase para mayor claridad, sin embargo
 * esto se aplica a los Arrays que residan en cualquier otro objeto del programa.
 * 
 * 
 * @author Loza
 */
public class EjercicioCRUDArraysTiposReferencia {
    
    private static final int MAX_SIZE = 5;
    private static Persona[] personas = new Persona[MAX_SIZE];
    private static int personaCount = 0;

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
        if (personaCount < MAX_SIZE) {
            String nombre = readString_ne("Ingrese el nombre de la persona: ");
            int edad = readInt("Ingrese la edad de la persona: ");
            double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ");
            personas[personaCount++] = new Persona(nombre, edad, altura);
            System.out.println("Persona añadida correctamente.");
        } else {
            System.out.println("Array de personas está lleno.");
        }
    }

    public static void eliminarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona a eliminar: ");
        boolean encontrado = false;
        for (int i = 0; i < personaCount; i++) {
            // Para comparar cadenas empleamos equals
            if (personas[i].getNombre().equals(nombre)) {
                encontrado = true;
                for (int j = i; j < personaCount - 1; j++) {
                    personas[j] = personas[j + 1];
                }
                personaCount--;

                System.out.println("Persona eliminada correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void modificarPersona() {

        String nombre = readString_ne("Ingrese el nombre de la persona a modificar: ");
        boolean encontrado = false;
        for (int i = 0; i < personaCount; i++) {
            if (personas[i].getNombre().equals(nombre)) {
                String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
                int nuevaEdad = readInt("Ingrese la nueva edad: ");
                double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ");

                personas[i].setNombre(nuevoNombre);
                personas[i].setEdad(nuevaEdad);
                personas[i].setAltura(nuevaAltura);

                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void listarPersonas() {

        if (personaCount == 0) {
            System.out.println("No hay personas en el array.");
            return;
        }

        for (int i = 0; i < personaCount; i++) {
            System.out.println(personas[i].getEstadoComoString());
        }
    }
    
}
