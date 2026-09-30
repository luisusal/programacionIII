import es.usal.progiii.tools.Esdia;
import model.Person;

public class App{
   public static void main(String[] args) throws Exception{

      // Crear un objeto de la clase Person

      Person persona1 = new Person();


      Person personTmp = new Person("Pepe", 80, 180);

      persona1.setNombre(Esdia.readString("Introduce un nombre: "));
      persona1.setPeso(Esdia.readFloat( "Introduce un peso: "));
      persona1.setAltura(Esdia.readInt( "Introduce una altura: "));

        System.out.println(persona1.toString());
      System.out.println("El imc de persona1 es: " + persona1.calcularIMC());

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

        System.out.println(personaMayPeso.getNombre() + " " + personaMayPeso.getPeso() + " " + personaMayPeso.getAltura());

      //calculo del IMC
      float imc1 = persona1.calcularIMC(persona1);
      float imc2 = persona2.calcularIMC(persona2);
      float imc3 = persona3.calcularIMC(persona3);   

       


   }
}