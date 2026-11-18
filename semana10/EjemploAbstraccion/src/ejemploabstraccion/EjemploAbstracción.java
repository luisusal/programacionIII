package ejemploabstraccion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 *  Este proyecto busca poner ejemplos sobre el concepto de Abstracción en Java.
 * 
 *  Fundamentalmente se consigue con dos enfoques:
 * 
 *  - clases abstractas, métodos abstractos
 *  - interface
 * 
 * 
 * 
 * @author Loza
 */
public class EjemploAbstracción {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ejemploAbstraccionHerenciaYClaseAbstracta();
        
        System.out.println("#-------------------------------------------------#");
        
        ejemploAbstraccionInterfaces();
    }
    
    
    public static void ejemploAbstraccionHerenciaYClaseAbstracta(){
        
        // Abstracción y polimorfismo con la clase abstracta Vehiculo
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Ferrari(500, "123ABC"));
        vehiculos.add(new Tesla(350, "456DEF"));
        vehiculos.add(new CuatroLatas(60, "789GHI"));


        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.imprimirNumeroSerie();
            vehiculo.moverse(); // Polimorfismo: se invoca el método moverse() correspondiente a cada subclase
        }
        
        
        System.out.println("#-------------------------------------------------#");

        // Abstracción y polimorfismo con la clase concreta Coche
        List<Coche> coches = new ArrayList<>();
        coches.add(new Ferrari(500, "123ABC"));
        coches.add(new Tesla(350, "456DEF"));
        coches.add(new CuatroLatas(60, "789GHI"));
        
        
        for (Coche coche : coches) { 
            // Importantisimo, se puede recorrer una lista de Coche, ya que todos los elementos son de tipo Coche
            // Para el programa solo existen Coches, no Ferraris, Teslas o CuatroLatas
            coche.imprimirNumeroSerie();
            coche.moverse(); // Polimorfismo: se invoca el método moverse() correspondiente a cada subclase
            coche.pitar();   // Este método es común a todos los coches, pero no necesariamente a todos los vehículos
        }
        
        
    }

    private static void ejemploAbstraccionInterfaces() {
        
        // Polimorfismo con interface
        // reciclamos todos los objetos que implementan la interfaz reciclable.
        
        // Se rellena una lista de Reciclable
        // Como vemos, no todos los objetos son de la misma jerarquí de herencia
        // aquí se ve la flexibilidad de las interface
        
        List<Reciclable> reciclables = new ArrayList<>();
        reciclables.add(new Ferrari(500, "123ABC"));
        reciclables.add(new Tesla(350, "456DEF"));
        reciclables.add(new CuatroLatas(60, "789GHI"));
        reciclables.add(new BotellaPlastico());
        
        // Se recicla cada objeto, cada uno de su forma, como lo implemente
        // Así este código no depende de objetos concretos sino de reciclables.
        for (Reciclable objetoReciclable : reciclables) {
            objetoReciclable.reciclar();
        }
    }
    
}
