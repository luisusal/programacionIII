package model;

public class Person{
    // Atributos aquí arriba; private para que no se pueda acceder desde fuera de la clase, para que se pueda acceder a ellos solo mediante los métodos de la clase (getters y setters)
    private String nombre;
    private float peso;
    private int altura;

        // Constructores

    public Person() { // constructor por defecto, sin parámetros, asigna valores por defecto
        nombre = "Desconocido";
        peso = 70;
        altura = 170;
    }

    public Person(String nombre, float peso, int altura) { // constructor completo con parámetros, asigna los valores que se le pasan
        this.nombre = nombre; //usa la palabra reservada this para referirse a los atributos de la clase (this.nombre), para diferenciarlos de los parámetros del constructor (nombre)
        this.peso = peso;
        this.altura = altura;
    }

    public Person(String nombre) { // (delegacion de constructores) : constructor con un parámetro, asigna el valor que se le pasa y los demás valores por defecto
        this(); // llama al constructor por defecto [ Person() ]para asignar los valores por defecto [ peso = 70, altura = 170 ] a los atributos peso y altura
        this.nombre = nombre; // cambia únicamente el nombre que le has pasado. Así evitas repetir código y puedes reutilizar el constructor por defecto para asignar los valores por defecto a los atributos peso y altura.
    }
    



        // METODOS




    public static Person crearDesdeArray(String [] args){ // tiene que ser static porque cuando empieza el programa App.java no hay ningún objeto Person creado, al  ponerle static, puedes llamarlo directamente a traves de la clase Person.crearDesdeArray.(args) para que él mismo fabrique y te devuelva el objeto. Este método se va a llamar desde el main, que es static. Por eso no puede ser un método de instancia, sino de clase (static)
        if(args==null || args.length!=3 ){ // comprueba que el array exista, si no hay argumentos o no hay 3 argumentos, devuelve null y un mensaje de error
            System.err.println("El numero de argumentos no es valido");
            return null;
        }

        try{ // todo lo que entra por String args[] es cadena de texto, hay que convertirlo a float e int para poder crear el objeto Person. Si no se puede convertir, devuelve null y un mensaje de error
            String nombre = args[0]; //extrae el nombre del primer argumento
            float peso = Float.parseFloat(args[1]); //extrae el peso del segundo argumento y lo convierte a float
            int altura = Integer.parseInt(args[2]); //extrae la altura del tercer argumento y lo convierte a int

            //Crear y retirnar un obj de tipo persona
            return new Person(nombre, peso, altura);
        }catch(Exception e){ // si hay algún error al convertir los argumentos (ej, mete letras en peso), devuelve null y un mensaje de error
            System.err.println("No se han podido convertir los argumentos");
            return null;
        }
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

    //METODOS

   public float calcularIMC(Person person) { // método de instancia, no static, porque necesita un objeto para poder calcular el IMC. Se le pasa un objeto Person para calcular su IMC
        float peso = person.getPeso();
        float alturaEnMetros = person.getAltura() / 100; // Convertir altura a metros
        return peso / (alturaEnMetros * alturaEnMetros); 
    }

    public String toString() {
        return "Nombre: " + nombre + ", Peso: " + peso + ", Altura: " + altura;
    }


    
}