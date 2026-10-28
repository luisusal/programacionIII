package semana7.almacenlibros.src.almacenlibrosmvc.model;

import java.util.ArrayList;

/**
 * 
 * 
 * Clase que representa el modelo de la aplicación.
 * 
 * Gestiona el estado de la aplicación, la lógica de negocio y el acceso
 * a datos (en este caso los datos estan en memoria en una colección).
 * Proximamente podrán venir de otras fuentes...
 * 
 *
 * @author Loza
 */
public class AlmacenModel {
    private String versionPrograma = "0.0.1";
    private ArrayList<Libro> libros;

    public AlmacenModel() {
        libros = new ArrayList<>();
    }

    public String agregarLibro(Libro libro) {
        
        // LOGICA DE NEGOCIO: COMO AÑADIR LIBRO
        // E.G. NO SE PUEDE AÑADIR UN LIBRO CON EL MISMO NOMBRE
        
        for (Libro l : libros) {
            if(l.getTitulo().equals(libro.getTitulo())){
                // Más adelante sustituiremos esto con una excepción.
                return "ERROR: Libro con el mismo nombre";
            } 
        }
        
        libros.add(libro);
        return "EXITO: Libro añadido correctamente";
    }

    public String eliminarLibroPorTitulo(String titulo) {
        
        // LOGICA DE NEGOCIO: COMO BORRAR LIBRO
        Libro libro = null;
        
        for (Libro l : libros) {
            if(titulo.equals(l.getTitulo())){
                libro = l;
            } 
        }
        
        if(libro == null){
            return "ERROR: Libro no encontrado";
        }else{
            libros.remove(libro);
            return "EXITO: Libro borrado correctamente";
        }
        
    }
    
    public boolean comprobarExistenciaLibroPorTitulo(String titulo){
        
        for (Libro l : libros) {
            if(titulo.equals(l.getTitulo())){
                return true;
            } 
        }
        
        return false;
    }

    public void actualizarLibro(Libro libro) {
        
        // LOGICA DE NEGOCIO
        for (Libro l : libros) {
            if(libro.getTitulo().equals(l.getTitulo())){
                // Actualizar datos
                l.setAutor(libro.getAutor());
            } 
        }
        
    }

    public ArrayList<Libro> obtenerLibros() {
        return libros;
    }

    public String getVersionPrograma() {
        return versionPrograma;
    }

    public void setVersionPrograma(String versionPrograma) {
        this.versionPrograma = versionPrograma;
    }
    
}
