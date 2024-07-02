
public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String note;
    private Date appointmentDate;

    public Appointment(Doctor doctor, Patient patient, Date appointmentDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Appointment => " +
                "doctor = " + doctor.getName() +
                ", patient = " + patient.getName() +
                ", appointmentDate = " + appointmentDate;
    }
}
