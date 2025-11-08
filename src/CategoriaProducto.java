package colecciones;


public enum CategoriaProducto {
    // Valores de la enumeración con su descripción
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Dispositivos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Artículos para el hogar");

    // Atributo para la descripción de la categoría
    private final String descripcion;

    CategoriaProducto(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getDescripcion() {
        return descripcion;
    }
}
