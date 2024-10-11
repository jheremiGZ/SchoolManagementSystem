public interface ServiciosAcademicosI {
    void matricularEstudiante(estudiante estudiante) throws EstudianteYaInscritoException;
    void agregarCurso(curso curso);
    void inscribirEstudianteCurso(estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
