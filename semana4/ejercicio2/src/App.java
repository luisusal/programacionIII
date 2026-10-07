import model.Person;
public class App {
    public static void main(String[] args) throws Exception {
        Person obj = Person.crearDesdeArray(args);

        System.out.printf("%15s | %10s | %10s | %10s \n",
            "Nombre", "Peso", "Altura", "Imc");
        System.out.printf("%15s | %6.2f | %4d |%6.2f", 

            obj.getNombre(),
            obj.getPeso(),
            obj.getAltura(),
            obj.calcularIMC()
    )
        
    }
}
