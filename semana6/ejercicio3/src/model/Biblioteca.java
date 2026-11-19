package model;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private Map<String, Libro> libros = new HashMap<>();

    public boolean crear(Libro libro) {
        if (libros.containsKey(libro.getIsbn())) {
            return false;
        }
        libros.put(libro.getIsbn(), libro);
        return true;
    }

    public Collection<Libro> listar() {
        return libros.values();
    }

    public Libro buscar(String isbn) {
        return libros.get(isbn);
    }

    public boolean actualizar(String isbn, String titulo, String autor, int anio) {
        Libro libro = libros.get(isbn);
        if (libro == null) {
            return false;
        }
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setAnio(anio);
        return true;
    }

    public boolean eliminar(String isbn) {
        return libros.remove(isbn) != null;
    }

    public int getTotal() {
        return libros.size();
    }
}
