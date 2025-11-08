package colecciones;


public class Producto {
    // Atributos de instancia
    private String id;
    private String nombre;
    private double precio;
    private int cantidad; // stock
    private CategoriaProducto categoria;


    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // --- Métodos Getters ---

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    // --- Métodos Setters ---


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    // --- Métodos Requeridos ---

 
    public void mostrarInfo() {
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "Producto{" +
               "ID='" + id + '\'' +
               ", Nombre='" + nombre + '\'' +
               ", Precio=" + String.format("%.2f", precio) +
               ", Stock=" + cantidad +
               ", Categoría=" + categoria.name() +
               " (" + categoria.getDescripcion() + ")" +
               '}';
    }
}
