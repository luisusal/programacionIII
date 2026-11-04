package modelo;

import java.util.ArrayList;
import java.util.List;

import quiniela.Partido;

public class Modelo {
    // Número fijo de partidos de la quiniela.
    private static final int NUMERO_PARTIDOS = 15;
    // Guardamos los partidos en una lista dinámica en vez de un array fijo.
    private final List<Partido> partidos;

    public Modelo() {
        // Inicializamos la lista vacía para ir añadiendo partidos.
        partidos = new ArrayList<>();
    }

    public int getNumeroPartidos() {
        // Devuelve cuántos partidos debe tener la quiniela.
        return NUMERO_PARTIDOS;
    }

    public List<Partido> getPartidos() {
        // Devuelve la lista de partidos para que el controlador pueda trabajar con ella.
        return partidos;
    }

    public void limpiarPartidos() {
        // Borra todos los partidos para comenzar otra quiniela nueva.
        partidos.clear();
    }

    public void addPartido(Partido partido) {
        // Añade un partido si todavía no hemos llegado a 15.
        if (partidos.size() < NUMERO_PARTIDOS) {
            partidos.add(partido);
        }
    }
}
