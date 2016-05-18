package pe.edu.upc.clinicaupc;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Medico {

    long co_medico;
    String de_nombreCompleto;
    long co_especialidad;
    int in_estado;

    public Medico(long co_medico, String de_nombreCompleto, long co_especialidad, int in_estado) {
        this.co_medico = co_medico;
        this.de_nombreCompleto = de_nombreCompleto;
        this.co_especialidad = co_especialidad;
        this.in_estado = in_estado;
    }

    public long getCo_medico() {
        return co_medico;
    }

    public void setCo_medico(long co_medico) {
        this.co_medico = co_medico;
    }

    public String getDe_nombreCompleto() {
        return de_nombreCompleto;
    }

    public void setDe_nombreCompleto(String de_nombreCompleto) {
        this.de_nombreCompleto = de_nombreCompleto;
    }

    public long getCo_especialidad() {
        return co_especialidad;
    }

    public void setCo_especialidad(long co_especialidad) {
        this.co_especialidad = co_especialidad;
    }

    public int getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(int in_estado) {
        this.in_estado = in_estado;
    }
}
