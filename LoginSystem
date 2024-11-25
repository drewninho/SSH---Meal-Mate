import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    private ArrayList<StudentInfo> students;

    public LoginSystem() {
        students = new ArrayList<>();
    }

    public void registerStudent() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("\n--- Student Registration ---");

        System.out.print("Enter your name: ");
        String name = scnr.nextLine();

        System.out.print("Enter your age: ");
        int age = scnr.nextInt();
        scnr.nextLine();

        System.out.print("Enter your student ID: ");
        int studentId = scnr.nextInt();
        scnr.nextLine(); 

        System.out.print("Enter your address: ");
        String address = scnr.nextLine();

        System.out.print("Enter your payment info: ");
        String paymentInfo = scnr.nextLine();

        for (StudentInfo student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("A student with this ID already exists.");
                return;
            }
        }

        StudentInfo newStudent = new StudentInfo(name, studentId, address, paymentInfo, age);
        students.add(newStudent);

        System.out.println("Registration successful! Welcome, " + name);
    }

    public StudentInfo loginStudent() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("\n--- Student Login ---");

        System.out.print("Enter your student ID: ");
        int studentId = scnr.nextInt();
        scnr.nextLine(); 

        for (StudentInfo student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println("Login successful! Welcome, " + student.getName());
                return student;
            }
        }

        System.out.println("Student ID not found. Please register first.");
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }

        System.out.println("\n--- Registered Students ---");
        for (StudentInfo student : students) {
            System.out.println("Name: " + student.getName() + ", ID: " + student.getStudentId());
        }
    }
}
