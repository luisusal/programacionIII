package model;   

public class Person  // Clase que representa a una persona con nombre, peso y altura
{
    // Atributos aquí arriba
    private String nombre;   
    private float peso;
    private int altura; 

        // Constructores

    public Person() { // Constructor por defecto que inicializa los atributos con valores predeterminados
        nombre = "Desconocido";  
        peso = 70;   
        altura = 170; 
    }

    public Person(String nombre, float peso, int altura) {   // Constructor que recibe nombre, peso y altura como parámetros y los asigna a los atributos de la clase
        this.nombre = nombre; // Asignar el valor del parámetro nombre al atributo nombre de la clase
        this.peso = peso; 
        this.altura = altura; 
    }

    public Person(String nombre) {   // Constructor que recibe nombre como parámetro y asigna un valor predeterminado a los atributos peso y altura
        this();  // Llamada al constructor por defecto para inicializar los atributos peso y altura con valores predeterminados
        this.nombre = nombre; 
    }


    public String getNombre() {  // Método que devuelve el valor del atributo nombre
        return this.nombre;  // Devuelve el valor del atributo nombre de la clase
    }

    public void setNombre(String nombre) {   // Método que asigna un valor al atributo nombre
        //Comprobaciones de que tenga x caracteres, que no sea null, etc
        this.nombre = nombre; 
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {  
        if (altura < 0) {
            altura=0;
        }
        if (altura > 200) {
            altura=200;
        }
        this.altura = altura;
    }


   public float calcularIMC(Person person)   { // Método que calcula el índice de masa corporal (IMC) de la persona
        float alturaEnMetros = altura / 100.0f; // Convertir altura a metros (division en coma flotante ya que altura es int)
        return peso / (alturaEnMetros * alturaEnMetros); 
    }

    public String toString() {   // Método que devuelve una representación en forma de cadena de texto de la persona, incluyendo su nombre, peso y altura
        return "Nombre: " + nombre + ", Peso: " + peso + ", Altura: " + altura;  
    }


    
}