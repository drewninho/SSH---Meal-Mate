/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEPP;

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
        this.total = 0;
        this.address = Address;
    }
    
    public double get_subtotal(){
        this.total = 0;
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            this.total += current.getTotal();
        }
        return total;
    }
    
    public double get_total(){
        this.total = 0;
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            this.total += current.getTotal();
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
        StudentInfo newStudent = new StudentInfo(name, ID, paymentInfo, age );
        this.studentList.add(newStudent);
        this.numStudents = studentList.size();
    }
    
}
