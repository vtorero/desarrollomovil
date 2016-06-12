package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 07/06/2016.
 */
public class Appointment {
    String co_reserva;
    String de_especialidad;
    String de_nombreCompleto;
    String fe_reserva;
    String ho_atencion;
    String de_sede;

    public Appointment(String co_reserva, String de_especialidad, String de_nombreCompleto, String fe_reserva, String ho_atencion, String de_sede) {
        this.co_reserva = co_reserva;
        this.de_especialidad = de_especialidad;
        this.de_nombreCompleto = de_nombreCompleto;
        this.fe_reserva = fe_reserva;
        this.ho_atencion = ho_atencion;
        this.de_sede = de_sede;
    }

    public String getCo_reserva() {
        return co_reserva;
    }

    public void setCo_reserva(String co_reserva) {
        this.co_reserva = co_reserva;
    }

    public String getDe_especialidad() {
        return de_especialidad;
    }

    public void setDe_especialidad(String de_especialidad) {
        this.de_especialidad = de_especialidad;
    }

    public String getDe_nombreCompleto() {
        return de_nombreCompleto;
    }

    public void setDe_nombreCompleto(String de_nombreCompleto) {
        this.de_nombreCompleto = de_nombreCompleto;
    }

    public String getFe_reserva() {
        return fe_reserva;
    }

    public void setFe_reserva(String fe_reserva) {
        this.fe_reserva = fe_reserva;
    }

    public String getHo_atencion() {
        return ho_atencion;
    }

    public void setHo_atencion(String ho_atencion) {
        this.ho_atencion = ho_atencion;
    }

    public String getDe_sede() {
        return de_sede;
    }

    public void setDe_sede(String de_sede) {
        this.de_sede = de_sede;
    }
}
