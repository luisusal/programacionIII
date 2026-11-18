package ejemploabstraccion;

/**
 *
 * La subclase Tesla. 
 * 
 * Otro ejemplo de herencia.
 * 
 * - Se muestra como se puede sobrescribir un método de la clase padre
 * modificando completamente su implementación o llamando al método de la clase
 * padre (con super) y añadiendo comportamiento justo a continuación.
 * 
 * 
 * @author Loza
 */
class Tesla extends Coche implements Reciclable {
    public Tesla(int caballos, String numeroChasis) {
        super(caballos, numeroChasis);
        this.velocidadMax = 250;
    }

    // Sobrescritura del método frenar
    @Override
    public void frenar() {
        super.frenar(); // Llama a la versión del método frenar de la clase Coche
        System.out.println("El Tesla frena silenciosamente.");
    }
    
    // ClickDerecho --> InsertCode --> Override Method

    @Override
    public void acelerar() {
        
        // OJO llamar al método de la clase padre es opcional.
        // En este caso estamos sobrescribiendo por completo el método
        // sin añadir lo que ya hacía el coh
        
        System.out.println("El Tesla acelera silenciosamente.");
    }
    
    @Override
    public void moverse() {
        System.out.println("El Tesla se mueve silenciosamente usando electricidad.");
    }

    @Override
    public void reciclar() {
        System.out.println("Reciclando el Tesla, la batería para hacer powerwalls.");
    }
    
}