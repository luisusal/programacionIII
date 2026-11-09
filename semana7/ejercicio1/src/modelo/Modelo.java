package modelo;

public class Modelo {
  // Atributos del modelo: datos del dominio
    private int number1;
    private int number2;
    private int sum;

    // Getter y Setter para el primer número
    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    // Getter y Setter para el segundo número
    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    // Getter para la suma
    public int getSum() {
        return sum;
    }

    // Lógica de negocio: calcular la suma y almacenarla
    public void calculateSum() {
        this.sum = this.number1 + this.number2;
    }
}
