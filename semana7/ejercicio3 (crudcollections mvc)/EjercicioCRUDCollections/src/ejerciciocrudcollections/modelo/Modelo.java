package ejerciciocrudcollections.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import ejerciciocrudcollections.Persona;

public class Modelo {
    private ArrayList<Persona> personas;

    public Modelo() {
        personas = new ArrayList<>();
    }

    public String anadirPersona(Persona persona) {
        personas.add(persona);
        return "Se ha añadido la persona correctamente.";
    }

    public boolean hayPersonas() {
        return !personas.isEmpty();
    }

    public ArrayList<Persona> listadoPersonas() {
        return personas;
    }

    public boolean eliminarPersona(String nombre) {
        Iterator<Persona> iterator = personas.iterator();
        while (iterator.hasNext()) {
            Persona persona = iterator.next();
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean modificarPersona(String nombre, String nuevoNombre, int nuevaEdad, double nuevaAltura) {
        for (Persona persona : personas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                persona.setNombre(nuevoNombre);
                persona.setEdad(nuevaEdad);
                persona.setAltura(nuevaAltura);
                return true;
            }
        }
        return false;
    }
}