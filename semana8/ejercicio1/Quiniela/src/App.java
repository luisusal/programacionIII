import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class App {
    public static void main(String[] args) {
        // 1. Creamos la vista, que mostrará el menú al usuario.
        Vista vista = new Vista();
        // 2. Creamos el modelo, que guardará los partidos en memoria.
        Modelo modelo = new Modelo();
        // 3. Creamos el controlador y le pasamos la vista y el modelo.
        Controlador controlador = new Controlador(vista, modelo);
        // 4. Iniciamos la aplicación mostrando el menú principal.
        controlador.iniciar();
    }
}