package vista;

import controlador.*;
import es.usal.progiii.tools.Esdia;
import modelo.Partido;

import java.util.ArrayList;

public class Vista {
    Controlador controlador;

    public void setControlador(Controlador c) {
        this.controlador = c;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- QUINIELA ---");
            System.out.println("1) Pedir nombres de equipo");
            System.out.println("2) Pedir resultados");
            System.out.println("3) Mostrar quiniela");
            System.out.println("4) Salir");
            opcion = Esdia.readInt("Introduce una opcion: ");

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    pedirResultados();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 4);
    }

    public void mostrarMsg(String msg) {
        System.out.println(msg);
    }

    public void mostrarError(String error) {
        System.out.println(error);
    }

    public void pedirResultados() {
        ArrayList<Partido> partidos = controlador.getPartidos();
        int contador = 0;
        for (Partido p : partidos) {
            System.out.println("Partido " + (contador + 1));

            int golesLocal = Esdia.readInt("Introduce los goles de " + p.getEquipoLocal() + ": ");
            int golesVisitante = Esdia.readInt("Introduce los goles de " + p.getEquipoVisitante() + ": ");

            controlador.asignarGoles(contador, golesLocal, golesVisitante);
            contador++;
        }
    }
}