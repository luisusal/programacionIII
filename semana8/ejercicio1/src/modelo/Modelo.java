package modelo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Modelo {
   //final int NUMERO_PARTIDOS = 15; // no se utiliza, ya que se ha cambiado a ArrayList para poder añadir partidos dinámicamente
   //private Partido[] partidos; // 
    ArrayList<Partido> partidos; // Lista de partidos, se utiliza ArrayList para poder añadir partidos dinámicamente


   public Modelo(){ // Constructor del modelo, inicializa la lista de partidos. vacio para que se pueda cargar desde archivo sin la necesidad de pasarle partidos por parámetro, y sin lanzar excepciones
    //partidos = new Partido[NUMERO_PARTIDOS];
    partidos = new ArrayList<>(); // Inicializa la lista de partidos como un ArrayList vacío
   }

   public int cargarPartidosDesdeArchivos(Path rutaArchivo){ // CONTROLADOR Método que carga los partidos desde un archivo, recibe como parámetro la ruta del archivo y devuelve el número de partidos cargados o -1 si se produce un error
    try{
            List<String> lineas = Files.readAllLines(rutaArchivo,StandardCharsets.UTF_8); // Lee todas las líneas del archivo y las almacena en una lista de strings

            for(String linea : lineas){ // Recorre cada línea del archivo, que contiene los nombres de los equipos separados por un guion
                String[] equipos = linea.split("-"); // Separa los nombres de los equipos utilizando el guion como delimitador y los almacena en un array de strings
                partidos.add(new Partido(equipos[0],equipos[1])); // Crea un nuevo objeto Partido con los nombres de los equipos y lo añade a la lista de partidos
            } // ejemplo de línea: "Real Madrid-Barcelona" se separa en equipos[0] = "Real Madrid" y equipos[1] = "Barcelona"
            return partidos.size(); // Devuelve el número de partidos cargados, que es el tamaño de la lista de partidos

    }catch(IOException e){ // Captura la excepción IOException que se produce si hay un error al leer el archivo
        return -1; 
    }

   }

   public ArrayList<Partido> getPartidos(){ // CONTROLADOR Método que devuelve la lista de partidos, se utiliza para que la vista pueda acceder a los partidos y mostrarlos en pantalla
    return partidos; // Devuelve la lista de partidos
   }

}
