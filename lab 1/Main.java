import java.util.ArrayList;
import java.util.Arrays;

class Doctor {
    private String firstName;
    private String lastName;
    private String specialization;

    public Doctor(String firstName, String lastName, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String displayInfo() {
        return firstName + " " + lastName + " (" + specialization + ")";
    }
}

class Patient {
    private String firstName;
    private String lastName;
    private ArrayList<String> illnesses;
    private Doctor doctor;

    public Patient(String firstName, String lastName, ArrayList<String> illnesses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.illnesses = illnesses;
    }

    public void assignDoctor(ArrayList<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            for (String illness : illnesses) {
                if (doctor.getSpecialization().equals(illness)) {
                    this.doctor = doctor;
                    return;
                }
            }
        }
    }

    public void displayInfo() {
        System.out.println("Pacient: " + firstName + " " + lastName);
        System.out.println("Boli: " + Arrays.toString(illnesses.toArray()));
    }

    public void displayDoctor() {
        System.out.println(firstName + " " + lastName + " este tratat de " + doctor.displayInfo());
    }
}

class PersonalMedical {
    private ArrayList<Doctor> doctors;
    private ArrayList<String> nurses;

    public PersonalMedical(ArrayList<Doctor> doctors, ArrayList<String> nurses) {
        this.doctors = doctors;
        this.nurses = nurses;
    }

    public void displayInfo() {
        System.out.println("Doctori: ");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.displayInfo());
        }

        System.out.println("Asistente: ");
        for (String nurse : nurses) {
            System.out.println("- " + nurse);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("Alex", "Ionascu", "Heart");
        Doctor doctor2 = new Doctor("Cristi", "Groza", "Lung");

        ArrayList<Doctor> doctors = new ArrayList<>(Arrays.asList(doctor1, doctor2));
        ArrayList<String> nurses = new ArrayList<>(Arrays.asList("Ana", "Maria", "George"));

        PersonalMedical hospitalStaff = new PersonalMedical(doctors, nurses);
        hospitalStaff.displayInfo();

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Ion", "Ionescu", new ArrayList<>(Arrays.asList("Heart"))));
        patients.add(new Patient("Radu", "Radulescu", new ArrayList<>(Arrays.asList("Lung"))));
        patients.add(new Patient("Robert", "Manu", new ArrayList<>(Arrays.asList("Heart", "Lung"))));

        for (Patient patient : patients) {
            patient.assignDoctor(doctors);
            patient.displayInfo();
            patient.displayDoctor();
            System.out.println();
        }
    }
}
