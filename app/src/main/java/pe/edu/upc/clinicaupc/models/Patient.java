package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 17/05/2016.
 */
public class Patient {

    String co_paciente;
    String de_nombreCompleto;
    String nu_dni;
    String de_clave;
    String in_estado;

    public Patient(String co_paciente, String de_nombreCompleto, String nu_dni, String de_clave, String in_estado) {
        this.co_paciente = co_paciente;
        this.de_nombreCompleto = de_nombreCompleto;
        this.nu_dni = nu_dni;
        this.de_clave = de_clave;
        this.in_estado = in_estado;
    }

    public String getCo_paciente() {
        return co_paciente;
    }

    public void setCo_paciente(String co_paciente) {
        this.co_paciente = co_paciente;
    }

    public String getDe_nombreCompleto() {
        return de_nombreCompleto;
    }

    public void setDe_nombreCompleto(String de_nombreCompleto) {
        this.de_nombreCompleto = de_nombreCompleto;
    }

    public String getNu_dni() {
        return nu_dni;
    }

    public void setNu_dni(String nu_dni) {
        this.nu_dni = nu_dni;
    }

    public String getDe_clave() {
        return de_clave;
    }

    public void setDe_clave(String de_clave) {
        this.de_clave = de_clave;
    }

    public String getIn_estado() {
        return in_estado;
    }

    public void setIn_estado(String in_estado) {
        this.in_estado = in_estado;
    }
}
