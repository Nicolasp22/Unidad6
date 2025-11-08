package universidad_tp;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("--- INICIO DEL EJERCICIO: GESTIÓN DE UNIVERSIDAD ---");
        
        Universidad utn = new Universidad("UTN - TUP");
        
        // 1. Crear al menos 3 profesores y 5 cursos.
        Profesor p1 = new Profesor("P100", "Dr. Pérez", "Programación");
        Profesor p2 = new Profesor("P200", "Lic. García", "Bases de Datos");
        Profesor p3 = new Profesor("P300", "Ing. López", "Redes");

        Curso c1 = new Curso("C101", "Programación Avanzada");
        Curso c2 = new Curso("C102", "Estructura de Datos");
        Curso c3 = new Curso("C201", "Modelado de Datos");
        Curso c4 = new Curso("C301", "Seguridad en Redes");
        Curso c5 = new Curso("C103", "Diseño de Sistemas");
        
        // 2. Agregar profesores y cursos a la universidad.
        System.out.println("\n== Tarea 2: Agregar Profesores y Cursos ==");
        utn.agregarProfesor(p1);
        utn.agregarProfesor(p2);
        utn.agregarProfesor(p3);
        
        utn.agregarCurso(c1);
        utn.agregarCurso(c2);
        utn.agregarCurso(c3);
        utn.agregarCurso(c4);
        utn.agregarCurso(c5);
        
        // 3. Asignar profesores a cursos usando asignarProfesorACurso(...).
        System.out.println("\n== Tarea 3: Asignar Profesores a Cursos ==");
        utn.asignarProfesorACurso("C101", "P100"); // P1 asigna C101
        utn.asignarProfesorACurso("C102", "P100"); // P1 asigna C102
        utn.asignarProfesorACurso("C201", "P200"); // P2 asigna C201
        utn.asignarProfesorACurso("C301", "P300"); // P3 asigna C301
        utn.asignarProfesorACurso("C103", "P100"); // P1 asigna C103

        // 4. Listar cursos con su profesor y profesores con sus cursos.
        System.out.println("\n== Tarea 4: Listar Cursos y Profesores ==");
        utn.listarCursos();
        p1.listarCursos();
        p2.listarCursos();

        // 5. Cambiar el profesor de un curso y verificar que ambos lados quedan sincronizados.
        System.out.println("\n== Tarea 5: Cambiar profesor de C103 (P1 -> P2) ==");
        utn.asignarProfesorACurso("C103", "P200"); // C103 ahora va a P200

        System.out.println("-- Verificación de listas después del cambio --");
        p1.listarCursos(); // C103 debe desaparecer de aquí
        p2.listarCursos(); // C103 debe aparecer aquí
        utn.buscarCursoPorCodigo("C103").mostrarInfo();

        // 6. Remover un curso y confirmar que ya no aparece en la lista del profesor.
        System.out.println("\n== Tarea 6: Remover curso C201 (dictado por P200) ==");
        utn.eliminarCurso("C201");
        p2.listarCursos(); // C201 debe desaparecer de aquí

        // 7. Remover un profesor y dejar profesor = null,
        System.out.println("\n== Tarea 7: Remover profesor P300 (dicta C301) ==");
        utn.eliminarProfesor("P300");
        utn.listarProfesores();
        
        // Verificar que C301 ahora no tiene profesor
        Curso c301 = utn.buscarCursoPorCodigo("C301");
        if (c301 != null) {
            c301.mostrarInfo();
        }

        // 8. Mostrar un reporte: cantidad de cursos por profesor.
        System.out.println("\n== Tarea 8: Reporte de Cursos por Profesor ==");
        utn.mostrarReporteCursosPorProfesor();

        System.out.println("\n--- FIN DEL EJERCICIO ---");
    }
}