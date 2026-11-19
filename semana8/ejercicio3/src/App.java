import controller.PersonaController;
import model.PersonaModel;
import view.PersonaView;

public class App {
    public static void main(String[] args) {
        PersonaModel modelo = new PersonaModel();
        PersonaView vista = new PersonaView();
        PersonaController controlador = new PersonaController(modelo, vista);
        controlador.iniciar();
    }
}