package ejemploabstraccion;

/**
 * 
 * Esta sería la clase padre también llamada clase base o superclase.
 * 
 * En este caso, esta clase hereda de una clase abstracta, implementando su método.
 * 
 * Ahora el numero de chasis lo tiene la clase padre no esta, ya que a nivel general
 * todo vehículo comparte esa información.
 *
 * @author Loza
 */
// La clase base Coche
class Coche extends Vehiculo {
    private int cuentaKm; // Atributo privado que NO se hereda (en el sentido de que no es accesible directamente en las subclases)
    private final int caballos; // Final indica que el valor no puede cambiar
    protected int velocidadMax;

    public Coche(int caballos, String numeroSerie) {
        super(numeroSerie);
        this.caballos = caballos;
    }

    public void acelerar() {
        System.out.println("El coche acelera a una velocidad de " + velocidadMax + " km/h");
    }

    public void frenar() {
        System.out.println("El coche frena hasta detenerse.");
    }
    
    @Override
    public void moverse() {
        System.out.println("El coche se mueve sobre ruedas.");
    }
    

    // Método final que no puede ser sobrescrito
    public final void pitar() {
        System.out.println("El coche pita");
    }

    // Getters para los atributos privados y final
    public int getCuentaKm() {
        return cuentaKm;
    }

    public int getCaballos() {
        return caballos;
    }

    // Setter para el atributo privado cuentaKm
    public void setCuentaKm(int cuentaKm) {
        this.cuentaKm = cuentaKm;
    }
}