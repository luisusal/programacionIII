package ejerciciocrudcollections.controlador;

import java.util.ArrayList;
import ejerciciocrudcollections.Persona;
import ejerciciocrudcollections.modelo.Modelo;
import ejerciciocrudcollections.vista.Vista;

public class Controlador {
    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void run() {
        vista.mostrarMenu();
    }

    public String anadirPersona(Persona persona) {
        return modelo.anadirPersona(persona);
    }

    public boolean hayPersonas() {
        return modelo.hayPersonas();
    }

    public ArrayList<Persona> listadoPersonas() {
        return modelo.listadoPersonas();
    }

    public boolean eliminarPersona(String nombre) {
        return modelo.eliminarPersona(nombre);
    }

    public boolean modificarPersona(String nombre, String nuevoNombre, int nuevaEdad, double nuevaAltura) {
        return modelo.modificarPersona(nombre, nuevoNombre, nuevaEdad, nuevaAltura);
    }
}