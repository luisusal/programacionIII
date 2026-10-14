package model1;

import model1.Clase1;
//import model1.Clase2; // no es visible fuera de model1

public class App {
    public static void main(String[] args) throws Exception {
        Clase1 clase1 = new Clase1();

        //clase1.atributo1=123;
        //clase1.atributo2=123; //El atributo2 no es viible fuera del paquete "model1"
        //clase1.atributo3=123; //El atributo3 no es viible fuera del paquete "model1"
        //clase1.atributo4=123; //El atributo4 no es visible fuera del paquete "model1"

        clase1.metodoPublico();
        //clase1.metodoSinModificar; // no es visible fuera de model1
        
        //Clase2 Clase2 = new Clase2(); //la clase2 no es visible fuera del paquete "model1"
    }
}
