package controlador;

import javax.swing.text.View;

public class Controlador {
private Modelo modelo;
    private Vista vista;

    // Constructor: Conecta modelo y vista
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Controla el flujo del programa
    public void run() {
        boolean running = true;
        
        while (running) {
            vista.showMenu(); // Mostrar menú
            String option = vista.getUserOption(); // Leer opción del usuario
            
            switch (option.toLowerCase()) {
                case "1":
                    // Leer números
                    int number1 = vista.getNumberInput("Ingrese el primer número: ");
                    int number2 = vista.getNumberInput("Ingrese el segundo número: ");
                    modelo.setNumber1(number1);
                    modelo.setNumber2(number2);
                    vista.showMessage("Números leídos correctamente.");
                    break;
                case "2":
                    // Calcular suma
                    modelo.calculateSum();
                    vista.showMessage("Suma calculada correctamente.");
                    break;
                case "3":
                    // Mostrar resultado
                    int result = modelo.getSum();
                    vista.showResult(result);
                    break;
                case "q":
                    // Salir del programa
                    running = false;
                    vista.showMessage("Saliendo del programa. ¡Adiós!");
                    break;
                default:
                    // Opción no válida
                    vista.showMessage("Opción inválida, intente nuevamente.");
                    break;
            }
        }
    }

}
