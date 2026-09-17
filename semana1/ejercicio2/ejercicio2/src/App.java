import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer numero");
        int num1 = sc.nextInt();

        System.out.println("Introduce el segundo numero");
        int num2 = sc.nextInt();
        int suma= num1+num2;
        System.out.println("La suma de " + num1 + " y " + num2 + " es " +suma);


        sc.close();


    }
}
