package semana7.almacenlibros.src.almacenlibrosmvc.controller;

import java.util.ArrayList;
import almacenlibrosmvc.model.AlmacenModel;
import almacenlibrosmvc.model.Libro;
import almacenlibrosmvc.view.AlmacenVista;

/**
 *
 * Controlador. Hace de intermediario entre vista y modelo.
 * Se le ha asignado también la responsabilidad de iniciar la aplicación
 * ya que es el que tiene acceso para interactuar con vista y modelo.
 * 
 * @author Loza
 */
public class AlmacenControlador {
    private AlmacenModel modelo;
    private AlmacenVista vista;

    public AlmacenControlador(AlmacenModel modelo, AlmacenVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        // Para proporcionar una referencia del controlador a la vista
        // le inyectamos con un seter una referencia a este objeto que se
        // está creando. Ahora la vista ya puede interactuar con el controlador
        this.vista.setControlador(this);
    }

    public void init() {
        
        // Se indica a la vista que muestre un mensaje de bienvenida
        vista.mostrarMensajeBienvenida();
        
        // Se indica a la vista que muestre el menú principal que tendrá
        // un bucle en el que estará continuamente el usuario
        vista.mostrarMenuPrincipal();
        
        // Cuando acabe el bucle se puede cerrar ordenadamente la aplicación
        // y mostrar un mensaje de salida
        vista.mostrarMensajeDespedida();
        
    }

    
    public String agregarLibro(Libro libro) {
        return modelo.agregarLibro(libro);
    }

    public String eliminarLibroPorTitulo(String titulo) {
        return modelo.eliminarLibroPorTitulo(titulo);
    }

    public void actualizarLibro(Libro libro) {
        modelo.actualizarLibro(libro);
    }
    
    public ArrayList<Libro> obtenerLibros() {
        return modelo.obtenerLibros();
    }

    public String obtenerVersionPrograma() {
        return modelo.getVersionPrograma();
    }

    public boolean comprobarExistenciaLibroPorTitulo(String titulo) {
        return modelo.comprobarExistenciaLibroPorTitulo(titulo);
    }

}
