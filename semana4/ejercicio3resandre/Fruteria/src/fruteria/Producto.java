package fruteria;

public class Producto {
    private String nombre;
    private double precioSinIVA;
    private double cantidad;
    private final double IVA = 0.21;

    public Producto(String nombre, double precioSinIVA) {
        this.nombre = nombre;
        this.precioSinIVA = precioSinIVA;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPrecioConIVA() {
        final double IVA = 0.21;
        return precioSinIVA * (1 + IVA);
    }

    public double getPrecioTotal() {
        return getPrecioConIVA() * cantidad;
    }

    public double getPrecioTotalConIVA() {
        return (precioSinIVA * cantidad * (1 + IVA));
    }

}