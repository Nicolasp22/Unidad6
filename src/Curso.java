package universidad_tp;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor; // Profesor responsable

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    // Método de sincronización: Asigna/cambia el profesor y actualiza el lado del profesor.
    public void setProfesor(Profesor nuevoProfesor) {
        // 1. Quitarse de la lista del profesor previo, si existe y no es el nuevo.
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.getCursos().remove(this);
        }

        // 2. Asignar el nuevo profesor.
        this.profesor = nuevoProfesor;

        // 3. Agregar el curso a la lista del nuevo profesor (si es no-nulo y aún no lo tiene).
        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.getCursos().add(this);
        }
    }

    // Métodos requeridos
    public void mostrarInfo() {
        String nombreProfesor = (profesor != null) ? profesor.getNombre() : "Sin asignar";
        System.out.println("Curso{Codigo='" + codigo + "', Nombre='" + nombre + "', Profesor='" + nombreProfesor + "'}");
    }
}