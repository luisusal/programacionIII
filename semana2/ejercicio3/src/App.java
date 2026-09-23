import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int num = Esdia.readInt("Introduce un numero: ");

        if(num<0){
            System.err.println("El numero introducido es menor que cero");
            return;
        }

        float suma=0;
        for(int i=0;i<num;i++){
            suma+=Esdia.readFloat("Introduce un numero decimal");
        }

        float media = suma/num;
        System.out.println("La medida es " + medida);
    }
}
