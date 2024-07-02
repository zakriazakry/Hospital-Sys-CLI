public class GenerateMe {
    public void generatorDoctors(int count) {
        for (int i = 0; i < count; i++) {
            Name name = new Name("dr. Ali" + i);
            String email = "doctor.Ali" + i + "@cli.ly";
            String phone = "0942667816";
            double priceService = i + 30;
            Date birthDate = new Date(19 + i, i % 12, 1);
            Doctor doctor = new Doctor(i, name, email, phone, priceService, birthDate);
            HospatilManager.addDoctor(doctor);
        }
        System.out.println("generated " + count + " Doctor");
    }
    public void generatorPatients(int count) {
        for (int i = 0; i < count; i++) {
            Name name = new Name("dr. Ali" + i);
            String phone = "0942667816";
            Date birthDate = new Date(19 + i, i % 12, 1);
            Patient patient = new Patient(i, name, phone, birthDate);
            HospatilManager.addPatient(patient);
        }
        System.out.println("Generated " + count + " Patient");
    }
}
