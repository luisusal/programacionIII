import java.util.Scanner;
import fruteria.Producto;
import com.coti.tools.Esdia;

/**
 * 
 * Una frutería precisa de un programa que calcule la factura de la compra de
 * sus clientes.
 * La frutería sólo trabaja con dos productos: peras y manzanas cuyo valor varía
 * cada día.
 * El programa pedirá por consola al tendero el precio/kg sin IVA de las peras y
 * las manzanas cada mañana al comienzo de su jornada laboral.
 * El IVA ya está prefijado en el programa. Posteriormente el programa permite
 * introducir la cantidad de cada tipo de fruta que desea comprar
 * cada cliente y calculará el precio total de la factura para dicho cliente,
 * mostrando en forma de tabla el tipo de fruta, cantidad en Kg,
 * precio con IVA por Kg, precio total por fruta. Haz que el programa se ejecute
 * continuamente hasta que el tendero decida salir,
 * incrementando el número de cliente mostrado en el ticket mostrado por
 * pantalla.
 * 
 * |---------------------------------------------------|
 * | Cliente | 1 |
 * |---------------------------------------------------|
 * | Manzanas | 2 kg | precio Kg con IVA 1,99 | 3,98 € |
 * | Peras | 3 kg | precio Kg con IVA 2,25 | 6,75 € |
 * |---------------------------------------------------|
 * | Total con IVA 10,73 € |
 * |---------------------------------------------------|
 * 
 * Tip: Realizar este ejercicio empleando Arrays de objetos y empleando una
 * clase que abstraiga todo lo común que tienen los ítems que vende el tendero:
 * e.g. Producto.
 * 
 */
public class Exercise3 {

    public static void main(String[] args) {

        // Troubleshooting Encoding Windows CMD:
        // https://github.com/microsoft/vscode-java-debug/blob/main/Troubleshooting_encoding.md
        // Windows: Enable region UTF-8.
        System.out.println("Moneda: €");


        // Introduzca el número de productos diferentes que vende la frutería
        int numeroProductos = Esdia.readInt("Introduzca el número de productos diferentes que vende la frutería: ");

        // Crear un array de productos
        Producto[] productos = new Producto[numeroProductos];

        // Pedir al tendero el precio por kg de cada producto
        for (int i = 0; i < numeroProductos; i++) {
            String nombreProducto = Esdia.readString("Introduzca el nombre del producto: ");
            double precioSinIVA = Esdia.readDouble("Introduzca el precio por kg sin IVA del producto: ");
            productos[i] = new Producto(nombreProducto, precioSinIVA);
        }

        // Comenzar a atender clientes

        int numeroCliente = 1;
        boolean continuar = true;

        while (continuar) {

            // Pedir cuanto lleva de cada producto
            for (int i = 0; i < productos.length; i++) {
                double cantidad = Esdia.readDouble("Introduzca la cantidad de " + productos[i].getNombre() + " en kg: ");
                productos[i].setCantidad(cantidad);
            }

            // Mostrar ticket
            mostrarTicket(numeroCliente, productos);

            numeroCliente++;
            continuar = Esdia.siOno("¿Desea continuar? (s/n): ");
        }
    }

    private static void mostrarTicket(int numeroCliente, Producto[] productos) {

        // Versión sin adaptarse al contenido de los productos
        // Supongamos que damos para cada columna una ancho fijo de:
        // | 20 | 20 | 50 | 20 |
        // 110 espacio contenido mas 5 barras + 8 espacios padding = 123 total ancho

        // Linea superior 120 - y 2 +
        String lineaSeparacion = "+" + "-".repeat(120) + "+";
        // Linea cliente    123 menos: 3 | y 5 espacios padding y 8 de la palabra "cliente" (123-16) -> 107 -> 7 para el numero 100 espacios
        String lineaCliente = "| Cliente %-100s | %7s |";

        // MOstrar ticket

        // Cabecera
        System.out.println(lineaSeparacion);
        System.out.println(String.format(lineaCliente, "", numeroCliente));
        System.out.println(lineaSeparacion);

        // Lineas de productos
        for (Producto producto : productos) {
            // Esto se puede llevar a la clase producto
            System.out.println(String.format("| %-20.20s | %-10.2f %10.10s | %35.35s %10.2f | %20.2f € |", 
            producto.getNombre(), 
            producto.getCantidad(), "kg",
            "precio Kg con IVA", producto.getPrecioConIVA(),
            producto.getPrecioTotal()));
        }

        // Linea de total
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecioTotalConIVA();
        }
        System.out.println(lineaSeparacion);

        System.out.println(String.format("| %-93s | %20s € |", "Total con IVA", total));
        System.out.println(lineaSeparacion);

    }

}
