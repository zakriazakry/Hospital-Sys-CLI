
import java.util.ArrayList;

public class Doctor {

    private int id;
    private Name name;
    private String email;
    private String phone;
    private double priceService;// سعر الحجز
    private ArrayList<Appointment> appointments;
    private Date birthDate;

    public Doctor(int id, Name name, String email, String phone, double priceService, Date birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.priceService = priceService;
        this.birthDate = birthDate;
        this.appointments = new ArrayList<>();
    }
    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double getPriceService() {
        return priceService;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Appointment> getpatientList() {
        return appointments;
    }
    public void printpatientList() {
        for (Appointment appointment : appointments) {
            System.out.println( "Patient : " + appointment.getPatient().getName().getFullName() + " , Time : "+appointment.getAppointmentDate().toString());
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPriceService(double priceService) {
        this.priceService = priceService;
    }



    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    //=====================================================================
    public boolean equal(Doctor d) {
        return this.id == d.id && this.name == d.name && this.email.equals(d.email) && this.phone.equals(d.phone) && this.priceService == d.priceService && this.birthDate == d.birthDate;
    }

    public String toString() {
        return " ID : "+id + " Name : "+name.getFullName()+ 
         " and Email : "+email+ " Phone : "+phone +" price service : "+ priceService + " LYD"+"\n";
   }

}
