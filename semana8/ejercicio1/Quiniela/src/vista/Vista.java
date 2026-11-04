package vista;

import com.coti.tools.Esdia;
import controlador.Controlador;

public class Vista {
    // Referencia al controlador para poder delegar las acciones del menú.
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        // Establece la relación entre vista y controlador.
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        // Variable para guardar la opción elegida por el usuario.
        int opcion;
        do {
            // Muestra el menú principal en pantalla.
            System.out.println("\n=== QUINIELA ===");
            System.out.println("1) Pedir nombres de equipos");
            System.out.println("2) Pedir resultados");
            System.out.println("3) Mostrar quiniela");
            System.out.println("4) Salir");
            // Lee la opción introducida por el usuario.
            opcion = leerOpcion();

            // Ejecuta la acción según la opción que haya elegido.
            switch (opcion) {
                case 1:
                    controlador.pedirNombresEquipos();
                    break;
                case 2:
                    controlador.pedirResultados();
                    break;
                case 3:
                    controlador.mostrarQuiniela();
                    break;
                case 4:
                    mostrarMensaje("Hasta luego.");
                    break;
                default:
                    mostrarMensaje("Opcion no valida.");
                    break;
            }
            // Repetimos el menú hasta que el usuario elija salir.
        } while (opcion != 4);
    }

    public int leerOpcion() {
        // Lee la opción del menú con la librería Esdia.
        return Esdia.readInt("Introduce una opcion: ");
    }

    public String leerEquipoLocal() {
        // Pide y devuelve el nombre del equipo local.
        return Esdia.readString("Equipo local: ");
    }

    public String leerEquipoVisitante() {
        // Pide y devuelve el nombre del equipo visitante.
        return Esdia.readString("Equipo visitante: ");
    }

    public int leerGolesLocal() {
        // Pide y devuelve los goles del equipo local.
        return Esdia.readInt("Goles del equipo local: ");
    }

    public int leerGolesVisitante() {
        // Pide y devuelve los goles del equipo visitante.
        return Esdia.readInt("Goles del equipo visitante: ");
    }

    public void mostrarMensaje(String mensaje) {
        // Muestra cualquier texto de información al usuario.
        System.out.println(mensaje);
    }

    public void mostrarQuiniela(String tabla) {
        // Muestra la tabla final de la quiniela.
        System.out.println(tabla);
    }
}
