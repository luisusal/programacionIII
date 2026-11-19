package model;

import java.util.Arrays;

public class Concesionario {
    private static final int CAPACIDAD = 50;

    private Coche[] coches = new Coche[CAPACIDAD];
    private int total = 0;

    private int buscarIndice(String matricula) {
        for (int i = 0; i < total; i++) {
            if (coches[i].getMatricula().equalsIgnoreCase(matricula)) {
                return i;
            }
        }
        return -1;
    }

    public boolean estaLleno() {
        return total == CAPACIDAD;
    }

    // CREATE: devuelve false si no hay sitio o si ya existe esa matricula
    public boolean crear(Coche coche) {
        if (estaLleno() || buscarIndice(coche.getMatricula()) != -1) {
            return false;
        }
        coches[total] = coche;
        total++;
        return true;
    }

    // READ: todos los coches (solo las posiciones ocupadas)
    public Coche[] listar() {
        return Arrays.copyOf(coches, total);
    }

    // READ: un coche por matricula (null si no existe)
    public Coche buscar(String matricula) {
        int indice = buscarIndice(matricula);
        if (indice == -1) {
            return null;
        }
        return coches[indice];
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

    // DELETE: borra el coche y desplaza los siguientes una posicion a la izquierda
    public boolean eliminar(String matricula) {
        int indice = buscarIndice(matricula);
        if (indice == -1) {
            return false;
        }
        for (int i = indice; i < total - 1; i++) {
            coches[i] = coches[i + 1];
        }
        total--;
        coches[total] = null;
        return true;
    }

    public int getTotal() {
        return total;
    }
}
