package SEPP;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.List;
import java.util.ArrayList;

public class House{
    private List<StudentInfo> studentList;
    private int numStudents;
    private double totaldeliveryfee;
    private int activeStudents;
    private double total;
    private String address;
    
    public House(String Address){
        this.studentList = new ArrayList<>();
        this.numStudents = studentList.size();
        this.totaldeliveryfee = 10;
        this.activeStudents = 0;
        this.total = 0.0;
        this.address = Address;
    }
    
    public double get_subtotal(){
        this.total = 0.0;
        for (int x = 0; x < this.numStudents; x++){
            System.out.println(studentList.get(x).getSubtotal());
            this.total += studentList.get(x).getSubtotal();
        }
        return this.total;
    }
    
    public double get_total(){
        this.total = 0;
        for (int x = 0; x < this.numStudents; x++){
            StudentInfo current = this.studentList.get(x);
            this.total += current.getSubtotal();
        }
        this.total += totaldeliveryfee;
        return total;
    }


    public void update_all_delivery(){
        this.activeStudents = 0;
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            if (current.getActivity()){
                this.activeStudents += 1;
            }
        }
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            if (current.getActivity()){
                current.setDeliveryFee(totaldeliveryfee/activeStudents);
                this.studentList.set(x,current);
            }
        }
    }

    public void set_address(String newAddress){
        this.address = newAddress;
    }
    public String get_address(){
        return this.address;
    }
    public void add_student(String name, int ID, String paymentInfo,int age){
        if (numStudents < 20){
            StudentInfo newStudent = new StudentInfo(name, ID, paymentInfo, age );
            this.studentList.add(newStudent);
            this.numStudents++;
        }
    }

    public void remove_student(StudentInfo student){
        List<StudentInfo> newList = new ArrayList<>();
        for(StudentInfo x: studentList){
            if (student.getStudentId() != x.getStudentId() && x.getName() != student.getName() && x.getAge() != student.getAge()){
                newList.add(x);
            }
        }
        this.numStudents--;
        this.studentList = newList;
    }

    public List<StudentInfo> getStudentList(){
        return this.studentList;
    }
    public int getStudentNum(){
        System.out.println(this.numStudents);
        return this.numStudents;
    }
    
    public void update_student(StudentInfo student, productclass item, int quantity, String func){
        
        List<StudentInfo> newList = new ArrayList<>();

        for(StudentInfo x: studentList){
            if (student.getStudentId() != x.getStudentId() && x.getName() != student.getName() && x.getAge() != student.getAge()){
                newList.add(x);
            }
            else{ 
                StudentInfo current = x;
                current.addProduct(item, quantity);
                newList.add(current);

            }
        }

        this.studentList = newList;

    } 

    public StudentInfo getStudent(int id){
        StudentInfo Student = new StudentInfo("", 0, "", 0);
        for (StudentInfo x: studentList){
            if (x.getStudentId() == id){
                return Student;

            }   
        }
        
        return null;
    }
    
}
