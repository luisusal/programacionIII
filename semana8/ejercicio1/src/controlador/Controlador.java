package controlador;

import vista.Vista;
import modelo.*;
import es.usal.progiii.tools.Rutas;
import java.util.ArrayList;
import java.nio.file.Path;

public class Controlador {
    Vista vista;
    Modelo modelo;
    Path ruta = Rutas.pathToFileOnDesktop("equipos.txt"); // Ruta del archivo de equipos en el escritorio

    public Controlador(Vista v, Modelo m) { // Constructor del controlador que recibe la vista y el modelo del main como parámetros
        this.vista = v;
        this.modelo = m;
    }

    public void init() { // Método de inicialización del controlador, llama a cargarDatosInicial() y luego muestra el menú de la vista
        cargarDatosInicial(); // Carga los datos iniciales desde el archivo
        vista.mostrarMenu(); // en vista, muestra el menú principal de la aplicación
    }

    public void cargarDatosInicial() {
        int valor = modelo.cargarPartidosDesdeArchivos(ruta); // Llama al método cargarPartidosDesdeArchivos() del modelo, pasando la ruta del archivo de equipos como parámetro y almacena el valor devuelto en la variable valor
        if (valor < 0) { // Si el valor devuelto es menor que 0, significa que se ha producido un error al importar los equipos, por lo que se muestra un mensaje de error en la vista
            vista.mostrarError("Se ha producido un error al importar equipos");
        } else { // Si el valor devuelto es mayor o igual a 0, significa que se han importado correctamente los equipos, por lo que se muestra un mensaje en la vista indicando cuántos equipos se han importado
            vista.mostrarMsg("Se han importado " + valor + " equipos");
        }
    }

    public ArrayList<Partido> getPartidos() { // MODELO Método que devuelve la lista de partidos del modelo, llamando al método getPartidos() del modelo y devolviendo el resultado
        return modelo.getPartidos();
    }

    public void asignarGoles(int numPartido, int golesLocal, int golesVisitante) { // VISTA Método que asigna los goles de un partido específico, recibe como parámetros el número del partido y los goles del equipo local y visitante
        Partido partido = modelo.getPartidos().get(numPartido); // MODELO Obtiene el partido correspondiente al número de partido pasado como parámetro, llamando al método getPartidos() del modelo y obteniendo el partido en la posición numPartido de la lista
        partido.setGolesLocal(golesLocal); // PARTIDO Asigna los goles del equipo local al partido obtenido, llamando al método setGolesLocal() del partido y pasando como parámetro los goles del equipo local
        partido.setGolesVisitante(golesVisitante); // PARTIDO Asigna los goles del equipo visitante al partido obtenido, llamando al método setGolesVisitante() del partido y pasando como parámetro los goles del equipo visitante
    }
}