package ejemploherencia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * En esta clase se ejemplifica la herencia, creando varios objetos de la clase
 * Coche (clase padre) que implementan distintos comportamientos pero tienen
 * atributos y métodos comunes.
 *
 *
 *
 * @author Loza
 */
public class EjemploHerencia {

    /**
     *
     * Ejecute este proyecto y fíjese en las salidas por consola tras cada
     * intrucción.
     *
     * Se presentan ejemplos de:
     *
     * - Herencia básica. - Polimorfismo conseguido con herencia. - Conversión
     * de tipos = downcasting y upcasting.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Comente y decomente estos métodos para probar los ejemplos.
        
        // Modifique el código si tiene dudas en cuanto a modificadores como
        // final, private, protected y como afectan a la herencia.
        
        
        //ejemploBasicoHerencia();
        ejemploDePolimorfismoConHerencia();
        //ejemploDeConversionDeTipos();
        

    }

    public static void ejemploBasicoHerencia() {

        Ferrari miFerrari = new Ferrari(500, "123ABC");
        miFerrari.acelerar();
        miFerrari.activarTurbo();
        System.out.println("Número de chasis del Ferrari: " + miFerrari.getNumeroChasis());

        System.out.println("#--------------------------------------------------#");

        Tesla miTesla = new Tesla(350, "456DEF");
        miTesla.frenar();
        System.out.println("Número de chasis del Tesla: " + miTesla.getNumeroChasis());

        System.out.println("#--------------------------------------------------#");

        // Creación de un objeto CuatroLatas
        CuatroLatas miCuatroLatas = new CuatroLatas(60, "789GHI");
        miCuatroLatas.acelerar();
        miCuatroLatas.frenar();
        System.out.println("Número de chasis del CuatroLatas: " + miCuatroLatas.getNumeroChasis());
    }

    public static void ejemploDePolimorfismoConHerencia() {

        System.out.println("#------------------POLIMORFISMO--------------------#");

        // Fíjese que podemos añadir estos objetos de clases hijas ya que todos son
        // Coche, se cumple el principio de sustitución de Liskov.
        List<Coche> coches = new ArrayList<>();
        coches.add(new Ferrari(500, "123ABC"));
        coches.add(new Tesla(350, "456DEF"));
        coches.add(new CuatroLatas(60, "789GHI"));

        // Demostración de polimorfismo
        // Todos los objetos son tratados como Coche, este código no sabe
        // si la instancia subyacente es un Ferrari, un Tesla etc.
        // LLama a acelerar y frenar de instancias Coche, cada uno hará lo que
        // implemente.
        for (Coche coche : coches) {
            coche.acelerar(); // Polimorfismo en acción: el método correcto es llamado dependiendo de la instancia real del objeto
            coche.frenar();
            System.out.println("Número de chasis: " + coche.getNumeroChasis());
            System.out.println();
        }

    }

    public static void ejemploDeConversionDeTipos() {

        System.out.println("#------------------UPCASTING Y DOWNCASTNG--------------------#");
        
        List<Coche> coches = new ArrayList<>();
        // Fíjese que podemos añadir estos objetos de clases hijas ya que todos son
        // Coche, se cumple el principio de sustitución de Liskov.
        coches.add(new Ferrari(500, "123ABC"));
        coches.add(new Tesla(350, "456DEF"));
        coches.add(new CuatroLatas(60, "789GHI"));

        // Ejemplo de upcasting y downcasting con control de tipos
        for (Coche coche : coches) {
            // instanceof se emplea para comprobar si una instancia es de un determinado tipo
            // Si no comprobaramos esto antes, en el downcasting podría producirse un
            // ClassCast Exception
            if (coche instanceof Ferrari) {
                // Downcasting para acceder a métodos específicos de Ferrari
                // Funcionará ya que antes hemos comprobado que se trata de un
                // objeto Ferrari
                System.out.println("¡Anda! ¡Un Ferrari!");
                Ferrari ferrari = (Ferrari) coche;
                // activarTurbo solo lo puede llamar un objeto Ferrari
                ferrari.activarTurbo();
            } else if (coche instanceof Tesla) {
                System.out.println("¡Anda! ¡Un Tesla!");
                // Downcasting no es necesario para Tesla, ya que no tiene métodos adicionales
                Tesla cuatroLatas = (Tesla) coche;
                
            } else if (coche instanceof CuatroLatas) {
                System.out.println("¡Anda! ¡Un Cuatrolatas!");
                // Downcasting para acceder a métodos específicos de CuatroLatas si los hubiera
                CuatroLatas cuatroLatas = (CuatroLatas) coche;
            }
            System.out.println();
        }

    }

}
