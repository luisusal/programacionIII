package model1;

import model1.Clase1;
import model1.Clase2; //  es visible dentro de model1

public class App2 {
    public static void main(String[] args) throws Exception {
        Clase1 clase1 = new Clase1();

        //clase1.atributo1=123;
        //clase1.atributo2=123; //El atributo2 es viible dentro del paquete "model1"
        //clase1.atributo3=123; //El atributo3 es viible dentro del paquete "model1"
        //clase1.atributo4=123; //El atributo4 es visibl edentro  del paquete "model1"

        //Clase2 Clase2 = new Clase2(); //la clase2 no es visible fuera del paquete "model1"
    }
}
