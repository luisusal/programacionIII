package view;

import controller.PersonaController;
import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;
import model.Persona;

public class PersonaView {

    private PersonaController controlador;

    public void setControlador(PersonaController controlador) {
        this.controlador = controlador;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println(error);
    }

    public void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN DE PERSONAS ---");
            System.out.println("1) Importar personas desde fichero TSV (Escritorio)");
            System.out.println("2) Mostrar personas en forma tabular");
            System.out.println("3) Salir del programa");

            int opcion = Esdia.readInt("Seleccione una opción: ", 1, 3);

            switch (opcion) {
                case 1:
                    importarFicheroTsv();
                    break;
                case 2:
                    mostrarTablaPersonas();
                    break;
                case 3:
                    boolean confirmar = Esdia.siOno("¿Está seguro de que desea salir del programa?");
                    if (confirmar) {
                        salir = true;
                        System.out.println("Saliendo del programa...");
                    } else {
                        System.out.println("Salida cancelada.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void importarFicheroTsv() {
        String nombreArchivo = Esdia.readString("Introduzca el nombre del fichero TSV en el Escritorio: ");
        int resultado = controlador.importarDesdeTsv(nombreArchivo);
        if (resultado < 0) {
            System.err.println("Error al importar el fichero '" + nombreArchivo + "'. Compruebe que existe en el Escritorio.");
        } else {
            System.out.println("Se han importado " + resultado + " personas desde '" + nombreArchivo + "'.");
        }
    }

    private void mostrarTablaPersonas() {
        ArrayList<Persona> lista = controlador.obtenerPersonas();
        if (lista.isEmpty()) {
            System.out.println("No hay personas registradas para mostrar.");
            return;
        }
        String cabecera = Persona.tableHeader();
        String separador = "+" + "-".repeat(cabecera.length() - 2) + "+";
        System.out.println("\n" + separador);
        System.out.println(cabecera);
        System.out.println(separador);
        for (Persona p : lista) {
            System.out.println(p.asTableRow());
        }
        System.out.println(separador);
    }
}