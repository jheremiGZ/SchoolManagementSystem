import java.util.ArrayList;
import java.util.HashMap;

public class gestoracademico implements ServiciosAcademicosI {
    private ArrayList<estudiante> estudiantes;
    private ArrayList<curso> cursos;
    private HashMap<curso, ArrayList<estudiante>> inscripciones;

    public gestoracademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(estudiante estudiante) throws EstudianteYaInscritoException {
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            inscripciones.put(curso, new ArrayList<>());
        }
    }

    @Override
    public void inscribirEstudianteCurso(estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        curso curso = buscarCursoPorId(idCurso);
        if (curso != null && estudiantes.contains(estudiante)) {
            if (inscripciones.get(curso).contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
            }
            inscripciones.get(curso).add(estudiante);
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        curso curso = buscarCursoPorId(idCurso);
        estudiante estudiante = buscarEstudiantePorId(idEstudiante);
        if (curso != null && estudiante != null) {
            if (!inscripciones.get(curso).contains(estudiante)) {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
            }
            inscripciones.get(curso).remove(estudiante);
        }
    }

    private curso buscarCursoPorId(int idCurso) {
        return cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null);
    }

    private estudiante buscarEstudiantePorId(int idEstudiante) {
        return estudiantes.stream().filter(e -> e.getId() == idEstudiante).findFirst().orElse(null);
    }

    public void mostrarInscripciones(curso curso) {
        System.out.println("Inscripciones en el curso " + curso.getNombre() + ": " + inscripciones.get(curso));
    }
}
