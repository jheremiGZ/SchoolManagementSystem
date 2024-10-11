import java.time.LocalDate;

public class estudiante extends Persona {
    private LocalDate fechaDeNacimiento;
    private String estado; // "matriculado", "inactivo", "graduado"

    public estudiante(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, String estado) {
        super(id, nombre, apellido);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", estado='" + estado + '\'' +
                '}';
    }
}
