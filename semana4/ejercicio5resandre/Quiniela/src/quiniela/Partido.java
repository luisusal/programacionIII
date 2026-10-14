package quiniela;

public class Partido {


    // Constantes
    public static final int[] COLUMNAS = { 20, 20, 1 };

    // Atributos
    String equipoLocal;
    String equipoVisitante;
    int golesLocal;
    int golesVisitante;
    

    // Constructoress
    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    // Logica de negocio

    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    // Obtener resultado como string
    public String getResultado() {
        
        // Si local 1, visitante 2 empate X
        if (golesLocal > golesVisitante) {
            return "1";
        } else if (golesLocal < golesVisitante) {
            return "2";
        } else {
            return "X";
        }
    }


    /**
     * @return String Devuelve el estado del partido como una linea de tabla de acuerdo a las columnas establecidas
     */
    String asRowTable(){
        // Devuelve el estado del partido como una linea de tabla de acuerdo a las columnas establecidas
        return String.format("| %-" + COLUMNAS[0] + "s | %-" + COLUMNAS[1] + "s| %-" + COLUMNAS[2] + "s |", equipoLocal, equipoVisitante, getResultado());
    }


    // Getters y setters
    public String getEquipoLocal() {
        return equipoLocal;
    }


    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }


    public String getEquipoVisitante() {
        return equipoVisitante;
    }


    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }


    public int getGolesLocal() {
        return golesLocal;
    }


    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }


    public int getGolesVisitante() {
        return golesVisitante;
    }


    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
}
