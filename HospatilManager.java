import java.util.ArrayList;

public class HospatilManager {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public HospatilManager() {
        // doctors = new ArrayList<Doctor>();
        // patients = new ArrayList<Patient>();
    }

    /*
     * /-----------------------
     * ======= [ DoctorStart ] =======
     * /-----------------------
     */
    public static void showDoctor(Doctor doctor) {
        System.out.println(doctor.toString());
    }

    // public static Doctor showDoctorById(int id) {
    // for (Doctor doctor : doctors) {
    // if (doctor.getId() == id) {
    // return doctor;
    // }
    // }
    // return null;
    // }

    public static void addDoctor(Doctor doctor) {
        if (findDoctor(doctor)) {
            System.out.println("doctor is exist!");
            return;
        }
        doctors.add(doctor);
        System.out.println("doctor Added!");
    }

    public void removeDoctor(Doctor doctor) {
        if (!findDoctor(doctor)) {
            System.out.println("doctor is not exist!");
            return;
        }
        doctors.remove(doctor);
        System.out.println("doctor Removed!");
    }

    public static void removeDoctorByID(int id) {
        Doctor doctor = findDoctorById(id);
        if (doctor == null) {
            System.out.println("doctor is not exist!");
            return;
        }
        doctors.remove(doctor);
        System.out.println("doctor Removed!");
    }

    public static void editDoctor(int id, Doctor resdoctor) {
        Doctor doctor = findDoctorById(id);
        if (doctor == null) {
            System.out.println("doctor is not exist!");
            return;
        }
        doctors.set(findDoctorindex(doctor), resdoctor);
        System.out.println("doctor edited!");
    }

    public void editDoctor(Doctor doctor) {
        int index = findDoctorindex(doctor);
        if (index == -1) {
            System.out.println("doctor is not exist!");
            return;
        }
        doctors.set(index, doctor);
        System.out.println("doctor edited!");
    }

    public static void listAllDoctors() {
        String data = "";
        for (Doctor doctor : doctors) {
            data += doctor.toString();
        }
        System.out.println("Doctor count : " + doctors.size());
        System.out.println(data);
    }

    private static boolean findDoctor(Doctor Rescdoctor) {
        for (Doctor doctor : doctors) {
            if (doctor.equal(Rescdoctor)) {
                return true;
            }
        }
        return false;
    }

    public static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    private static int findDoctorindex(Doctor Rescdoctor) {
        int i = 0;
        for (Doctor doctor : doctors) {
            if (doctor.equal(Rescdoctor)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /*
     * /-----------------------
     * ======= [ PatientStart ] =======
     * /-----------------------
     */

    public static void showPatient(Patient patient) {
        System.out.println(patient.toString());
    }

    public static Patient showPatinetById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public static void addPatient(Patient patient) {
        if (findPatient(patient)) {
            System.out.println("Patient is exist!");
            return;
        }
        patients.add(patient);
        System.out.println("patient Added!");
    }

    public static void removePatient(Patient pateint) {
        if (!findPatient(pateint)) {
            System.out.println("pateint is not exist!");
            return;
        }
        patients.remove(pateint);
        System.out.println("pateint Removed!");
    }

    public static void editPatientByindex(int index, Patient patinet) {
        if (!findPatient(patinet)) {
            System.out.println("Patient is not exist!");
            return;
        }
        patients.set(index, patinet);
        System.out.println("Patient edited!");
    }
   
    public static void editPatient(int id, Patient resPatient) {
        Patient patient = findPatientById(id);
        if (resPatient == null) {
            System.out.println("patient is not exist!");
            return;
        }
        patients.set(findPatientByindex(patient), resPatient);
        System.out.println("patient edited!");
    }

    public static void editPatient(Patient patient) {
        int index = findPatientByindex(patient);
        if (index == -1) {
            System.out.println("patient is not exist!");
            return;
        }
        patients.set(index, patient);
        System.out.println("patient edited!");
    }

    public static void listAllPatient() {
        String data = "";
        for (Patient patient : patients) {
            data += patient.toString();
        }
        System.out.println(data);
    }

    private static boolean findPatient(Patient RescPatient) {
        for (Patient patient : patients) {
            if (patient.equal(RescPatient)) {
                return true;
            }
        }
        return false;
    }

    private static int findPatientByindex(Patient RescPatient) {
        for (Patient patient : patients) {
            if (patient.equal(RescPatient)) {
                return RescPatient.getId();
            }
        }
        return -1;
    }

    public static Patient findPatientById(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static void removePatientByID(int id) {
        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("patient is not exist!");
            return;
        }
        patients.remove(patient);
        System.out.println("patient Removed!");
    }

       /*
     * /-----------------------
     * ======= [ Appointment Start ] =======
     * /-----------------------
     */

     public static void makeAppointment(int doctorId,int patientId, Date appointmentDate) {
        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);

        if (doctor != null && patient != null) {
            Appointment appointment = new Appointment(doctor, patient, appointmentDate);
            appointments.add(appointment);
            doctor.addAppointment(appointment);
            patient.addAppointment(appointment);
            System.out.println("Appointment made successfully!");
        } else {
            System.out.println("Doctor or Patient is not exist!");
        }
    }
}
