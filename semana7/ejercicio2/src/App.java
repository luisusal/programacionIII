import controlador.CompaniaControlador;
import modelo.CompaniaModel;
import vista.CompaniaVista;

public class App {
    public static void main(String[] args) throws Exception{
        CompaniaModel modelo = new CompaniaModel();
        CompaniaVista vista = new CompaniaVista();
        CompaniaControlador controlador = new CompaniaControlador(modelo, vista);

        vista.setControlador(controlador);
        vista.mostrarMenuPrincipal();
    }
}