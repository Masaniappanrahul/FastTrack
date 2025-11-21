import java.util.*;

class Person {
    private String name;
    private int age;
    Person(String name, int age){ this.name = name; this.age = age; }
    public void display(){ System.out.println("Name: " + name + " | Age: " + age); }
}

class Doctor extends Person {
    private String spec;
    Doctor(String n, int a, String s){ super(n,a); this.spec = s; }
    @Override public void display(){ super.display(); System.out.println("Specialization: " + spec); }
}

class Patient extends Person {
    private String disease;
    Patient(String n, int a, String d){ super(n,a); this.disease = d; }
    @Override public void display(){ super.display(); System.out.println("Disease: " + disease); }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();
        int choice = 0;

        while (choice != 4) {
            try {
                System.out.println("\n1. Add Doctor\n2. Add Patient\n3. Show Records\n4. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt(); sc.nextLine();

                if (choice == 1) {
                    System.out.print("Doctor Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Specialization: "); String spec = sc.nextLine();
                    list.add(new Doctor(name, age, spec));
                }
                else if (choice == 2) {
                    System.out.print("Patient Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Disease: "); String dis = sc.nextLine();
                    list.add(new Patient(name, age, dis));
                }
                else if (choice == 3) {
                    if (list.isEmpty()) System.out.println("No records found.");
                    else for (Person p : list) p.display();
                }
                else if (choice != 4) System.out.println("Invalid choice!");

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter numbers only!");
                sc.nextLine();
            }
        }
        System.out.println("System Closed.");
    
    }
}
