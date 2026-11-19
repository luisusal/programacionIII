package controller;

import java.util.ArrayList;
import model.Factura;
import model.FacturasModel;
import view.FacturasView;

public class FacturasController {

    private FacturasModel modelo;
    private FacturasView vista;

    public FacturasController(FacturasModel modelo, FacturasView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void iniciar() {
        vista.mostrarMenu();
    }

    public int importarDesdeTsv(String nombreArchivo) {
        return modelo.importarDesdeTsv(nombreArchivo);
    }

    public void establecerImporteMinimo(double minimo) {
        modelo.setImporteMinimo(minimo);
    }

    public double obtenerImporteMinimo() {
        return modelo.getImporteMinimo();
    }

    public int calcularFacturasSuperioresAlMinimo() {
        return modelo.calcularFacturasSuperioresAlMinimo();
    }

    public ArrayList<Factura> obtenerFacturas() {
        return modelo.getFacturas();
    }

    public ArrayList<Factura> obtenerFacturasFiltradas() {
        return modelo.getFacturasFiltradas();
    }

    public int exportarACsv(String nombreArchivo) {
        return modelo.exportarACsv(nombreArchivo);
    }

    public int exportarAHtml(String nombreArchivo) {
        return modelo.exportarAHtml(nombreArchivo);
    }
}