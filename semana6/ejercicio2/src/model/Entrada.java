package model;

import java.util.ArrayList;
import java.util.List;

public class Refugio {
    public static final double Precio_Inicial = 3.0;
    private static final int Ancho_Interior = 101;
    private static final String Separador = "|" + "-".repeat(Ancho_Interior) + "|";

    //Ahora los animales se guardan en un ArrayList en vez de en un array
    private final List<Animal> animales;
    private final int capacidad;
    private double precioKg;

    public Refugio(int capacidad) {
        if(capacidad <= 0) {
            throw new IllegalArgumentException("Tiene que ser mayor que 0");
        }
        this.animales = new ArrayList<>();
        this.capacidad = capacidad;
        this.precioKg = Precio_Inicial;
    }

    //Getters y setters
    public int getCapacidad() {
        return capacidad;
    }
    public int getNumAnimales() {
        return animales.size();
    }
    public double getPrecioKg() {
        return precioKg;
    }
    public void setPrecioKg(double precioKg) {
        if(precioKg <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
        this.precioKg = precioKg;
    }

    public boolean estaLleno() {
        return animales.size() == capacidad;
    }
    public boolean estaVacio() {
        return animales.isEmpty();
    }

    //CREATE: devuelve false si no hay sitio o si ya existe un animal con ese nombre
    public boolean annadirAnimal(Animal animal) {
        if(estaLleno() || buscarAnimal(animal.getNombre()) != null) {
            return false;
        }
        animales.add(animal);
        return true;
    }

    //READ: busca un animal por su nombre (null si no existe)
    public Animal buscarAnimal(String nombre) {
        for(Animal animal : animales) {
            if(animal.getNombre().equalsIgnoreCase(nombre)) {
                return animal;
            }
        }
        return null;
    }

    //UPDATE: cambia los datos de un animal existente (el nombre es su identificador y no cambia)
    public boolean actualizarAnimal(String nombre, String especie, double peso, double consumoDiario, Cuidador cuidador) {
        Animal animal = buscarAnimal(nombre);
        if(animal == null) {
            return false;
        }
        animal.setEspecie(especie);
        animal.setPeso(peso);
        animal.setConsumoDiario(consumoDiario);
        animal.setCuidador(cuidador);
        return true;
    }

    //DELETE: el ArrayList recoloca solo el resto de animales
    public boolean eliminarAnimal(String nombre) {
        Animal animal = buscarAnimal(nombre);
        if(animal == null) {
            return false;
        }
        animales.remove(animal);
        return true;
    }

    //metodo para calcular el coste total

    public double calcularCosteTotal() {
        double total = 0;
        for(Animal animal : animales) {
            total += animal.calcularCosteDiario(precioKg);
        }
        return total;
    }

    public double calcularPesoMedio() {
        if(animales.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for(Animal animal : animales) {
            suma += animal.getPeso();
        }
        return suma / animales.size();
    }

    //Para imprimir la tabla como pone en el pdf

    public void mostrarInformacion() {
        System.out.println(Separador);
        System.out.printf("|%s|%n", centrar("ANIMALES DEL REFUGIO"));
        System.out.println(Separador);
        imprimirCabecera();
        System.out.println(Separador);

        for(Animal animal : animales) {
            imprimirFila(animal);
        }
        System.out.println(Separador);
        System.out.printf("|%-" + Ancho_Interior + "s|%n",
                String.format(" Coste diario total de alimentación: %.2f EUR", calcularCosteTotal()));
        System.out.printf("|%-" + Ancho_Interior + "s|%n",
                String.format(" Peso medio de los animales: %.2f kg", calcularPesoMedio()));
        System.out.println(Separador);
    }

    //Muestra la tabla con un unico animal (para la busqueda)
    public void mostrarAnimal(Animal animal) {
        System.out.println(Separador);
        imprimirCabecera();
        System.out.println(Separador);
        imprimirFila(animal);
        System.out.println(Separador);
    }

    private void imprimirCabecera() {
        System.out.printf("| %-12s | %-10s | %-22s | %-9s | %9s | %10s | %9s |%n",
                "Nombre", "Especie", "Cuidador", "Formación", "Peso (kg)", "Consumo kg", "Coste EUR");
    }

    private void imprimirFila(Animal animal) {
        Cuidador cuidador = animal.getCuidador();
        System.out.printf("| %-12s | %-10s | %-22s | %-9s | %9.2f | %10.2f | %9.2f |%n",
                recortar(animal.getNombre(), 12),
                recortar(animal.getEspecie(), 10),
                recortar(cuidador.getNombreCompleto(), 22),
                cuidador.tieneFormacion() ? "Sí" : "No",
                animal.getPeso(),
                animal.getConsumoDiario(),
                animal.calcularCosteDiario(precioKg));
    }

    private static String centrar(String texto) {
        int espacios = Ancho_Interior - texto.length();
        int izquierda = espacios / 2;
        int derecha = espacios - izquierda;
        return " ".repeat(izquierda) + texto + " ".repeat(derecha);
    }
    private static String recortar(String texto, int maximo) {
        return texto.length() <= maximo ? texto : texto.substring(0, maximo - 1) + "…";
    }
}
