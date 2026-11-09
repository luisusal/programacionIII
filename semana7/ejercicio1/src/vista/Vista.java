package vista;

import java.util.Scanner;

public class Vista {
// Scanner para leer datos desde la consola
    private Scanner scanner = new Scanner(System.in);

    // Mostrar el menú principal
    public void showMenu() {
        System.out.println();
        System.out.println("Menú:");
        System.out.println("1. Leer los números");
        System.out.println("2. Calcular la suma");
        System.out.println("3. Mostrar el resultado");
        System.out.println("q. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Pedir un número al usuario
    public int getNumberInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Obtener la opción del usuario
    public String getUserOption() {
        return scanner.next();
    }

    // Mostrar el resultado de la suma
    public void showResult(int result) {
        System.out.println("El resultado de la suma es: " + result);
    }

    // Mostrar un mensaje genérico
    public void showMessage(String message) {
        System.out.println(message);
    }
}
