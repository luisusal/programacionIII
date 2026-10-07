
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        if(args.length!= 2) {
            System.err.println("El numero de parametros no es valido");
        }
        try{
        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[1]);

        System.out.println("La suma es " + (num1+num2));
        }catch(Exception e){
            System.err.println("Los numeros no estan en un formato valido");
        }

        //System.out.println(Arrays.toString(args));
    }
}
