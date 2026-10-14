package quiniela;


/**
 * 
 * Clase que representa la quiniela
 * 
 */
public class Quiniela {

    // Atributos
    final int NUMERO_PARTIDOS = 15;
    private Partido[] partidos;

    // Constructores
    public Quiniela() {
        partidos = new Partido[NUMERO_PARTIDOS];
    }

    public Quiniela(Partido[] partidos) {

        // Check if the number of matches is correct
        if (partidos.length != NUMERO_PARTIDOS) {
            throw new IllegalArgumentException("El número de partidos no es correcto");
        }
        this.partidos = partidos;
    }

    
    // Logica de negocio

    // Obtener tabla de la quiniela
    public String obtenerTablaQuiniela() {
        String tabla = "";

        // Cabecera de la tabla a partir de las columnas de la clase partido
        int toltalLength = Partido.COLUMNAS[0] + Partido.COLUMNAS[1] + Partido.COLUMNAS[2] + 10; // 4 barras y 6 espacios
        String lineaCabecera = "|"+" ".repeat((toltalLength-10)/2)+"QUINIELA"+" ".repeat((toltalLength-10)/2)+"|";
        String lineaSeparacion = "+" + "-".repeat(toltalLength-3) + "+";
        tabla += lineaSeparacion + "\n";
        tabla += lineaCabecera + "\n";
        tabla += lineaSeparacion + "\n";

        // Lineas de partidos
        for (Partido partido : partidos) {
            tabla += partido.asRowTable() + "\n";
        }
        tabla += lineaSeparacion + "\n";
        return tabla;
    }

    // Getters y setters
    public int getNUMERO_PARTIDOS() {
        return NUMERO_PARTIDOS;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }

}
