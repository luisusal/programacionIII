package semana7.almacenlibros.src.almacenlibrosmvc.model;

/**
 *
 * POJO que unicamente representa la información de un Libro.
 * 
 * @author Loza
 */
public class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}

