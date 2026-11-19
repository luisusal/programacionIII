import java.util.Scanner;
import model.Animal;
import model.Cuidador;
import model.Refugio;
import model.Entrada;


public class App {
    private static final int Opcion_Salir = 8;
    private static final String Separador_menu = "|--------------------------|";

    private final Entrada entrada;
    private Refugio refugio;
    private double precioKg = Refugio.Precio_Inicial;

    public App(Entrada entrada) {
        this.entrada = entrada;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new App(new Entrada(scanner)).ejecutar();
        }
    }
    private void ejecutar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = entrada.leerEnteroMinMax("Seleccione una opcion del 1 al 8",1,8);
            procesarOpcion(opcion);
        } while(opcion != Opcion_Salir);
    }
    private void mostrarMenu() {
        System.out.println();
        System.out.println(Separador_menu);
        System.out.printf("|%-51s|%n", "                GESTIÓN DEL REFUGIO");
        System.out.println(Separador_menu);
        System.out.printf("| %-49s |%n", "1) Crear un nuevo registro de animales");
        System.out.printf("| %-49s |%n", "2) Configurar el precio del alimento por kg");
        System.out.printf("| %-49s |%n", "3) Añadir un nuevo animal al refugio");
        System.out.printf("| %-49s |%n", "4) Mostrar información de los animales");
        System.out.printf("| %-49s |%n", "5) Buscar un animal por su nombre");
        System.out.printf("| %-49s |%n", "6) Modificar un animal");
        System.out.printf("| %-49s |%n", "7) Eliminar un animal");
        System.out.printf("| %-49s |%n", "8) Salir (se borrará toda la información)");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearRegistro();
                break;
            case 2:
                configurarPrecio();
                break;
            case 3:
                annadirAnimal();
                break;
            case 4:
                mostrarInformacion();
                break;
            case 5:
                buscarAnimal();
                break;
            case 6:
                modificarAnimal();
                break;
            case 7:
                eliminarAnimal();
                break;
            default:
                System.out.println("Fin.");
        }
    }

    private void crearRegistro() {
        int capacidad = entrada.leerEnteroPositivo("Capacidad( mayor que 0): ");
        refugio = new Refugio(capacidad);
        refugio.setPrecioKg(precioKg);
        System.out.printf("Registro creado con capacidad para %d animales.%n", capacidad);
    }

    private void configurarPrecio() {
        precioKg = entrada.leerDecimalPositivo("Precio del alimento por kg: ");
        if(refugio != null) {
            refugio.setPrecioKg(precioKg);
        }
        System.out.printf("Precio actualizado: %.2f EUR/kg.%n ", precioKg);
    }

    //CREATE
    private void annadirAnimal() {
        if(!hayRegistro()) {
            return;
        }
        if(refugio.estaLleno()) {
            System.out.println("El refugio esta lleno.");
            return;
        }
        System.out.println("-- Datos del animal --");
        String nombre = entrada.NoTextoVacio("Nombre: ");
        if(refugio.buscarAnimal(nombre) != null) {
            System.out.println("Ya existe un animal con ese nombre.");
            return;
        }
        String especie = entrada.NoTextoVacio("Especie: ");
        double peso = entrada.leerDecimalPositivo("Peso (kg): ");
        double consumo = entrada.leerDecimalPositivo("Consumo diario de alimento (kg): ");
        Cuidador cuidador = pedirCuidador();
        Animal animal = new Animal(cuidador, nombre, especie, peso, consumo);

        if(refugio.annadirAnimal(animal)) {
            System.out.printf("Animal añadido (%d/%d).%n", refugio.getNumAnimales(), refugio.getCapacidad());
        } else {
            System.out.println("No se ha podido añadir el animal, el refugio esta completo");
        }
    }

    //READ (todos)
    private void mostrarInformacion() {
        if(!hayRegistro()) {
            return;
        }
        if(refugio.estaVacio()) {
            System.out.println("El registro esta vacio");
            return;
        }
        refugio.mostrarInformacion();
    }

    //READ (uno)
    private void buscarAnimal() {
        if(!hayRegistro()) {
            return;
        }
        if(refugio.estaVacio()) {
            System.out.println("El registro esta vacio");
            return;
        }
        String nombre = entrada.NoTextoVacio("Nombre del animal a buscar: ");
        Animal animal = refugio.buscarAnimal(nombre);
        if(animal == null) {
            System.out.println("No existe ningun animal con ese nombre.");
        } else {
            refugio.mostrarAnimal(animal);
        }
    }

    //UPDATE
    private void modificarAnimal() {
        if(!hayRegistro()) {
            return;
        }
        if(refugio.estaVacio()) {
            System.out.println("El registro esta vacio");
            return;
        }
        String nombre = entrada.NoTextoVacio("Nombre del animal a modificar: ");
        if(refugio.buscarAnimal(nombre) == null) {
            System.out.println("No existe ningun animal con ese nombre.");
            return;
        }
        System.out.println("-- Nuevos datos del animal (el nombre no cambia) --");
        String especie = entrada.NoTextoVacio("Especie: ");
        double peso = entrada.leerDecimalPositivo("Peso (kg): ");
        double consumo = entrada.leerDecimalPositivo("Consumo diario de alimento (kg): ");
        Cuidador cuidador = pedirCuidador();

        refugio.actualizarAnimal(nombre, especie, peso, consumo, cuidador);
        System.out.println("Animal modificado.");
    }

    //DELETE
    private void eliminarAnimal() {
        if(!hayRegistro()) {
            return;
        }
        if(refugio.estaVacio()) {
            System.out.println("El registro esta vacio");
            return;
        }
        String nombre = entrada.NoTextoVacio("Nombre del animal a eliminar: ");
        if(refugio.eliminarAnimal(nombre)) {
            System.out.printf("Animal eliminado (%d/%d).%n", refugio.getNumAnimales(), refugio.getCapacidad());
        } else {
            System.out.println("No existe ningun animal con ese nombre.");
        }
    }

    //Pide los datos del cuidador (se usa al añadir y al modificar)
    private Cuidador pedirCuidador() {
        System.out.println("-- Datos del cuidador --");
        String nombreCuidador = entrada.NoTextoVacio("Nombre: ");
        String apellidos = entrada.NoTextoVacio("Apellidos: ");
        int respuesta = entrada.leerEnteroMinMax("¿Tiene formación en cuidado animal? (1 = sí, 0 = no): ", 0, 1);
        boolean formacion = (respuesta == 1);
        return new Cuidador(nombreCuidador, apellidos, formacion);
    }

    private boolean hayRegistro() {
        if(refugio == null) {
            System.out.println("Primero debes crear un registro mediante la opcion 1");
            return false;
        }
        return true;
    }
}
