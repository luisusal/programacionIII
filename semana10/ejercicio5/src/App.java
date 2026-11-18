import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Archivo a = new Documento("a.txt", 100, "contenido de a"); //creamos un objeto de tipo Documento, que es una subclase de Archivo (polimorfismo)
    //completamos el app
        ArrayList<Archivo> archivos = new ArrayList<>();
        archivos.add(new Documento("documento1.txt", 200, "contenido del documento 1"));
        archivos.add(new Imagen("imagen1.jpg", 500, "1920x1080"));
        archivos.add(new Apk("app1.apk", 1000, "1.0.0"));

        for (Archivo archivo : archivos) {
            System.out.println("Nombre: " + archivo.getNombre());
            System.out.println("Tamaño: " + archivo.getTamanio() + " KB");

            if (archivo instanceof Documento) {
                Documento doc = (Documento) archivo;
                System.out.println("Contenido: " + doc.getContenido());
            } else if (archivo instanceof Imagen) {
                Imagen img = (Imagen) archivo;
                System.out.println("Resolución: " + img.getResolucion());
            } else if (archivo instanceof Apk) {
                Apk apk = (Apk) archivo;
                System.out.println("Versión: " + apk.getVersion());
            }

            System.out.println();
        }
    }
       
}
