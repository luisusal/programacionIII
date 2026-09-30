package model;

public class Person{
    // Atributos aquí arriba
    private String nombre;
    private float peso;
    private int altura;

        // Constructores

    public Person() {
        nombre = "Desconocido";
        peso = 70;
        altura = 170;
    }

    public Person(String nombre, float peso, int altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public Person(String nombre) {
        this();
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
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


   public float calcularIMC(Person person) {
        float alturaEnMetros = altura / 100; // Convertir altura a metros
        return peso / (alturaEnMetros * alturaEnMetros); 
    }

    public String toString() {
        return "Nombre: " + nombre + ", Peso: " + peso + ", Altura: " + altura;
    }


    
}