package colecciones;



import java.util.ArrayList;
import java.util.Comparator;


/**
 * Clase Inventario para gestionar la colección de productos.
 */
public class Inventario {
    private final ArrayList<Producto> productos;

   
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // --- Métodos Requeridos ---

  
    public void agregarProducto(Producto p) {
        // Verificar si ya existe un producto con el mismo ID
        if (buscarProductoPorId(p.getId()) == null) {
            productos.add(p);
            System.out.println("Producto agregado: " + p.getNombre());
        } else {
            System.out.println("ERROR: Ya existe un producto con el ID " + p.getId() + ". No se agregó.");
        }
    }

    /**
     * Lista todos los productos en el inventario.
     */
    public void listarProductos() {
        System.out.println("\n--- LISTADO COMPLETO DE PRODUCTOS (" + productos.size() + " en stock) ---");
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto p : productos) {
                p.mostrarInfo();
            }
        }
        System.out.println("------------------------------------------------------------------");
    }

   
    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

   
    public boolean eliminarProducto(String id) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            productos.remove(p);
            System.out.println("Producto eliminado: " + p.getNombre() + " (ID: " + id + ")");
            return true;
        } else {
            System.out.println("ERROR: No se encontró un producto con el ID " + id + " para eliminar.");
            return false;
        }
    }


    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            int stockAnterior = p.getCantidad();
            p.setCantidad(nuevaCantidad);
            System.out.println("Stock actualizado para " + p.getNombre() + 
                               " (ID: " + id + "). De " + stockAnterior + " a " + nuevaCantidad + ".");
            return true;
        } else {
            System.out.println("ERROR: No se encontró un producto con el ID " + id + " para actualizar stock.");
            return false;
        }
    }

  
    public void filtrarPorCategoria(CategoriaProducto categoria) {
        System.out.println("\n--- PRODUCTOS EN LA CATEGORÍA: " + categoria.name() + " ---");
        int count = 0;
        for (Producto p : productos) {
            if (p.getCategoria() == categoria) {
                p.mostrarInfo();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No se encontraron productos en la categoría " + categoria.name() + ".");
        }
        System.out.println("---------------------------------------------------------");
    }


    public int obtenerTotalStock() {
        int totalStock = 0;
        for (Producto p : productos) {
            totalStock += p.getCantidad();
        }
        return totalStock;
    }


    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }
        
     
        return productos.stream()
                        .max(Comparator.comparingInt(Producto::getCantidad))
                        .orElse(null);

    }


    public void filtrarProductosPorPrecio(double min, double max) {
        System.out.println("\n--- PRODUCTOS CON PRECIOS ENTRE $" + String.format("%.2f", min) + " y $" + String.format("%.2f", max) + " ---");
        int count = 0;
        for (Producto p : productos) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                p.mostrarInfo();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No se encontraron productos en ese rango de precios.");
        }
        System.out.println("------------------------------------------------------------------");
    }
    
    /**
     * Muestra todas las categorías disponibles con su descripción.
     */
    public void mostrarCategoriasDisponibles() {
        System.out.println("\n--- CATEGORÍAS DISPONIBLES ---");
        for (CategoriaProducto cat : CategoriaProducto.values()) {
            System.out.println("️ " + cat.name() + ": " + cat.getDescripcion());
        }
        System.out.println("------------------------------");
    }
}