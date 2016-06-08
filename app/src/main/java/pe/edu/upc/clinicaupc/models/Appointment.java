package pe.edu.upc.clinicaupc.models;

/**
 * Created by alumnos on 07/06/2016.
 */
public class Appointment {
    String speciality;
    String doctor;

    public Appointment(String speciality, String doctor) {
        this.speciality = speciality;
        this.doctor = doctor;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
