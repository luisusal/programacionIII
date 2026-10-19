
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        if(args.length!= 2) {
            System.err.println("El numero de parametros no es valido"); 
        }
        try{ // se intenta convertir los argumentos a numeros flotantes, try es para capturar errores en caso de que los argumentos no sean numeros
        float num1 = Float.parseFloat(args[0]); // se convierte el primer argumento a un numero flotante
        float num2 = Float.parseFloat(args[1]); // se convierte el segundo argumento a un numero flotante

        System.out.println("La suma es " + (num1+num2));
        }catch(Exception e){ // si ocurre un error al convertir los argumentos a numeros flotantes, se imprime un mensaje de error
            System.err.println("Los numeros no estan en un formato valido");
        }

        //System.out.println(Arrays.toString(args));
    }
}
