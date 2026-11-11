package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

/**
 *
 * @author Loza
 */
public class Persona implements Serializable {
    
    
    private String nombre;
    private int edad;
    private float altura;
    
    // Constructor por defecto necesario para deserialización
    public Persona() {
        // necesitado por la biblioteca Jackson
    }

    public Persona(String nombre, int edad, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @JsonIgnore
    /***
     * 
     * Jackson obtiene los nombres de los getters y setters, dado que este método
     * lo hemos lamado como un get intentará buscar un atributo llamado 
     * PersonaAsString.
     * 
     * Para evitar esto podemos utilizar la anotación @JsonIgnore para que ignore
     * Jackson dicho método
     * 
     */
    public String getPersonaAsString(){
        return String.format("Nombre:%s, Edad:%d, Altura:%f", nombre,edad,altura);
    } 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
}
