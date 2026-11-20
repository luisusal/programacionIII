package quiniela;
import modelo.Partido;


/**
 * 
 * Clase que representa la quiniela , que contiene un array de partidos y métodos para obtener la tabla de la quiniela y para obtener y establecer los partidos.
 * 
 */
public class Quiniela {

    // Atributos
    final int NUMERO_PARTIDOS = 15; // Constante que define el número de partidos de la quiniela, se utiliza para validar que se han cargado correctamente los partidos desde el archivo y para inicializar el array de partidos    
    private Partido[] partidos; // Array de partidos, se utiliza para almacenar los partidos de la quiniela, se inicializa en el constructor y se valida que tenga el tamaño correcto al cargar los partidos desde el archivo

    // Constructores
    public Quiniela() {
        partidos = new Partido[NUMERO_PARTIDOS]; // Inicializa el array de partidos con el tamaño definido por la constante NUMERO_PARTIDOS, para que se puedan almacenar los partidos de la quiniela
    }

    public Quiniela(Partido[] partidos) { // Constructor que recibe un array de partidos como parámetro, se utiliza para inicializar la quiniela con los partidos cargados desde el archivo, y valida que el tamaño del array sea correcto

      
        if (partidos.length != NUMERO_PARTIDOS) { // Si el tamaño del array de partidos recibido como parámetro no es igual al tamaño definido por la constante NUMERO_PARTIDOS, se lanza una excepción IllegalArgumentException con un mensaje de error
            throw new IllegalArgumentException("El número de partidos no es correcto");
        } 
        this.partidos = partidos; // Asigna el array de partidos recibido como parámetro al atributo partidos de la clase Quiniela, para que se puedan almacenar los partidos de la quiniela
    }

    
    // Logica de negocio

    // Obtener tabla de la quiniela
    public String obtenerTablaQuiniela() { // Método que devuelve una cadena con la tabla de la quiniela, formateada como una tabla con los nombres de los equipos y el resultado del partido, para mostrar en la vista
        String tabla = "";

        // Cabecera de la tabla a partir de las columnas de la clase partido
        int toltalLength = Partido.COLUMNAS[0] + Partido.COLUMNAS[1] + Partido.COLUMNAS[2] + 10; // Calcula el ancho total de la tabla sumando el ancho de las columnas definidas en la clase Partido y añadiendo 10 para los separadores y los espacios, para que la tabla tenga un formato uniforme y se vea bien en pantalla. 
        String lineaCabecera = "|"+" ".repeat((toltalLength-10)/2)+"QUINIELA"+" ".repeat((toltalLength-10)/2)+"|"; // Crea la línea de cabecera de la tabla con el texto "QUINIELA" centrado, utilizando espacios en blanco para rellenar el resto de la línea, y añadiendo los separadores "|" al principio y al final, para que la tabla tenga un formato uniforme y se vea bien en pantalla.
        String lineaSeparacion = "+" + "-".repeat(toltalLength-3) + "+"; // Crea la línea de separación de la tabla con guiones "-", utilizando el ancho total de la tabla calculado anteriormente, y añadiendo los separadores "+" al principio y al final, para que la tabla tenga un formato uniforme y se vea bien en pantalla.
        tabla += lineaSeparacion + "\n";
        tabla += lineaCabecera + "\n";
        tabla += lineaSeparacion + "\n";

        // Lineas de partidos
        for (Partido partido : partidos) { //   Recorre el array de partidos y añade cada partido a la tabla utilizando el método asRowTable() de la clase Partido, que devuelve una cadena formateada como una fila de tabla con los nombres de los equipos y el resultado del partido, para mostrar en la quiniela
            tabla += partido.asRowTable() + "\n";
        }
        tabla += lineaSeparacion + "\n";
        return tabla;
    }

    // Getters y setters
    public int getNUMERO_PARTIDOS() { // Getter que devuelve el número de partidos de la quiniela, para que la vista pueda acceder a él y mostrarlo en pantalla
        return NUMERO_PARTIDOS;
    }

    public Partido[] getPartidos() { // Getter que devuelve el array de partidos de la quiniela, para que la vista pueda acceder a él y mostrarlo en pantalla
        return partidos;
    }

    public void setPartidos(Partido[] partidos) { // Setter que asigna el array de partidos de la quiniela, para que la vista pueda modificarlo si es necesario, y valida que el tamaño del array sea correcto
        this.partidos = partidos;
    }

}
