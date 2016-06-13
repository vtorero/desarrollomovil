package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Local {
    String co_sede;
    String de_sede;
    int in_estado;

    public Local(String co_sede, String de_sede, int in_estado) {
        this.co_sede = co_sede;
        this.de_sede = de_sede;
        this.in_estado = in_estado;
    }

    public String getCo_sede() {
        return co_sede;
    }

    public void setCo_sede(String co_sede) {
        this.co_sede = co_sede;
    }

    public String getDe_sede() {
        return de_sede;
    }

    public void setDe_sede(String de_sede) {
        this.de_sede = de_sede;
    }

    public int getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(int in_estado) {
        this.in_estado = in_estado;
    }
}
