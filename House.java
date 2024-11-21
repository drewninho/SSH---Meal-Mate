import java.util.List;
import java.util.ArrayList;
import StudentInfo.java;



public class House{
    
    List<StudentInfo> studentList = new ArrayList<>();
    int numStudents = studentList.size();
    int totaldeliveryfee = 10;
    int activeStudents = 0;
    int total = 0;
    String address = "Computer Science Building, University of Birmingham, Edgbaston, Birmingham, B15 2TT";

    public int get_subtotal(){
        this.total = 0;
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            this.total += current.basket_total();
        }
        return total;
    }
    
    public int get_total(){
        this.total = 0;
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            this.total += current.basket_total();
        }
        this.total += this.totaldeliveryFee;
        return total;
    }


    public void update_all_delivery(){
        this.activeStudents = 0;
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            if (current.active){
                this.activeStudents += 1;
            }
        }
        for (int x = 0; x < this.studentList.size(); x++){
            StudentInfo current = this.studentList.get(x);
            if (current.active){
                current.deliveryfee = totaldeliveryfee/activeStudents;
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
    public String add_student(String name, int ID, int age, String paymentInfo){
        StudentInfo newStudent = new StudentInfo(name,ID,age,paymentInfo);
        this.studentList.set(numStudents++,newStudent);
    }
}
