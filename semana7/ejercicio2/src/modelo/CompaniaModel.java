package semana7.ejercicio2.src.modelo;

package modelo;

public class CompaniaModel {
    public static final int NUM_ALMACENES = 5;
    public static final int NUM_PRODUCTOS = 2;

    private int[][] ventas;
    private double[] precios;
    private double[] ingresosPorAlmacen;
    private double ingresosTotales;

    private boolean ventasLeidas;
    private boolean preciosLeidos;
    private boolean ingresosCalculados;

    public CompaniaModel() {
        this.ventas = new int[NUM_ALMACENES][NUM_PRODUCTOS];
        this.precios = new double[NUM_PRODUCTOS];
        this.ingresosPorAlmacen = new double[NUM_ALMACENES];
        this.ingresosTotales = 0.0;
        this.ventasLeidas = false;
        this.preciosLeidos = false;
        this.ingresosCalculados = false;
    }

    public void setVentas(int[][] ventas) {
        for (int i = 0; i < NUM_ALMACENES; i++) {
            for (int j = 0; j < NUM_PRODUCTOS; j++) {
                this.ventas[i][j] = ventas[i][j];
            }
        }
        this.ventasLeidas = true;
        // Si se modifican las ventas, cualquier cálculo previo queda obsoleto
        this.ingresosCalculados = false;
    }

    public void setPrecios(double[] precios) {
        for (int j = 0; j < NUM_PRODUCTOS; j++) {
            this.precios[j] = precios[j];
        }
        this.preciosLeidos = true;
        // Si se modifican los precios, cualquier cálculo previo queda obsoleto
        this.ingresosCalculados = false;
    }

    public boolean puedeCalcularIngresos() {
        return ventasLeidas && preciosLeidos;
    }

    public void calcularIngresosTotales() {
        if (!puedeCalcularIngresos()) {
            return;
        }

        double total = 0.0;
        for (int i = 0; i < NUM_ALMACENES; i++) {
            double subtotalAlmacen = 0.0;
            for (int j = 0; j < NUM_PRODUCTOS; j++) {
                subtotalAlmacen += ventas[i][j] * precios[j];
            }
            this.ingresosPorAlmacen[i] = subtotalAlmacen;
            total += subtotalAlmacen;
        }

        this.ingresosTotales = total;
        this.ingresosCalculados = true;
    }

    public int[][] getVentas() {
        return ventas;
    }

    public double[] getPrecios() {
        return precios;
    }

    public double[] getIngresosPorAlmacen() {
        return ingresosPorAlmacen;
    }

    public double getIngresosTotales() {
        return ingresosTotales;
    }

    public boolean isVentasLeidas() {
        return ventasLeidas;
    }

    public boolean isPreciosLeidos() {
        return preciosLeidos;
    }

    public boolean isIngresosCalculados() {
        return ingresosCalculados;
    }

    public int getNumAlmacenes() {
        return NUM_ALMACENES;
    }

    public int getNumProductos() {
        return NUM_PRODUCTOS;
    }
}