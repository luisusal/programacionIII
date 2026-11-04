package model;

import java.util.Locale;

/**
 *
 * Clase POJO que utilizaremos de ejemplo en este proyecto.
 * 
 * Contiene métodos para obtener la instancia actual en diferen
 * 
 * @author Loza
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private float altura;
    
    private static final int[] columnSizes = {40,3,4};

    public Persona(String nombre, int edad, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    } 
   
    public static Persona getPersonFromDelimitedString(String delimitedString, String delimiter){
        
        // Con split es posible separar por el delimitador
        String[] chunks = delimitedString.split(delimiter);
        
        if(chunks.length != 3){
            // Esto proximamente será una excepción
            // Tomamos linea como inválida
            return null;
        }
        
        try{
            String nombre = chunks[0];
            int edad = Integer.parseInt(chunks[1]);
            float altura = Float.parseFloat(chunks[2]);
            Persona p = new Persona(nombre, edad, altura);
            return p;
        }
        catch(Exception e){
            // Tomamos linea como inválida
            return null;
        }
    }
    
    
    public static Persona getPersonFromColumnString(String columnString) {
        try {
            // La clave en este método es utilizar substring de String para
            // leer la parte que nos interese. Ojo que lee desde index hasta index-1
            
            // Del mismo modo trim sirve para eliminar los espacios en blanco al
            // principio y al final de la cadena.
            
            String[] campos = new String[columnSizes.length];
            
            int lastPoint = 0;
            for (int i = 0; i < columnSizes.length; i++) {
                campos[i] = columnString.substring(lastPoint, lastPoint+columnSizes[i]);
                lastPoint+= columnSizes[i];
            }
            
            String nombre = campos[0].trim();
            int edad = Integer.parseInt(campos[1].trim());
            float altura = Float.parseFloat(campos[2].trim());

            return new Persona(nombre, edad, altura);
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public String[] getInstanceAsArrayOfStrings(){
        
        String[] campos = new String[columnSizes.length];
        campos[0] = nombre;
        campos[1] = String.valueOf(edad);
        campos[2] = String.valueOf(altura);
        return campos;
    }
    
    public String getInstanceAsDelimitedString(String delimiter){
        // Cuidado con el Locale en el caso de numeros de coma flotante
        return String.format(Locale.ENGLISH,"%s"+delimiter+"%d"+delimiter+"%.2f", nombre,edad,altura);
    }
    
    public String getAsColumnString(){
        // Las columnas se establecen a partir de lo indicado en el atributo
        String formatString = "%"+columnSizes[0]+"s"+"%"+columnSizes[1]+"d"+"%"+columnSizes[2]+".2f";
        return String.format(Locale.ENGLISH,formatString, nombre,edad,altura);
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
