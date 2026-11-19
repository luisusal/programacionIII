package model;

import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private List<Coche> coches = new ArrayList<>();

    // El ArrayList crece solo, asi que nunca esta "lleno"
    public boolean estaLleno() {
        return false;
    }

    // CREATE: devuelve false si ya existe esa matricula
    public boolean crear(Coche coche) {
        if (buscar(coche.getMatricula()) != null) {
            return false;
        }
        coches.add(coche);
        return true;
    }

    // READ: todos los coches
    public List<Coche> listar() {
        return coches;
    }

    // READ: un coche por matricula (null si no existe)
    public Coche buscar(String matricula) {
        for (Coche coche : coches) {
            if (coche.getMatricula().equalsIgnoreCase(matricula)) {
                return coche;
            }
        }
        return null;
    }

    // UPDATE: cambia los datos de un coche existente
    public boolean actualizar(String matricula, String marca, String modelo, int anio, double precio) {
        Coche coche = buscar(matricula);
        if (coche == null) {
            return false;
        }
        coche.setMarca(marca);
        coche.setModelo(modelo);
        coche.setAnio(anio);
        coche.setPrecio(precio);
        return true;
    }

    // DELETE: el ArrayList recoloca solo los elementos
    public boolean eliminar(String matricula) {
        Coche coche = buscar(matricula);
        if (coche == null) {
            return false;
        }
        coches.remove(coche);
        return true;
    }

    public int getTotal() {
        return coches.size();
    }
}
