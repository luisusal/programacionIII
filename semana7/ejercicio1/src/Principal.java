
public class Principal {
    public static void main(String[] args) {
        // Crear el modelo: gestiona los datos y la lógica de negocio
       Modelo modelo = new Modelo();
        
        // Crear la vista: maneja la entrada y salida por consola
       Vista vista = new Vista();
        
        // Crear el controlador: coordina la interacción entre modelo y vista
      Controlador controlador = new Controlador(modelo, vista);
        
        // Iniciar la aplicación
        controlador.run();
    }
}