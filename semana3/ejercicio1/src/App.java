import es.usal.progiii.tools.Esdia; // Importar la clase Esdia para poder leer datos desde la consola
import model.Person; // Importar la clase Person para poder crear objetos de tipo Person

public class App{ // Clase principal del programa
   public static void main(String[] args) throws Exception{ // Método principal del programa

      // Crear un objeto de la clase Person

      Person persona1 = new Person(); // Se crea un objeto de la clase Person con el constructor por defecto


      Person personTmp = new Person("Pepe", 80, 180);  // Se crea un objeto de la clase Person con el constructor que recibe nombre, peso y altura

      persona1.setNombre(Esdia.readString("Introduce un nombre: ")); // Se pide al usuario que introduzca un nombre y se asigna al objeto persona1
      persona1.setPeso(Esdia.readFloat( "Introduce un peso: ")); // Se pide al usuario que introduzca un peso y se asigna al objeto persona1
      persona1.setAltura(Esdia.readInt( "Introduce una altura: ")); // Se pide al usuario que introduzca una altura y se asigna al objeto persona1

        System.out.println(persona1.toString()); // Se imprime por consola la información del objeto persona1 utilizando el método toString() de la clase Person
      System.out.println("El imc de persona1 es: " + persona1.calcularIMC());// Se imprime por consola la información del objeto persona1 utilizando el método toString() de la clase Person

        Person persona2 = new Person();

      persona2.setNombre(Esdia.readString( "Introduce un nombre: ")); 
      persona2.setPeso(Esdia.readFloat( "Introduce un peso: "));
      persona2.setAltura(Esdia.readInt("Introduce una altura: "));

      System.out.println("El imc de persona2 es: " + persona2.calcularIMC());


        Person persona3 = new Person();

      persona3.setNombre(Esdia.readString( "Introduce un nombre: "));
      persona3.setPeso(Esdia.readFloat( "Introduce un peso: "));
      persona3.setAltura(Esdia.readInt( "Introduce una altura: "));

      System.out.println("El imc de persona3 es: " + persona3.calcularIMC());

      Person personaMasAlta = persona1;
      if (personaMasAlta.getAltura() < persona2.getAltura()) {
         personaMasAlta = persona2;
      }
      if (personaMasAlta.getAltura() < persona3.getAltura()) {
         personaMasAlta = persona3;
      }

        System.out.println(personaMasAlta.getNombre() + " " + personaMasAlta.getPeso() + " " + personaMasAlta.getAltura());

      Person personaMayPeso = persona1;
      if (personaMayPeso.getPeso() < persona2.getPeso()) {
         personaMayPeso = persona2;
      }
      if (personaMayPeso.getPeso() < persona3.getPeso()) {
         personaMayPeso = persona3;
      }

        System.out.println(personaMayPeso.getNombre() + " " + personaMayPeso.getPeso() + " " + personaMayPeso.getAltura()); // Imprime por consola el nombre, peso y altura de la persona con mayor peso

      //calculo del IMC
      float imc1 = persona1.calcularIMC(persona1); 
      float imc2 = persona2.calcularIMC(persona2);
      float imc3 = persona3.calcularIMC(persona3);   

       


   }
}