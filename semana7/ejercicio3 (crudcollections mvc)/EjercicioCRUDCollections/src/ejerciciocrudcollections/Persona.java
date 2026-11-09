package ejerciciocrudcollections;

/**
 *
 * @author Loza
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private double altura;

    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getEstadoComoString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + "]";
    }

    
    // NOTA, LA SOBRESCRITURA DE METODOS @Override SE TRATARÁ UNA VEZ ABORDADA LA HERENCIA
    
    // En Java, determinar si dos objetos son iguales involucra la correcta 
    // implementación de dos métodos en particular: equals(Object obj) y hashCode(). 
    // Estos métodos son heredados de la clase Object, y es importante sobrescribirlos
    // adecuadamente para que funcionen juntos de manera coherente.
    // Es decir, si dos objetos son iguales con equals, deben tener el mismo hashCode
    
    // si dos objetos son considerados iguales mediante el método equals, deben tener el mismo código hash.
    // No seguir esta regla puede resultar en comportamientos erráticos cuando
    // uses objetos en colecciones basadas en hash (como HashSet, HashMap, etc.).
    
    // Nos ayudaremos del IDE para generar estos métodos.
    // Volveremos sobre esto tras ver herencia y sobrescritura de métodos.


    // Generado automáticamente con el IDE (Click Derecho > Source Action > Generate HashCode and Equals)
    // Hemos seleccionado solo name, para que se base unicamente en el nombre

    // Explicación hashCode:
    // El método hashCode() devuelve un número entero que representa el objeto.
    // Si dos objetos son iguales, entonces sus códigos hash también deben ser iguales.
    // Sin embargo, dos objetos con el mismo código hash no tienen por qué ser iguales.
    // Por lo tanto, el método hashCode() no es suficiente para determinar si dos objetos son iguales.
    // Pero es necesario para que los objetos se almacenen correctamente en las colecciones basadas en hash.
    // Por lo tanto, si sobrescribes el método equals(), también debes sobrescribir el método hashCode().
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode()); // Se obtiene un hashCode del atribuo nombre (clase String)
        return result;
    }
    // ¿Por qué se utiliza un número primo en el cálculo del hashCode?
    // Se utiliza un número primo, como 31 en este caso, porque ayuda a distribuir mejor los valores del hash,
    // reduciendo la probabilidad de colisiones al dispersar los posibles resultados en un espacio mayor de valores.
    // El uso de un número primo en el cálculo del hashCode es una técnica común para obtener una buena función de dispersión.
    // En este caso, aunque solo se utilice el atributo 'nombre', es buena práctica usar un número primo, ya que si se agregaran más
    // atributos en el futuro, el uso de un número primo sigue siendo recomendable para mantener una distribución uniforme.


    // Explicación equals:
    // El método equals() compara dos objetos para determinar si son iguales. En función de la implementación,
    // el método equals() puede comparar dos objetos por igualdad de referencia o por igualdad de contenido, segun definamos.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Son referencias a lo mismo entonces true
            return true;
        if (obj == null) // Si el objeto es nulo, entonces false
            return false;
        if (getClass() != obj.getClass()) // Si las clases no son iguales, entonces false
            return false;
        Persona other = (Persona) obj; // Hacemos un cast a Persona
        if (nombre == null) {
            if (other.nombre != null) // Si el nombre es nulo, y el otro no, entonces false
                return false;
        } else if (!nombre.equals(other.nombre))
            return false; // Si los nombres no son iguales, entonces false
        return true;  // Si no se cumple ninguna de las anteriores, entonces true (son iguales)
    }
    
    
}