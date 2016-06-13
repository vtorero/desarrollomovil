package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Doctor {

    String co_medico;
    String de_nombreCompleto;
    String co_especialidad;
    String de_especialidad;
    int in_estado;

    public Doctor(String co_medico, String de_nombreCompleto, String co_especialidad,String de_especialidad, int in_estado) {
        this.co_medico = co_medico;
        this.de_nombreCompleto = de_nombreCompleto;
        this.co_especialidad = co_especialidad;
        this.de_especialidad = de_especialidad;
        this.in_estado = in_estado;
    }

    public String getCo_medico() {
        return co_medico;
    }

    public void setCo_medico(String co_medico) {
        this.co_medico = co_medico;
    }

    public String getDe_nombreCompleto() {
        return de_nombreCompleto;
    }

    public void setDe_nombreCompleto(String de_nombreCompleto) {
        this.de_nombreCompleto = de_nombreCompleto;
    }

    public String getCo_especialidad() {
        return co_especialidad;
    }

    public void setCo_especialidad(String co_especialidad) {
        this.co_especialidad = co_especialidad;
    }

    public String getDo_especialidad() {
        return de_especialidad;
    }

    public void setDe_especialidad(String de_especialidad) {
        this.de_especialidad = de_especialidad;
    }


    public int getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(int in_estado) {
        this.in_estado = in_estado;
    }
}
