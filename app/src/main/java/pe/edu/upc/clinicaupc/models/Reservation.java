package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Reservation {
    long co_reserva;
    long co_cronograma;
    long co_paciente;
    String fe_reserva;
    String fe_cancela;
    int in_estado;

    public Reservation(long co_reserva, long co_cronograma, long co_paciente, String fe_reserva, String fe_cancela, int in_estado) {
        this.co_reserva = co_reserva;
        this.co_cronograma = co_cronograma;
        this.co_paciente = co_paciente;
        this.fe_reserva = fe_reserva;
        this.fe_cancela = fe_cancela;
        this.in_estado = in_estado;
    }

    public long getCo_reserva() {
        return co_reserva;
    }

    public void setCo_reserva(long co_reserva) {
        this.co_reserva = co_reserva;
    }

    public long getCo_cronograma() {
        return co_cronograma;
    }

    public void setCo_cronograma(long co_cronograma) {
        this.co_cronograma = co_cronograma;
    }

    public long getCo_paciente() {
        return co_paciente;
    }

    public void setCo_paciente(long co_paciente) {
        this.co_paciente = co_paciente;
    }

    public String getFe_reserva() {
        return fe_reserva;
    }

    public void setFe_reserva(String fe_reserva) {
        this.fe_reserva = fe_reserva;
    }

    public String getFe_cancela() {
        return fe_cancela;
    }

    public void setFe_cancela(String fe_cancela) {
        this.fe_cancela = fe_cancela;
    }

    public int getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(int in_estado) {
        this.in_estado = in_estado;
    }
}
