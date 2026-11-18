package ejemploherencia;

/**
 * 
 * La subclase Ferrari hereda con extends de la clase Coche.
 * 
 * Un Ferrari podra ser tratado como un Coche ya que implementa todo
 * lo necesario para ello. Ojo, no al revés, una instancia de coche no puede ser
 * tratado como un Ferrari, a no ser que sea un Ferrari.
 * 
 * Se ejemplifica:
 * 
 * - Uso de llamada al constructor padre super() en el constructor hijo.
 * 
 * - Uso de la keyword super para acceder a los métodos y atributos de la clase
 * padre.
 * 
 * - Etiqueta @Override para la sobrescritura de métodos. Como vemos se está
 * sobrescribiendo el método acelerar, sustituyendo el comportamiento del
 * método padre por una llamada al método padre y además poner otra frase.
 * 
 * - Métodos específicos de la subclase Ferrari: activarTurbo es un método que
 * solo Ferrari tiene.
 * 
 * - No es posible sobrescribir el método final de la clase padre. Si queremos
 * acceder a él debermos utilizar super.pitar(), pero no es posible modificar
 * su comportamiento.
 * 
 * - Es posible acceder directamente a la velocidad máxima desde la clase como vemos
 * en el constructor, sin embargo, es posible modificar los atributos de la clase padre
 * que son private
 * 
 * 
 * Nota: aquí se muestran ejemplos simplemente mostrando por pantalla cadenas
 * de caracteres para ejemplificar el comportamiento y mantener los ejemplos simples.
 * Veremos en otros ejemplo lo poderoso que es el mecanismo de herencia en POO 
 * para reutiliar código y realizar software de calidad.
 *
 * @author Loza
 */
class Ferrari extends Coche {
    public Ferrari(int caballos, String numeroChasis) {
        super(caballos, numeroChasis); // Llama al constructor de Coche con super
        this.velocidadMax = 300;
    }

    // Sobrescritura del método acelerar
    @Override
    public void acelerar() {
        super.acelerar(); // Llama a la versión del método acelerar de la clase Coche
        System.out.println("El Ferrari acelera con estilo!");
    }

    // Método específico de Ferrari
    public void activarTurbo() {
        System.out.println("Activando turbo del Ferrari!");
    }
    
}