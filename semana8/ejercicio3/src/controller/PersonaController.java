package controller;

import java.util.ArrayList;
import model.Persona;
import model.PersonaModel;
import view.PersonaView;

public class PersonaController {

    private PersonaModel modelo;
    private PersonaView vista;

    public PersonaController(PersonaModel modelo, PersonaView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void iniciar() {
        int cargadas = modelo.cargarDatosIniciales();
        if (cargadas < 0) {
            vista.mostrarError("No se pudo cargar datos.txt desde el Escritorio (no disponible o error de lectura).");
        } else if (cargadas == 0) {
            vista.mostrarMensaje("Archivo datos.txt encontrado, pero no se cargaron registros válidos (0 personas).");
        } else {
            vista.mostrarMensaje("Se han cargado " + cargadas + " personas desde datos.txt.");
        }
        vista.mostrarMenu();
    }

    public int importarDesdeTsv(String nombreArchivo) {
        return modelo.importarDesdeTsvEnEscritorio(nombreArchivo);
    }

    public ArrayList<Persona> obtenerPersonas() {
        return modelo.getPersonas();
    }
}