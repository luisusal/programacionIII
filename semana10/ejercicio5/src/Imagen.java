public class Imagen extends Archivo {
    String resolucion;

    public Imagen(String nombre, int tamanio, String resolucion) {
        super(nombre, tamanio);
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }

}
