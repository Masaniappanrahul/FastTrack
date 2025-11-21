import java.util.*;

class Person {
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayInfo(){
        System.out.println("Name: " + name + " | Age: " + age);
    }
}

class Doctor extends Person {
    private String specialization;

    Doctor(String name, int age, String specialization){
        super(name, age);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("---------------------------");
    }
}

class Patient extends Person {
    private String disease;

    Patient(String name, int age, String disease){
        super(name, age);
        this.disease = disease;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Disease: " + disease);
        System.out.println("---------------------------");
    }
}

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> records = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Show All Records");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1){
                System.out.print("Doctor Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt(); sc.nextLine();
                System.out.print("Specialization: ");
                String spec = sc.nextLine();
                records.add(new Doctor(name, age, spec));
            }
            else if (choice == 2){
                System.out.print("Patient Name: ");
                String name = sc.nextLine();
                System.out.print("Age: ");
                int age = sc.nextInt(); sc.nextLine();
                System.out.print("Disease: ");
                String dis = sc.nextLine();
                records.add(new Patient(name, age, dis));
            }
            else if (choice == 3){
                System.out.println("\n----- Records -----");
                for (Person p : records){
                    p.displayInfo();
                }
            }

        } while (choice != 4);

        sc.close();
        System.out.println("System Closed.");
    }
}
