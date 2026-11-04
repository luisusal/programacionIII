/*Se debe realizar un programa que solicite por consola el número de alumnos que tiene un curso. Posteriormente se
solicitarán las notas de 3 exámenes (2 parciales y uno final) por cada alumno. El programa deberá mostrar las
calificaciones de cada alumno en formato de tabla y la nota final (suponiendo un valor de 10%, 10% y 80%
respectivamente). Por último se deberá obtener la media por cada examen y de la nota final de la clase. Utiliza
Arrays de objetos para su resolución. */

import java.util.Scanner;

public class App {
    static class Alumno {
        double parcial1;
        double parcial2;
        double examenFinal;

        double notaFinal() {
            return parcial1 * 0.10 + parcial2 * 0.10 + examenFinal * 0.80;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos del curso: ");
        int numeroAlumnos = leerNumeroValido(sc, "alumnos");

        Alumno[] alumnos = new Alumno[numeroAlumnos];

        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = new Alumno();
            System.out.println("\nAlumno " + (i + 1));

            System.out.print("Nota del parcial 1: ");
            alumnos[i].parcial1 = leerNota(sc, "parcial 1");

            System.out.print("Nota del parcial 2: ");
            alumnos[i].parcial2 = leerNota(sc, "parcial 2");

            System.out.print("Nota del examen final: ");
            alumnos[i].examenFinal = leerNota(sc, "examen final");
        }

        System.out.println("\n\nTABLA DE CALIFICACIONES");
        System.out.printf("%-8s | %-10s | %-10s | %-10s | %-12s%n",
                "Alumno", "Parcial1", "Parcial2", "Final", "NotaFinal");
        System.out.println("--------------------------------------------------------------");

        double sumaParcial1 = 0;
        double sumaParcial2 = 0;
        double sumaFinal = 0;
        double sumaNotaFinal = 0;

        for (int i = 0; i < alumnos.length; i++) {
            double notaFinalAlumno = alumnos[i].notaFinal();

            System.out.printf("%-8d | %-10.2f | %-10.2f | %-10.2f | %-12.2f%n",
                    i + 1,
                    alumnos[i].parcial1,
                    alumnos[i].parcial2,
                    alumnos[i].examenFinal,
                    notaFinalAlumno);

            sumaParcial1 += alumnos[i].parcial1;
            sumaParcial2 += alumnos[i].parcial2;
            sumaFinal += alumnos[i].examenFinal;
            sumaNotaFinal += notaFinalAlumno;
        }

        double mediaParcial1 = sumaParcial1 / alumnos.length;
        double mediaParcial2 = sumaParcial2 / alumnos.length;
        double mediaFinal = sumaFinal / alumnos.length;
        double mediaNotaFinal = sumaNotaFinal / alumnos.length;

        System.out.println("\nMEDIAS DE LA CLASE");
        System.out.printf("Media parcial 1: %.2f%n", mediaParcial1);
        System.out.printf("Media parcial 2: %.2f%n", mediaParcial2);
        System.out.printf("Media examen final: %.2f%n", mediaFinal);
        System.out.printf("Media nota final: %.2f%n", mediaNotaFinal);

        sc.close();
    }

    private static int leerNumeroValido(Scanner sc, String nombre) {
        int numero;
        do {
            while (!sc.hasNextInt()) {
                System.out.print("Valor incorrecto. Introduce un número válido de " + nombre + ": ");
                sc.next();
            }
            numero = sc.nextInt();
            if (numero <= 0) {
                System.out.print("Debe ser mayor que 0. Introduce otro número de " + nombre + ": ");
            }
        } while (numero <= 0);
        return numero;
    }

    private static double leerNota(Scanner sc, String nombre) {
        double nota;
        do {
            while (!sc.hasNextDouble()) {
                System.out.print("Nota incorrecta. Introduce un valor numérico entre 0 y 10 para " + nombre + ": ");
                sc.next();
            }
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.print("La nota debe estar entre 0 y 10. Introduce otra para " + nombre + ": ");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }
}
