import com.coti.tools.Esdia;
import quiniela.Partido;
import quiniela.Quiniela;

/**
 * Clase que resuelve el ejercicio de mostrar los partidos del pleno al 15,
 * pedir los resultados y mostrar finalmente la quiniela.
 * 
 * Utilizar POO para su resolución creando clases que modelen el problema.
 * 
 */

public class Exercise5 {
    public static void main(String[] args) {

        // Crear la quiniela
        // Creamos los partidos
        Quiniela quiniela = new Quiniela();
        Partido[] partidos = quiniela.getPartidos(); // Partidos de la quiniela (ojo que los estamos editando directamente)

        // Pedir partidos con Esdia al usuario
        for (int i = 0; i < partidos.length;i++){

            // Mostrar qué partido se está añadiendo
            System.out.println("\n--- PARTIDO " + (i + 1) + " ---");

            // Pedir datos del partido
            String equipoLocal = Esdia.readString("Introduce el equipo local: ");
            String equipoVisitante = Esdia.readString("Introduce el equipo visitante: ");
            int golesLocal = Esdia.readInt("Introduce los goles del equipo local: ");
            int golesVisitante = Esdia.readInt("Introduce los goles del equipo visitante: ");

            // Crear el partido
            Partido partido = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante);

            // Añadir el partido a la quiniela
            partidos[i] = partido;

        }

        // Mostrar la quiniela
        // Cuando veamos MVC veremos por qué no es buena idea que la clase Quiniela imprima por
        // pantalla
        System.out.println(quiniela.obtenerTablaQuiniela());

    }
}