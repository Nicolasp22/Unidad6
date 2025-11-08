package biblioteca_tp;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("--- INICIO DEL EJERCICIO: GESTIÓN DE BIBLIOTECA ---");
        
        // 1. Creamos una biblioteca.
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UTN");
        System.out.println("\n== Tarea 1: Biblioteca Creada: " + biblioteca.getNombre() + " ==");

        // 2. Crear al menos tres autores
        System.out.println("\n== Tarea 2: Creación de Autores ==");
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Jane Austen", "Británica");
        Autor autor3 = new Autor("A003", "Jorge Luis Borges", "Argentina");
        
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        autor3.mostrarInfo();

        // 3. Agregar 5 libros asociados a alguno de los Autores a la biblioteca.
        System.out.println("\n== Tarea 3: Agregando 5 Libros ==");
        biblioteca.agregarLibro("978-0345", "Cien años de soledad", 1967, autor1);
        biblioteca.agregarLibro("978-0451", "Orgullo y Prejuicio", 1813, autor2);
        biblioteca.agregarLibro("978-0743", "Ficciones", 1944, autor3);
        biblioteca.agregarLibro("978-0234", "El coronel no tiene quien le escriba", 1961, autor1);
        biblioteca.agregarLibro("978-0111", "Emma", 1815, autor2);
        
        // 4. Listar todos los libros con su información y la del autor.
        System.out.println("\n== Tarea 4: Listar todos los libros ==");
        biblioteca.listarLibros();

        // 5. Buscar un libro por su ISBN y mostrar su información.
        System.out.println("\n== Tarea 5: Buscar libro por ISBN (978-0743) ==");
        String isbnBuscar = "978-0743";
        Libro libroEncontrado = biblioteca.buscarLibroPorIsbn(isbnBuscar);
        if (libroEncontrado != null) {
            System.out.print("Libro encontrado: ");
            libroEncontrado.mostrarInfo();
        } else {
            System.out.println("Libro con ISBN " + isbnBuscar + " no encontrado.");
        }

        // 6. Filtrar y mostrar los libros publicados en un año específico (1813).
        System.out.println("\n== Tarea 6: Filtrar por Año (1813) ==");
        biblioteca.filtrarLibrosPorAnio(1813);

        // 7. Eliminar un libro por su ISBN y listar los libros restantes.
        System.out.println("\n== Tarea 7: Eliminar libro (ISBN: 978-0451) y listar restantes ==");
        biblioteca.eliminarLibro("978-0451");
        biblioteca.listarLibros();
        
        // 8. Mostrar la cantidad total de libros en la biblioteca.
        System.out.println("\n== Tarea 8: Cantidad total de libros ==");
        System.out.println("La biblioteca tiene un total de: " + biblioteca.obtenerCantidadLibros() + " libros.");

        // 9. Listar todos los autores de los libros disponibles en la biblioteca.
        System.out.println("\n== Tarea 9: Listar autores disponibles ==");
        biblioteca.mostrarAutoresDisponibles();

        System.out.println("\n--- FIN DEL EJERCICIO ---");
    }
}