package biblioteca_tp;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        if (buscarLibroPorIsbn(isbn) == null) {
            Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
            libros.add(nuevoLibro);
            System.out.println("Libro agregado: " + titulo);
        } else {
            System.out.println("ERROR: El libro con ISBN " + isbn + " ya existe.");
        }
    }

    public void listarLibros() {
        System.out.println("\n--- LISTADO DE LIBROS EN " + nombre + " (" + libros.size() + " total) ---");
        if (libros.isEmpty()) {
            System.out.println("La biblioteca no tiene libros.");
        } else {
            for (Libro libro : libros) {
                libro.mostrarInfo();
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public boolean eliminarLibro(String isbn) {
        Libro libroAEliminar = buscarLibroPorIsbn(isbn);
        if (libroAEliminar != null) {
            libros.remove(libroAEliminar);
            System.out.println("Libro eliminado: " + libroAEliminar.getTitulo() + " (ISBN: " + isbn + ")");
            return true;
        } else {
            System.out.println("ERROR: No se encontró un libro con el ISBN " + isbn + " para eliminar.");
            return false;
        }
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public void filtrarLibrosPorAnio(int anio) {
        System.out.println("\n--- LIBROS PUBLICADOS EN EL AÑO " + anio + " ---");
        int count = 0;
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                libro.mostrarInfo();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No se encontraron libros publicados en el año " + anio + ".");
        }
        System.out.println("----------------------------------------");
    }

    public void mostrarAutoresDisponibles() {
        Set<Autor> autoresUnicos = new HashSet<>();
        for (Libro libro : libros) {
            autoresUnicos.add(libro.getAutor());
        }

        System.out.println("\n--- AUTORES DISPONIBLES EN LA BIBLIOTECA (" + autoresUnicos.size() + " únicos) ---");
        if (autoresUnicos.isEmpty()) {
            System.out.println("No hay autores disponibles.");
        } else {
            for (Autor autor : autoresUnicos) {
                autor.mostrarInfo();
            }
        }
        System.out.println("---------------------------------------------------------");
    }
}
