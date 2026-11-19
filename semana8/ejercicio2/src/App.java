import controller.FacturasController;
import model.FacturasModel;
import view.FacturasView;

public class App {
    public static void main(String[] args) {
        FacturasModel modelo = new FacturasModel();
        FacturasView vista = new FacturasView();
        FacturasController controlador = new FacturasController(modelo, vista);
        controlador.iniciar();
    }
}