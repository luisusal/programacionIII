package ejerciciocrudcollections;

import ejerciciocrudcollections.controlador.Controlador;
import ejerciciocrudcollections.modelo.Modelo;
import ejerciciocrudcollections.vista.Vista;

public class EjercicioCRUDArrayList {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);

        vista.setControlador(controlador);
        controlador.run();
    }
}