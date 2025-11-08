package colecciones;




import static colecciones.CategoriaProducto.*;

/**
 * Clase principal para probar la gestión del inventario.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("--- INICIO DEL CASO PRÁCTICO: GESTIÓN DE INVENTARIO ---");
        
        Inventario inventario = new Inventario();

        // 1. Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.
        System.out.println("\n== Tarea 1: Creación y adición de productos ==");
        Producto p1 = new Producto("A001", "Manzanas kg", 1500.50, 50, ALIMENTOS);
        Producto p2 = new Producto("E010", "Smart TV 4K", 250000.99, 12, ELECTRONICA);
        Producto p3 = new Producto("R005", "Camiseta Algodón", 2500.00, 150, ROPA);
        Producto p4 = new Producto("H100", "Juego de Sábanas", 4500.75, 30, HOGAR);
        Producto p5 = new Producto("A002", "Leche UHT L.", 990.00, 200, ALIMENTOS);
        Producto p6 = new Producto("R006", "Pantalón Denim", 15000.00, 40, ROPA);
        
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);
        
        // Intentar agregar un producto con ID duplicado (para probar la validación)
        inventario.agregarProducto(new Producto("A001", "Peras kg", 1800.00, 10, ALIMENTOS));
        
        // 2. Listar todos los productos mostrando su información y categoría.
        System.out.println("\n== Tarea 2: Listar todos los productos ==");
        inventario.listarProductos();

        // 3. Buscar un producto por ID y mostrar su información.
        System.out.println("\n== Tarea 3: Buscar producto por ID (E010) ==");
        String idBuscar = "E010";
        Producto productoEncontrado = inventario.buscarProductoPorId(idBuscar);
        if (productoEncontrado != null) {
            System.out.print("Producto encontrado: ");
            productoEncontrado.mostrarInfo();
        } else {
            System.out.println("Producto con ID " + idBuscar + " no encontrado.");
        }

        // 4. Filtrar y mostrar productos que pertenezcan a una categoría específica.
        System.out.println("\n== Tarea 4: Filtrar por Categoría (ROPA) ==");
        inventario.filtrarPorCategoria(ROPA);

        // 5. Eliminar un producto por su ID y listar los productos restantes.
        System.out.println("\n== Tarea 5: Eliminar producto (ID: H100) y listar restantes ==");
        inventario.eliminarProducto("H100");
        inventario.listarProductos();
        
        // 6. Actualizar el stock de un producto existente.
        System.out.println("\n== Tarea 6: Actualizar stock de p5 (ID: A002) ==");
        inventario.actualizarStock("A002", 250);
        // Mostrar el producto actualizado
        inventario.buscarProductoPorId("A002").mostrarInfo();

        // 7. Mostrar el total de stock disponible.
        System.out.println("\n== Tarea 7: Mostrar el total de stock disponible ==");
        System.out.println("Stock Total en el Inventario: " + inventario.obtenerTotalStock() + " unidades.");

        // 8. Obtener y mostrar el producto con mayor stock.
        System.out.println("\n== Tarea 8: Producto con mayor stock ==");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("Producto con Mayor Stock: ");
            mayorStock.mostrarInfo();
        }

        // 9. Filtrar productos con precios entre $1000 y $3000.
        System.out.println("\n== Tarea 9: Filtrar productos por precio ($1000 a $3000) ==");
        inventario.filtrarProductosPorPrecio(1000.00, 3000.00);

        // 10. Mostrar las categorías disponibles con sus descripciones.
        System.out.println("\n== Tarea 10: Mostrar categorías disponibles con descripciones ==");
        inventario.mostrarCategoriasDisponibles();

        System.out.println("\n--- FIN DEL CASO PRÁCTICO ---");
    }
}
