package pe.edu.upc.clinicaupc;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Reserva {
    long co_reserva;

    public long getCo_reserva() {
        return co_reserva;
    }

    public void setCo_reserva(long co_reserva) {
        this.co_reserva = co_reserva;
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

    String de_especialidad;
    int in_estado;

    public Reserva(long co_reserva, String de_especialidad, int in_estado) {
        this.co_reserva = co_reserva;
        this.de_especialidad = de_especialidad;
        this.in_estado = in_estado;
    }
}
