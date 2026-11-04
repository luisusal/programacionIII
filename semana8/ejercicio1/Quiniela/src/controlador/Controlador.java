package controlador;

import java.util.List;

import modelo.Modelo;
import quiniela.Partido;
import quiniela.Quiniela;
import vista.Vista;

public class Controlador {
    // Atributos del controlador: acceso a la vista y al modelo.
    private final Vista vista;
    private final Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        // Guardamos las referencias y enlazamos la vista con este controlador.
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setControlador(this);
    }

    public void iniciar() {
        // Arranca la aplicación mostrando el menú principal.
        vista.mostrarMenu();
    }

    public void pedirNombresEquipos() {
        // Muestra el mensaje y limpia la lista antes de crear una nueva quiniela.
        vista.mostrarMensaje("\nIntroduce los nombres de los equipos para cada partido.");
        modelo.limpiarPartidos();

        // Recorre los 15 partidos que debe tener la quiniela.
        for (int i = 0; i < modelo.getNumeroPartidos(); i++) {
            vista.mostrarMensaje("\n--- PARTIDO " + (i + 1) + " ---");
            // Pide el equipo local y visitante a la vista.
            String equipoLocal = vista.leerEquipoLocal();
            String equipoVisitante = vista.leerEquipoVisitante();
            // Guarda el partido nuevo en el modelo.
            modelo.addPartido(new Partido(equipoLocal, equipoVisitante));
        }

        vista.mostrarMensaje("\nTodos los equipos han sido guardados.");
    }

    public void pedirResultados() {
        // Obtenemos la lista de partidos que están en el modelo.
        List<Partido> partidos = modelo.getPartidos();

        // Si no hay partidos, avisamos al usuario.
        if (partidos == null || partidos.isEmpty()) {
            vista.mostrarMensaje("Primero debes introducir los nombres de los equipos.");
            return;
        }

        // Recorremos cada partido para pedir sus goles.
        for (int i = 0; i < partidos.size(); i++) {
            Partido partido = partidos.get(i);
            if (partido == null) {
                vista.mostrarMensaje("Falta introducir los equipos del partido " + (i + 1) + ".");
                return;
            }

            vista.mostrarMensaje("\n--- PARTIDO " + (i + 1) + " ---");
            vista.mostrarMensaje(partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante());

            // Leemos los goles desde la vista.
            int golesLocal = vista.leerGolesLocal();
            int golesVisitante = vista.leerGolesVisitante();

            // Guardamos los goles dentro del partido.
            partido.setGolesLocal(golesLocal);
            partido.setGolesVisitante(golesVisitante);
        }

        vista.mostrarMensaje("\nResultados guardados correctamente.");
    }

    public void mostrarQuiniela() {
        // Recoge la lista actual de partidos del modelo.
        List<Partido> partidos = modelo.getPartidos();

        // Comprueba que haya partidos antes de intentar mostrarlos.
        if (partidos == null || partidos.isEmpty()) {
            vista.mostrarMensaje("Todavia no hay partidos registrados.");
            return;
        }

        // Comprueba que todos los partidos estén completos.
        for (Partido partido : partidos) {
            if (partido == null) {
                vista.mostrarMensaje("Falta completar algun partido antes de mostrar la quiniela.");
                return;
            }
        }

        // Convierte la lista en un array porque la clase Quiniela trabaja con arrays.
        Partido[] arrayPartidos = partidos.toArray(new Partido[0]);
        Quiniela quiniela = new Quiniela(arrayPartidos);
        // Solicita a la vista que muestre la tabla final.
        vista.mostrarQuiniela(quiniela.obtenerTablaQuiniela());
    }
}
