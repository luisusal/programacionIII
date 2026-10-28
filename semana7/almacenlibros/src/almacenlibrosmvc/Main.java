package semana7.almacenlibros.src.almacenlibrosmvc;

import almacenlibrosmvc.controller.AlmacenControlador;
import almacenlibrosmvc.model.AlmacenModel;
import almacenlibrosmvc.view.AlmacenVista;

/**
 *
 * AlmacenLibrosMVC.
 * 
 * Proyecto para ejemplificar la aplicación de MVC simple, sin herencia
 * ni interfaces.
 * 
 * El paquete model contendrá:
 * 
 * - La clase que representará el Modelo de la aplicación y gestionará
 * el estado de la aplicación, el acceso a datos y la lógica de negocio.
 * - Otras clases que representan entidades de información del modelo.
 * 
 * El paquete controller contendrá:
 * 
 * - La clase controlador, que hará de intermediario entre la vista y el modelo.
 * Será la encargada de orquestar las interaciones necesarias con modelo y 
 * vista.
 * 
 * El paqute view contendrá:
 * 
 * - La clase que actuará de vista encargada de toda la gestión de la UI, en
 * este caso por consola, gestionando la E/S. Toda la E/S debe ir aquí. Solo
 * se comunica con el controlador.
 * 
 * Se aplica un MVC en el que el controlador tiene una referencia a la vista
 * y al modelo. La vista tiene una referencia al controlador.
 * 
 * El MVC se construye en el main. Se instancian modelo y vista y se le proporcionan
 * al constructor del controlador. En dicho constructor se pasa una referencia
 * del controlador a la vista.
 * 
 * La inicialización la realiza el controlador con el método init. (Seguid el flujo 
 * del programa a partir de aquí).
 * 
 * 
 * @author Loza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AlmacenModel modelo = new AlmacenModel();
        AlmacenVista vista = new AlmacenVista();
        AlmacenControlador controlador = new AlmacenControlador(modelo, vista);
        controlador.init();
        
        // Esta inicialización es muy flexible, ya que permitirá cambiar
        // las piezas de nuestro MVC (modelo, vista y controlador) en el inicio.
        // Se volverá sobre este punto tras ver herencia.
        
    }
    
}
