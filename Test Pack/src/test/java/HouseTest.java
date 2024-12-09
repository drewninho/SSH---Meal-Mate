import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SEPP.House;
import SEPP.StudentInfo;
import SEPP.productclass;


public class HouseTest {
    private productclass item = new productclass("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
    private House house1 = new House("1 Birmingham New Road, Birmingham, B1 3XS");
    private StudentInfo studentInit = new StudentInfo("BOB", 68797, "5813 7790 9177 7731", 15);

    @Test
    void testAddStudent(){
        List<StudentInfo> studentList;
        assert(this.house1.getStudentList().isEmpty());
        this.house1.add_student("BOB", 68797, "5813 7790 9177 7731", 15);
        studentList = this.house1.getStudentList();
        assert(studentList.isEmpty() == false);
        StudentInfo student1 = studentList.get(0);
        assert(student1.getStudentId() == this.studentInit.getStudentId());
        assert(student1.getName() == this.studentInit.getName());
        assert(student1.getPaymentInfo() == this.studentInit.getPaymentInfo());
        assert(student1.getAge() == this.studentInit.getAge());
    }
    @Test
    void testRemoveStudent(){
        house1.add_student(studentInit.getName(), studentInit.getStudentId(), studentInit.getPaymentInfo(), studentInit.getAge());
        List<StudentInfo> studentList = house1.getStudentList();
        assertEquals(false, studentList.isEmpty());
        house1.remove_student(studentInit);
        studentList = house1.getStudentList();
        assertEquals(true, studentList.isEmpty());
    }

    @Test
    void testSetAndGetAddress(){
        String newAddress = "224 Park Drive Gotham City";
        assertEquals("1 Birmingham New Road, Birmingham, B1 3XS",this.house1.get_address());
        this.house1.set_address(newAddress);
        assertEquals(newAddress, this.house1.get_address());
    }
    @Test
    void testUpdateStudentGetTotalAndSubtotal(){
        House house2 = new House(house1.get_address());
        house2.add_student("BOB",68797, "5813 7790 9177 7731", 15);
        house2.update_student(studentInit, item, 5, null);
        house2.getStudentNum();
        assertEquals(6.0 , house2.get_subtotal());
        assertEquals(16.0, house2.get_total());
    }
    

}
