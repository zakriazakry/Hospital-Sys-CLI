
import java.util.ArrayList;

public class Patient {

    private int id;
    private Name name;
    private String phone;
    private Date birthDate;
    private ArrayList<Appointment> appointments;
    public Patient(int id, Name name, String phone, Date birthDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;
        this.appointments = new ArrayList<>();
    }
    public Date getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Appointment> getpatientList() {
        return appointments;
    }
    public void printpatientList() {
        for (Appointment appointment : appointments) {
            // System.out.println("Doctor : " + appointment.getDoctor().getName().getFullName() + " , Time : "+appointment.getAppointmentDate().toString());
            System.out.println(appointment.toString());
        }
    }
    public Name getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

  
    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean equal(Patient p) {
        return this.id == p.id && this.name == p.name && this.phone.equals(p.phone) && this.birthDate == p.birthDate;
    }

    public String toString() {

        return "ID : "+  id
                + " Name : " + name.getFullName() + " Phone : " + phone  + " Birth Date" + birthDate +"\n";
    }
}
