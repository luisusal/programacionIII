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
                    break; // No se implementa, ya que los nombres de los equipos se cargan desde el archivo
                case 2:
                    pedirResultados();
                    break;
                case 3:
                    mostrarQuiniela();
                    break; // No se implementa, ya que la quiniela se muestra en la vista, no en el controlador
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 4);
    }

    public void mostrarMsg(String msg) { // Método que muestra un mensaje en la vista, se utiliza para mostrar mensajes de éxito o información al usuario
        System.out.println(msg);
    } 

    public void mostrarError(String error) { // Método que muestra un mensaje de error en la vista, se utiliza para mostrar mensajes de error al usuario
        System.out.println(error);
    }
    
    public void pedirResultados() { // Método que pide los resultados de los partidos al usuario, se utiliza para que el usuario introduzca los goles de cada equipo y se asignen a los partidos correspondientes en el modelo
        ArrayList<Partido> partidos = controlador.getPartidos(); // Obtiene la lista de partidos del modelo, llamando al método getPartidos() del controlador y almacenando el resultado en la variable partidos
        int contador = 0;
        for (Partido p : partidos) {
            System.out.println("Partido " + (contador + 1));

            int golesLocal = Esdia.readInt("Introduce los goles de " + p.getEquipoLocal() + ": "); // Pide al usuario que introduzca los goles del equipo local, utilizando el método readInt() de la clase Esdia para leer un entero desde la entrada estándar, y almacenando el resultado en la variable golesLocal. getEquipoLocal() es un método de la clase Partido que devuelve el nombre del equipo local, para mostrarlo en el mensaje al usuario
            int golesVisitante = Esdia.readInt("Introduce los goles de " + p.getEquipoVisitante() + ": "); // Pide al usuario que introduzca los goles del equipo visitante, utilizando el método readInt() de la clase Esdia para leer un entero desde la entrada estándar, y almacenando el resultado en la variable golesVisitante. getEquipoVisitante() es un método de la clase Partido que devuelve el nombre del equipo visitante, para mostrarlo en el mensaje al usuario

            controlador.asignarGoles(contador, golesLocal, golesVisitante); // Llama al método asignarGoles() del controlador, pasando como parámetros el número del partido (contador), los goles del equipo local (golesLocal) y los goles del equipo visitante (golesVisitante), para que el controlador asigne los goles a los partidos correspondientes en el modelo
            contador++;
        }
    }
}