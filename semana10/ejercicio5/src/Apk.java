public class Apk extends Archivo {
    String version;

    public Apk(String nombre, int tamanio, String version) {
        super(nombre, tamanio);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

}
