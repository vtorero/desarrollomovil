package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Specialty {
    String co_especilidad;
    String de_especialidad;
    String in_estado;

    public Specialty(String co_especilidad, String de_especialidad, String in_estado) {
        this.co_especilidad = co_especilidad;
        this.de_especialidad = de_especialidad;
        this.in_estado = in_estado;
    }

    public String getCo_especilidad() {
        return co_especilidad;
    }

    public void setCo_especilidad(String co_especilidad) {
        this.co_especilidad = co_especilidad;
    }

    public String getDe_especialidad() {
        return de_especialidad;
    }

    public void setDe_especialidad(String de_especialidad) {
        this.de_especialidad = de_especialidad;
    }

    public String getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(String in_estado) {
        this.in_estado = in_estado;
    }
}
