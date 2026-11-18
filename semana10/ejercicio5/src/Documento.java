public class Documento extends Archivo {
    String contenido;

    public Documento(String nombre, int tamanio, String contenido) {
        super(nombre, tamanio);
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

}
