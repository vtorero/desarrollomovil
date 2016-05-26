package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class LocalSpecialty {

    int in_estado;
    long co_especialidad;
    long co_sede;

    public LocalSpecialty(int in_estado, long co_especialidad, long co_sede) {
        this.in_estado = in_estado;
        this.co_especialidad = co_especialidad;
        this.co_sede = co_sede;
    }

    public int getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(int in_estado) {
        this.in_estado = in_estado;
    }

    public long getCo_especialidad() {
        return co_especialidad;
    }

    public void setCo_especialidad(long co_especialidad) {
        this.co_especialidad = co_especialidad;
    }

    public long getCo_sede() {
        return co_sede;
    }

    public void setCo_sede(long co_sede) {
        this.co_sede = co_sede;
    }
}
