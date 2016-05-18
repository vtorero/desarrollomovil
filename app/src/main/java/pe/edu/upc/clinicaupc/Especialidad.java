package pe.edu.upc.clinicaupc;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Especialidad {
    long co_especilidad;
    String de_especialidad;
    int in_estado;

    public Especialidad(long co_especilidad, String de_especialidad, int in_estado) {
        this.co_especilidad = co_especilidad;
        this.de_especialidad = de_especialidad;
        this.in_estado = in_estado;
    }

    public long getCo_especilidad() {
        return co_especilidad;
    }

    public void setCo_especilidad(long co_especilidad) {
        this.co_especilidad = co_especilidad;
    }

    public String getDe_especialidad() {
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
