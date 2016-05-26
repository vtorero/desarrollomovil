package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Schedule {

    long co_cronograma;
    long co_sede;
    long co_medico;
    String fe_atencion;
    String ho_atencion;
    int in_estado;

    public Schedule(long co_cronograma, long co_sede, long co_medico, String fe_atencion, String ho_atencion, int in_estado) {
        this.co_cronograma = co_cronograma;
        this.co_sede = co_sede;
        this.co_medico = co_medico;
        this.fe_atencion = fe_atencion;
        this.ho_atencion = ho_atencion;
        this.in_estado = in_estado;
    }

    public long getCo_cronograma() {
        return co_cronograma;
    }

    public void setCo_cronograma(long co_cronograma) {
        this.co_cronograma = co_cronograma;
    }

    public long getCo_sede() {
        return co_sede;
    }

    public void setCo_sede(long co_sede) {
        this.co_sede = co_sede;
    }

    public long getCo_medico() {
        return co_medico;
    }

    public void setCo_medico(long co_medico) {
        this.co_medico = co_medico;
    }

    public String getFe_atencion() {
        return fe_atencion;
    }

    public void setFe_atencion(String fe_atencion) {
        this.fe_atencion = fe_atencion;
    }

    public String getHo_atencion() {
        return ho_atencion;
    }

    public void setHo_atencion(String ho_atencion) {
        this.ho_atencion = ho_atencion;
    }

    public int getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(int in_estado) {
        this.in_estado = in_estado;
    }
}
