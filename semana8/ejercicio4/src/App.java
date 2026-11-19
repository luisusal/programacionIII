import controller.ListaDeClaseController;
import model.ListaDeClaseModel;
import view.ListaDeClaseView;

public class App {
    public static void main(String[] args) {
        ListaDeClaseModel modelo = new ListaDeClaseModel();
        ListaDeClaseView vista = new ListaDeClaseView();
        ListaDeClaseController controlador = new ListaDeClaseController(modelo, vista);
        controlador.iniciar();
    }
}