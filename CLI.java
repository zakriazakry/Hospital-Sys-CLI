import java.util.*;

public class CLI {
    private ArrayList<KeyValue> myService = new ArrayList<>();
    Creator _create ;
    GenerateMe _generateMe;
    public CLI() {
        myService = new ArrayList<>();
        _create = new Creator();
        _generateMe = new GenerateMe();
        //========== [ HELPER Start ] ============ 
        myService.add(new KeyValue("h", () -> help()));
        myService.add(new KeyValue("Help", () -> help()));
        //========== [ HELPER End ] ============ 
        //-------------------------[ Doctor Starting ]--------------------------------------
        myService.add(new KeyValue("Add Doctor", () -> 
            HospatilManager.addDoctor( _create.createDoctorInstance())
        ));
        myService.add(new KeyValue("Remove Doctor", () -> 
        HospatilManager.removeDoctorByID( _create.insertID())
        ));
        myService.add(new KeyValue("Edit Doctor", () -> 
        {
            int id =_create.insertID();
            Doctor doctor = HospatilManager.findDoctorById(id);
            if (doctor == null) {
                System.out.println("doctor is not exist!");
                return;
            }
            System.out.println("==== [ doctor Exist complete ] ====");

            //  لان عند استخدام كلاس ال create لا يتحقق من الايدي
            HospatilManager.editDoctor(id,_create.createDoctorInstance());
        }
        ));
        myService.add(new KeyValue("Show Doctor", () -> 
        {
            int id =_create.insertID();
            Doctor doctor = HospatilManager.findDoctorById(id);
            if (doctor == null) {
                System.out.println("doctor is not exist!");
                return;
            }
            HospatilManager.showDoctor(doctor);
        }
        ));
        myService.add(new KeyValue("List All Doctors", () -> {
            HospatilManager.listAllDoctors();
        }));
        myService.add(new KeyValue("List Patients by doctor", () -> 
        {
            int id =_create.insertID();
            Doctor doctor = HospatilManager.findDoctorById(id);
            if (doctor == null) {
                System.out.println("doctor is not exist!");
                return;
            }
            doctor.printpatientList();
        }
        ));
        myService.add(new KeyValue("Generate fake Doctors", () -> {
            _generateMe.generatorDoctors(_create.insertCount("Doctors"));
        }));

        //-----------------[ Doctor End ]-----------------------

        //----------------[ Patient Starting ]------------------
        myService.add(new KeyValue("Add Patient", () -> 
            HospatilManager.addPatient( _create.createPatientInstance())
        ));
        myService.add(new KeyValue("Remove Patient", () -> 
        HospatilManager.removePatientByID( _create.insertID())
        ));
        myService.add(new KeyValue("Edit Patient", () -> 
        {
            int id =_create.insertID();
            Patient patient = HospatilManager.findPatientById(id);
            if (patient == null) {
                System.out.println("Patient is not exist!");
                return;
            }
            System.out.println("==== [ Patient Exist complete... ] ====");

            //  لان عند استخدام كلاس ال create لا يتحقق من الايدي
            HospatilManager.editPatient(id, _create.createPatientInstance());
        }
        ));
        myService.add(new KeyValue("Show Patient", () -> 
        {
            int id =_create.insertID();
            Patient patient = HospatilManager.findPatientById(id);
            if (patient == null) {
                System.out.println("Patient is not exist!");
                return;
            }
            HospatilManager.showPatient(patient);
        }
        ));
        myService.add(new KeyValue("List All Patients", () -> {
            HospatilManager.listAllPatient();
        }));
        myService.add(new KeyValue("List doctors by Patient", () -> 
        {
            int id =_create.insertID();
            Patient patient = HospatilManager.findPatientById(id);
            if (patient == null) {
                System.out.println("Patient is not exist!");
                return;
            }
            patient.printpatientList();
        }
        ));
        myService.add(new KeyValue("Generate fake Patient", () -> {
            _generateMe.generatorPatients(_create.insertCount("Patient"));
        }));
        //------------------------
        myService.add(new KeyValue("Make Appointment", () -> makeAppointment()));
        myService.add(new KeyValue("cls", () -> clear()));
        
    }

    @SuppressWarnings("resource")
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in Hospatil System");
        System.out.println("======== [  Power By zakria nasser zekri ] =======");
        System.out.println("Enter Your input");
        String input;
        do {
            System.out.print("> ");
            input = scanner.nextLine();
            this.cliHandler(input);
        } while (!input.equals("exit"));
    }

    public void HandleArgs(String input) {
        cliHandler(input);
    }

    private void cliHandler(String data) {
        if (data.isEmpty()) {
            return;
        }

         data = data.toLowerCase();
        boolean found = false;

        for (KeyValue service : myService) {
     
            if (service.getKey().toLowerCase().equals(data)) {
                service.getValue().run();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid command, Enter 'help' or 'h' for a list of commands");
        }
    }

    private void help() {
        for (KeyValue service : myService) {
        System.out.println("[*] "+service.getKey()); // done
        }
    }
    
    private boolean askme(String msg) {
        String value;
        @SuppressWarnings("resource")
        Scanner _scn = new Scanner(System.in);
        do {
            System.out.print(msg + " (Y/n) : ");
            value = _scn.nextLine().toLowerCase();
            if (value.equals("no") || value.equals("n")) {
                return false;
            }
        } while (!value.equals("yes") && !value.equals("y") && !value.equals("no") && !value.equals("n"));
    
        return value.equals("yes") || value.equals("y"); // => النتيجه بتطلع boolean
    }

    private void makeAppointment() {
        if (askme("Do you need to add a new patient?")) {
            cliHandler("Add Patient");
        }
        clear();
        cliHandler("list all Patients");
        int patientId = _create.insertID("Patient");
        
        if (HospatilManager.findPatientById(patientId) == null) {
            System.out.println("Patient does not exist!");
            return;
        }
        clear();
        cliHandler("list all doctors");
        int doctorId = _create.insertID("Doctor");
        clear();
        if (HospatilManager.findDoctorById(doctorId) == null) {
            System.out.println("Doctor does not exist!");
            return;
        }
        
        Date appointmentDate = _create.insertDate("Enter the Appointment Date");
        
        HospatilManager.makeAppointment(doctorId, patientId, appointmentDate);
    }

    private void clear() {
        for (int i = 0; i < 45; ++i) {
            System.out.println();
        }
    }
}
