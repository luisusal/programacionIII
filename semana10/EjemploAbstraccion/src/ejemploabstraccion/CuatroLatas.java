package ejemploabstraccion;

/**
 *
 * @author Loza
 */
class CuatroLatas extends Coche implements Reciclable {
    public CuatroLatas(int caballos, String numeroChasis) {
        super(caballos, numeroChasis);
        this.velocidadMax = 80; // Los coches antiguos suelen ser más lentos
    }

    // Sobrescritura del método acelerar
    @Override
    public void acelerar() {
        super.acelerar(); // Llama a la versión del método acelerar de la clase Coche
        System.out.println("El CuatroLatas acelera con la gracia de su época!");
    }

    // Sobrescritura del método frenar
    @Override
    public void frenar() {
        super.frenar(); // Llama a la versión del método frenar de la clase Coche
        System.out.println("El CuatroLatas requiere más tiempo para frenar debido a sus frenos antiguos.");
    }
    
    
    // OJO NO SOBRESCRIBE EL MOVERSE, POR LO QUE SE APLICARÁ EL DE LA CLASE PADRE
    // EN ESTE CASO COCHE

    @Override
    public void reciclar() {
        System.out.println("Reciclando el cuatrolatas. Se destina a un museo.");
    }
    
}