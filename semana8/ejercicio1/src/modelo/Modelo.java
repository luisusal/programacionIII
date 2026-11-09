package modelo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Modelo {
   //final int NUMERO_PARTIDOS = 15;
   //private Partido[] partidos;
    ArrayList<Partido> partidos;


   public Modelo(){
    //partidos = new Partido[NUMERO_PARTIDOS];
    partidos = new ArrayList<>();
   }

   public int cargarPartidosDesdeArchivos(Path rutaArchivo){
    try{
            List<String> lineas = Files.readAllLines(rutaArchivo,StandardCharsets.UTF_8);

            for(String linea : lineas){
                String[] equipos = linea.split("-");
                partidos.add(new Partido(equipos[0],equipos[1]));
            }
            return partidos.size();

    }catch(IOException e){
        return -1;
    }

   }

   public ArrayList<Partido> getPartidos(){
    return partidos;
   }

}
