package controller;

import java.util.ArrayList;
import model.DatosDeAlumno;
import model.ListaDeClaseModel;
import view.ListaDeClaseView;

public class ListaDeClaseController {

    private ListaDeClaseModel modelo;
    private ListaDeClaseView vista;

    public ListaDeClaseController(ListaDeClaseModel modelo, ListaDeClaseView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void iniciar() {
        vista.mostrarMenu();
    }

    public int volverACrearLista() {
        return modelo.generarListaAleatoria(ListaDeClaseModel.NUM_ALUMNOS_INICIAL);
    }

    public ArrayList<DatosDeAlumno> obtenerAlumnos() {
        return modelo.getAlumnos();
    }

    public int exportarDatosPersonalesCsv(String nombreArchivo) {
        return modelo.exportarDatosPersonalesCsv(nombreArchivo);
    }

    public int exportarDireccionesCsv(String nombreArchivo) {
        return modelo.exportarDireccionesCsv(nombreArchivo);
    }
}