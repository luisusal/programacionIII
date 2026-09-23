package es.usal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el año actual: ");
        int anioActual = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Introduce el año de nacimiento: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el nombre: ");
        String nombre = scanner.nextLine();

        int edad = anioActual-anio;

        System.out.println("La edad es " + edad);
        
        System.out.println("El nombre es " + nombre);

        scanner.close();

    }
}
