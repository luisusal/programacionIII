package ejemploabstraccion;

/**
 * 
 * La subclase Ferrari ahora hereda con extends de la clase Coche y 
 * además implementa Reciclable.
 * 
 * Un Ferrari podra ser tratado como un Coche ya que implementa todo
 * lo necesario para ello. Ojo, no al revés, una instancia de coche no puede ser
 * tratado como un Ferrari, a no ser que sea un Ferrari.
 * 
 * También puede ser tratado como un Reciclable ya que implementa la interface
 * Reciclable.
 * 
 *
 * @author Loza
 */
class Ferrari extends Coche implements Reciclable {
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
    
    @Override
    public void moverse() {
        System.out.println("El Ferrari se mueve rápidamente con un motor ruidoso.");
    }

    @Override
    public void reciclar() {
        System.out.println("Reciclando un Ferrari");
    }
    
    
}