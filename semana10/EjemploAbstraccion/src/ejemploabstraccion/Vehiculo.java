package ejemploabstraccion;

/**
 *
 * @author Loza
 */
abstract class Vehiculo {
    protected String numeroSerie;

    public Vehiculo(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void imprimirNumeroSerie() {
        System.out.println("Número de serie: " + numeroSerie);
    }
    
    public abstract void moverse(); // Método abstracto que debe ser implementado por las subclases

}