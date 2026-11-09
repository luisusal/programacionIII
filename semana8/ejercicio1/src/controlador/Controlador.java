package controlador;

import vista.Vista;
import modelo.*;
import es.usal.progiii.tools.Rutas;
import java.util.ArrayList;
import java.nio.file.Path;

public class Controlador {
    Vista vista;
    Modelo modelo;
    Path ruta = Rutas.pathToFileOnDesktop("equipos.txt");

    public Controlador(Vista v, Modelo m) {
        this.vista = v;
        this.modelo = m;
    }

    public void init() {
        cargarDatosInicial();
        vista.mostrarMenu();
    }

    public void cargarDatosInicial() {
        int valor = modelo.cargarPartidosDesdeArchivos(ruta);
        if (valor < 0) {
            vista.mostrarError("Se ha producido un error al importar equipos");
        } else {
            vista.mostrarMsg("Se han importado " + valor + " equipos");
        }
    }

    public ArrayList<Partido> getPartidos() {
        return modelo.getPartidos();
    }

    public void asignarGoles(int numPartido, int golesLocal, int golesVisitante) {
        Partido partido = modelo.getPartidos().get(numPartido);
        partido.setGolesLocal(golesLocal);
        partido.setGolesVisitante(golesVisitante);
    }
}