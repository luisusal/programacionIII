package semana7.ejercicio2.src.controlador;

package controlador;

import modelo.CompaniaModel;
import vista.CompaniaVista;

public class CompaniaControlador {
    private CompaniaModel modelo;
    private CompaniaVista vista;

    public CompaniaControlador(CompaniaModel modelo, CompaniaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public int getNumAlmacenes() {
        return modelo.getNumAlmacenes();
    }

    public int getNumProductos() {
        return modelo.getNumProductos();
    }

    public void guardarVentas(int[][] ventas) {
        modelo.setVentas(ventas);
        vista.mostrarMensaje("Tabla de ventas guardada correctamente.");
    }

    public void guardarPrecios(double[] precios) {
        modelo.setPrecios(precios);
        vista.mostrarMensaje("Tabla de precios guardada correctamente.");
    }

    public void calcularIngresos() {
        if (!modelo.isVentasLeidas() && !modelo.isPreciosLeidos()) {
            vista.mostrarError("No es posible calcular los ingresos: primero debes introducir las ventas (1) y los precios (2).");
            return;
        }
        if (!modelo.isVentasLeidas()) {
            vista.mostrarError("No es posible calcular los ingresos: falta leer la tabla de ventas (opción 1).");
            return;
        }
        if (!modelo.isPreciosLeidos()) {
            vista.mostrarError("No es posible calcular los ingresos: falta leer la tabla de precios (opción 2).");
            return;
        }

        modelo.calcularIngresosTotales();
        vista.mostrarMensaje("Ingresos totales calculados correctamente.");
    }

    public void solicitarResultados() {
        if (!modelo.isVentasLeidas() || !modelo.isPreciosLeidos()) {
            vista.mostrarError("No es posible mostrar resultados: faltan datos de ventas o precios y realizar el cálculo.");
            return;
        }
        if (!modelo.isIngresosCalculados()) {
            vista.mostrarError("No es posible mostrar resultados: debes calcular los ingresos primero (opción 3).");
            return;
        }

        vista.mostrarResultados(
            modelo.getVentas(),
            modelo.getPrecios(),
            modelo.getIngresosPorAlmacen(),
            modelo.getIngresosTotales()
        );
    }
}