import vista.Vista;
import modelo.Modelo;
import controlador.Controlador;

public class App {
    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);

        vista.setControlador(controlador);
        controlador.init();
    }
}