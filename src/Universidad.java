package universidad_tp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
 
public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    // Métodos de búsqueda
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    // Métodos de gestión
    public void agregarProfesor(Profesor p) {
        if (buscarProfesorPorId(p.getId()) == null) {
            profesores.add(p);
            System.out.println("Profesor agregado: " + p.getNombre());
        } else {
            System.out.println("ERROR: El profesor con ID " + p.getId() + " ya existe.");
        }
    }

    public void agregarCurso(Curso c) {
        if (buscarCursoPorCodigo(c.getCodigo()) == null) {
            cursos.add(c);
            System.out.println("Curso agregado: " + c.getNombre());
        } else {
            System.out.println("ERROR: El curso con código " + c.getCodigo() + " ya existe.");
        }
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);

        if (curso == null) {
            System.out.println("ERROR: Curso con código " + codigoCurso + " no encontrado.");
            return;
        }
        if (profesor == null) {
            System.out.println("ERROR: Profesor con ID " + idProfesor + " no encontrado.");
            return;
        }
        
        // La asignación y la sincronización se realizan en el setProfesor del Curso.
        Profesor profesorPrevio = curso.getProfesor();
        curso.setProfesor(profesor);

        String prev = (profesorPrevio != null) ? profesorPrevio.getNombre() : "Nadie";
        System.out.println("Asignación exitosa: " + profesor.getNombre() + " asignado al curso " + curso.getNombre() + ". Profesor previo: " + prev);
    }

    public void listarProfesores() {
        System.out.println("\n--- LISTADO DE PROFESORES (" + profesores.size() + ") ---");
        for (Profesor p : profesores) {
            p.mostrarInfo();
        }
        System.out.println("---------------------------------------------");
    }

    public void listarCursos() {
        System.out.println("\n--- LISTADO DE CURSOS (" + cursos.size() + ") ---");
        for (Curso c : cursos) {
            c.mostrarInfo();
        }
        System.out.println("---------------------------------------------");
    }

    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Eliminar la relación bidireccional antes de remover el curso.
            Profesor profesor = curso.getProfesor();
            if (profesor != null) {
                // setProfesor(null) se encarga de quitar el curso de la lista del profesor.
                curso.setProfesor(null); 
            }
            cursos.remove(curso);
            System.out.println("Curso eliminado: " + curso.getNombre() + " (Código: " + codigo + ")");
            return true;
        } else {
            System.out.println("ERROR: Curso con código " + codigo + " no encontrado para eliminar.");
            return false;
        }
    }

    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Antes de remover, dejar null los cursos que dictaba.
            // Recorrer una copia de la lista para evitar ConcurrentModificationException.
            List<Curso> cursosDictados = new ArrayList<>(profesor.getCursos());
            for (Curso curso : cursosDictados) {
                // setProfesor(null) sincroniza, quitándose de la lista del profesor.
                curso.setProfesor(null); 
                System.out.println("  > Curso " + curso.getNombre() + " desasignado.");
            }
            
            profesores.remove(profesor);
            System.out.println("Profesor eliminado: " + profesor.getNombre() + " (ID: " + id + ")");
            return true;
        } else {
            System.out.println("ERROR: Profesor con ID " + id + " no encontrado para eliminar.");
            return false;
        }
    }
    
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("\n--- REPORTE: Cantidad de Cursos por Profesor ---");
        for (Profesor p : profesores) {
            System.out.println(p.getNombre() + " (" + p.getEspecialidad() + "): " + p.getCursos().size() + " cursos.");
        }
        System.out.println("-------------------------------------------------");
    }
}