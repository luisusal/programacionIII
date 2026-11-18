package ejemploherencia;

/**
 * 
 * Esta sería la clase padre también llamada base o superclase.
 * 
 * Se presentan algunos conceptos interesentes sobre la herencia:
 * 
 * - final y su efecto sobre la herencia
 * - private y su efecto sobre la herencia
 * 
 * Dirigirse a las clases hija para ver esto mismo.
 * 
 *
 * @author Loza
 */
// La clase base Coche
class Coche {
    private int cuentaKm; // Atributo privado que NO se hereda (en el sentido de que no son accesibles desde las subclases)
    // Sin embargo, aunque no se puede acceder directamente a los atributos privados, 
    // sí se heredan como parte de la estructura del objeto, y puedes interactuar con ellos
    //  a través de métodos públicos o protegidos (getters y setters) definidos en la clase padre.
    private final int caballos; // Final indica que el valor no puede cambiar
    private final String numeroChasis; // Atributo final que será asignado en el constructor

    protected int velocidadMax;

    public Coche(int caballos, String numeroChasis) {
        this.caballos = caballos;
        this.numeroChasis = numeroChasis; // Asignación final de numeroChasis
    }

    public void acelerar() {
        System.out.println("El coche acelera a una velocidad de " + velocidadMax + " km/h");
    }

    public void frenar() {
        System.out.println("El coche frena hasta detenerse.");
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

    public String getNumeroChasis() {
        return numeroChasis;
    }

    // Setter para el atributo privado cuentaKm
    public void setCuentaKm(int cuentaKm) {
        this.cuentaKm = cuentaKm;
    }
}