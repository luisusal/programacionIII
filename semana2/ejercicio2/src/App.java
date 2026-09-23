import java.io.Console;

public class App {
    public static void main(String[] args) throws Exception {
        Console console = System.console();

        if(console==null){
            System.err.println("No esta disponible console");
            return;
        }

        System.out.println("Introduce el año actual");
        String anioString = console.readLine();
        int anio = Integer.parseInt(anioString);

        System.out.println("Introduce el peso");
        float peso = Float.parseFloat(console.readLine());


        System.out.println("Año: " + anio + "peso" + peso);
    }
}
