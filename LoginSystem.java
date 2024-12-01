/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEPP;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginSystem {
    private ArrayList<StudentInfo> students;

    public LoginSystem() {
        students = new ArrayList<>();
    }

    public List<House> registerStudent(List<House> houses, Scanner scnr) {
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
                    return houses;
                }
            }
            //Check if the house exists, add if not hence the "null"
            House house = null;
            for(House h : houses){
                if (address.equalsIgnoreCase(h.get_address())){
                    house = h;
                    break;
                }
            }
            
            if (house == null && houses.size() < 200){
                System.out.println("Adding new house...");
                house = new House(address);
                houses.add(house);
            }
            //Add student to the house after register, hence you are able to login 
            if (house != null){
                house.add_student(name, age, paymentInfo, age);
                students.add(new StudentInfo(name, studentId, paymentInfo, age));
                System.out.println("Registration Complete, Welcome " + name);
            } else {
                System.out.println("Failed to register");
            }
            
             return houses;
    }

    public StudentInfo loginStudent(Scanner scnr) {
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
