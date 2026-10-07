import model.Fruta;
import es.usal.progriii.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        Fruta[] frutas = new Fruta[2];
        frutas[0] = new Fruta("Pera", 
            es.usal.progiii.tools.Esdia.readFloat("Introduce el precio de las peras", 0 , 10));
        frutas[1] = new Fruta("Manzanas", 
         es.usal.progiii.tools.Esdia.readFloat("Introduce el precio de las manzanas", 0 , 10));

         do{
            float[] jpesos = new float[2]; //Array auxiliar para pesos;

            for(int i=0;i<frutas.length; i++)
            {
                pesos[i]=Esdia.readFloat("Introduce el peso de " + frutas[i].getNombre());
            }

            for(int i=0; i<frutas.lenght, i++)
            {
                System.out.printf("%10s | %4.2f | %Precio kg con IVA | %4.f | %6.2f | ",
                    frutas[i].getNombre(),
                    pesos,
                    frutas[i].precioConIva(),
                    frutas[i].precio(pesos[i])
                
                );
                importeTotal += frutas[i].precio(pesos[i]);

            }

            System.out.println("Importe total:" + importeTotal);


         }while(es.usal.progiii.tools.Esdia.siOno("¿Quieres atender a un nuevo cliente?"));

    }
}
