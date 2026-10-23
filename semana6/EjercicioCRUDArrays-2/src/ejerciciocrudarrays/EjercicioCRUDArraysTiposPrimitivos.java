package ejerciciocrudarrays;

// Importa todos lo métodos estáticos de Esdia
import static es.usal.progiii.tools.Esdia.*;
import java.util.Arrays;

/**
 *
 * 
 * Ejercicio CRUD Arrays. (Con tipos primitivos)
 * 
 * Ejercicio para ejemplificar altas, bajas, modificaciones y listados
 * empleando Arrays y la clase utilidad Arrays.
 * 
 * Se podrá comprobar que rápidamente la gestión de un simple CRUD se complica
 * demasiado frente al mismo ejercicio realizado con Colecciones como ArrayList
 * 
 * Por lo general se emplearán colecciones para este propósito.
 * 
 * No se sigue ningún patrón arquitectónico en este ejercicio.
 * 
 * Se realiza todo en la misma clase para mayor claridad, sin embargo
 * esto se aplica a los Arrays que residan en cualquier otro objeto del programa.
 * 
 * 
 * @author Loza
 */
public class EjercicioCRUDArraysTiposPrimitivos {
    
    private static final int MAX_SIZE = 5;
    private static int[] numeros = new int[MAX_SIZE];
    
    // Creamos dos atributos que nos van a permitir conocer la cantidad
    // de números y nombres que tenemos en las colecciones, ya que length
    // lo unico que nos indica es el espacio disponible máximo para albergar
    // numeros o nombres
    private static int numCount = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar número");
            System.out.println("2. Eliminar número");
            System.out.println("3. Modificar número");
            System.out.println("4. Listar números");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1: agregarNumero(); break;
                case 2: eliminarNumero(); break;
                case 3: modificarNumero(); break;
                case 4: listarNumeros(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        
    }
    
    /***
     * 
     * Pide un número por consola y agrega un número al array de números.
     * 
     */
    public static void agregarNumero() {
        if (numCount < MAX_SIZE) {
            int num = readInt("Ingrese el número:");
            numeros[numCount++] = num;
        } else {
            System.out.println("Array de números está lleno.");
        }
    }
    
    /**
     * 
     * Modifica un número pedido por consola si existe por otro.
     * 
     */
    public static void modificarNumero() {
        
        int num = readInt("Ingrese el número a modificar: ");
        boolean encontrado = false;
        for (int i = 0; i < numCount; i++) {
            if (numeros[i] == num) {
                int nuevoNum = readInt("Ingrese el nuevo número: ");
                numeros[i] = nuevoNum;
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Número no encontrado.");
        }
    }

    /***
     * 
     * 
     * Elimina un número solicitado por consola si existe.
     * Desplaza todos los valores posteriores a dicho valor para mantener
     * los valores que han sido introducidos (no valores con 0 por defecto por
     * ser tipos primitivos)
     * 
     * 
     */
    public static void eliminarNumero() {
        int num = readInt("Ingrese el número a eliminar:");
        boolean encontrado = false;
        // Recorremos hasta los que tengamos almacenados (el resto no serán válidos)
        for (int i = 0; i < numCount; i++) {
            // En caso de encontrarlo, movemos todos los posteriores una posición
            // a la izquierda
            if (numeros[i] == num) {
                encontrado = true;
                for (int j = i; j < numCount - 1; j++) {
                    numeros[j] = numeros[j + 1];
                }
                // Decrementamos la cantidad de números que tenemos almacenados
                numCount--;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Número no encontrado.");
        }
    }

    
    /**
     * 
     * Lista los números introducidos en el array, no los que tengan valores
     * por defecto.
     * 
     */
    public static void listarNumeros() {
        
        // Con la clase de utilidad Arrays podemos hacer una copia
        // de una parte del array que nos interese con el método estático
        // copyOf. En este caso solo copiaremos hasta los números que hayamos
        // introducido (aunque realmente haya un array más grande).
        int[] temp = Arrays.copyOf(numeros, numCount);
        
        // De nuevo, con otro método estático de Arrays, esta vez sort
        // ordenamos el array copiado
        Arrays.sort(temp);
        // Por último el método de utilidad toString de Arrays nos permite
        // obtener un array como un string que poder mostrar por pantalla
        System.out.println("Números: " + Arrays.toString(temp));
    }

    
}
