import java.util.Arrays;

import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        String [] cadenasDeTexto = new String[5];

        for(int i=0;i<cadenasDeTexto.length;i++){
            cadenasDeTexto[i] = Esdia.readString("Introduce una cadena de texto: ");
        }
        
        Arrays.sort(cadenasDeTexto);
        System.out.println("Cadenas de texto ordenadas: ");

        for (String cadena : cadenasDeTexto){
            System.out.println(cadena);
        }
    }
}
