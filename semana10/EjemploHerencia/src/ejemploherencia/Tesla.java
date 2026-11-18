package ejemploherencia;

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
class Tesla extends Coche {
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
    
    // ClickDerecho --> Source Actions --> Override Method

    @Override
    public void acelerar() {
        
        // OJO llamar al método de la clase padre es opcional.
        // En este caso estamos sobrescribiendo por completo el método
        // sin añadir lo que ya hacía el coche
        
        System.out.println("El Tesla acelera silenciosamente.");
    }
    
}