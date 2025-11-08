package universidad_tp;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }

    public String getEspecialidad() { 
    return especialidad;
    }

    // Métodos de sincronización
    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            // Sincronizar el lado del curso: setProfesor(this) si aún no está asignado.
            if (c.getProfesor() != this) {
                c.setProfesor(this);
            }
        }
    }

    public void eliminarCurso(Curso c) {
        if (cursos.contains(c)) {
            cursos.remove(c);
            // Sincronizar el lado del curso: dejar profesor en null.
            if (c.getProfesor() == this) {
                c.setProfesor(null);
            }
        }
    }

    // Métodos requeridos
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("El profesor " + nombre + " no dicta cursos actualmente.");
            return;
        }
        System.out.println("Cursos dictados por " + nombre + " (" + especialidad + "):");
        for (Curso curso : cursos) {
            System.out.println("  [" + curso.getCodigo() + "] " + curso.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.println("Profesor{ID='" + id + "', Nombre='" + nombre + "', Especialidad='" + especialidad + "', Cursos=" + cursos.size() + "}");
    }
}