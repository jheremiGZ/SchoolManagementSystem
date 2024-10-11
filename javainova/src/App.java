import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        try {
            gestoracademico gestor = new gestoracademico();

            estudiante estudiante1 = new estudiante(1, "Juan", "Pérez", LocalDate.of(2000, 1, 1), "matriculado");
            estudiante estudiante2 = new estudiante(2, "Ana", "Gómez", LocalDate.of(2001, 2, 2), "matriculado");

            curso curso1 = new curso(1, "Programación 101", "Introducción a la programación", 3, "1.0");
            curso curso2 = new curso(2, "Bases de Datos", "Fundamentos de bases de datos", 4, "1.0");

            // Matricular estudiantes
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            // Agregar cursos
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            // Inscribir estudiantes en cursos
            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 1);
            gestor.inscribirEstudianteCurso(estudiante1, 2);

            // Mostrar inscripciones
            gestor.mostrarInscripciones(curso1);
            gestor.mostrarInscripciones(curso2);

            // Desinscribir un estudiante
            gestor.desinscribirEstudianteCurso(1, 1);
            gestor.mostrarInscripciones(curso1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
