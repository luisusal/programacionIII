package ejerciciocrudcollections.vista;

import static es.usal.progiii.tools.Esdia.*;

import java.util.ArrayList;
import ejerciciocrudcollections.Persona;
import ejerciciocrudcollections.controlador.Controlador;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
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

    public void agregarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona: ");
        int edad = readInt("Ingrese la edad de la persona: ", 1, 150);
        double altura = readDouble("Ingrese la altura de la persona (ej. 1.75): ", 0, 3);
        
        String msg = controlador.anadirPersona(new Persona(nombre, edad, altura));
        System.out.println(msg);
    }

    public void eliminarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona a eliminar: ");
        boolean eliminado = controlador.eliminarPersona(nombre);
        
        if (eliminado) {
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public void modificarPersona() {
        String nombre = readString_ne("Ingrese el nombre de la persona a modificar: ");
        String nuevoNombre = readString_ne("Ingrese el nuevo nombre: ");
        int nuevaEdad = readInt("Ingrese la nueva edad: ", 1, 150);
        double nuevaAltura = readDouble("Ingrese la nueva altura (ej. 1.75): ", 0, 3);

        boolean modificado = controlador.modificarPersona(nombre, nuevoNombre, nuevaEdad, nuevaAltura);
        
        if (modificado) {
            System.out.println("Persona modificada correctamente.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public void listarPersonas() {
        if (controlador.hayPersonas()) {
            ArrayList<Persona> listadoPersonas = controlador.listadoPersonas();
            for (Persona persona : listadoPersonas) {
                System.out.println(persona.getEstadoComoString());
            }
        } else {
            System.out.println("No hay personas en la lista.");
        }
    }
}