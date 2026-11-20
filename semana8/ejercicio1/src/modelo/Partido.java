package modelo;

public class Partido { // Clase que representa un partido de fútbol, con los equipos locales y visitantes, y los goles de cada equipo

    // Constantes
    public static final int[] COLUMNAS = { 20, 20, 1 }; // Constante que define el ancho de las columnas de la tabla de la quiniela, para formatear la salida en pantalla

    // Atributos
    String equipoLocal;
    String equipoVisitante;
    int golesLocal;
    int golesVisitante;

    // Constructores
    public Partido(String equipoLocal, String equipoVisitante) { // Constructor que recibe los nombres de los equipos locales (equipo[0] y visitantes, desde MODELO y los asigna a los atributos correspondientes
        this.equipoLocal = equipoLocal; // Asigna el nombre del equipo local, recibido como parámetro desde el constructor (que es llamado desde el modelo o desde la vista) al atributo equipoLocal de la clase Partido
        this.equipoVisitante = equipoVisitante; // Asigna el nombre del equipo visitante, recibido como parámetro desde el constructor (que es llamado desde el modelo o desde la vista) al atributo equipoVisitante de la clase Partido
    }

    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante) { // Constructor que recibe los nombres de los equipos locales y visitantes, y los goles de cada equipo, y los asigna a los atributos correspondientes
        this.equipoLocal = equipoLocal; // Asigna el nombre del equipo local, recibido como parámetro desde el constructor (que es llamado desde el modelo o desde la vista) al atributo equipoLocal de la clase Partido
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    // Obtener resultado como string
    public String getResultado() {
        if (golesLocal > golesVisitante) {
            return "1";
        } else if (golesLocal < golesVisitante) {
            return "2";
        } else {
            return "X";
        }
    }

    public String asRowTable() { // Método que devuelve una cadena formateada como una fila de tabla, con los nombres de los equipos y el resultado del partido, para mostrar en la quiniela
        return String.format("| %-" + COLUMNAS[0] + "s | %-" + COLUMNAS[1] + "s| %-" + COLUMNAS[2] + "s |", equipoLocal, equipoVisitante, getResultado());
    }

    // Getters y setters
    public String getEquipoLocal() { // Getter que devuelve el nombre del equipo local, para que la VISTA pueda acceder a él y mostrarlo en pantalla
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) { // Setter que asigna el nombre del equipo local, para que la VISTA pueda modificarlo si es necesario
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() { // Getter que devuelve el nombre del equipo visitante, para que la VISTA pueda acceder a él y mostrarlo en pantalla
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) { // Setter que asigna el nombre del equipo visitante, para que la VISTA pueda modificarlo si es necesario
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() { // Getter que devuelve los goles del equipo local, para que la VISTA pueda acceder a ellos y mostrarlos en pantalla
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) { // Setter que asigna los goles del equipo local, para que el CONTROLADOR pueda modificarlos si es necesario, llamando al método desde la vista cuando el usuario introduce los goles
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() { // Getter que devuelve los goles del equipo visitante, para que la VISTA pueda acceder a ellos y mostrarlos en pantalla
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) { // Setter que asigna los goles del equipo visitante, para que el CONTROLADOR pueda modificarlos si es necesario, llamando al método desde la vista cuando el usuario introduce los goles
        this.golesVisitante = golesVisitante;
    }
}