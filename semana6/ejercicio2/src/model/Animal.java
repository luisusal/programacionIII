package model;

public class Animal {
    private Cuidador cuidador;
    private String nombre;
    private String especie;
    private double peso;
    private double consumoDiario;


    public Animal(Cuidador cuidador, String nombre, String especie, double peso, double consumoDiario) {
        this.cuidador = cuidador;
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.consumoDiario = consumoDiario;
    }
    public Cuidador getCuidador() {
        return cuidador;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEspecie() {
        return especie;
    }
    public double getPeso() {
        return peso;
    }
    public double getConsumoDiario() {
        return consumoDiario;
    }

    //Setters para poder modificar un animal (el nombre no cambia: es lo que lo identifica)
    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setConsumoDiario(double consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public double calcularCosteDiario(double precioKg) {
        return consumoDiario * precioKg;
    }
}
