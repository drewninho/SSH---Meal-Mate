
import SEPP.*;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StudentInfoTest {
    private productclass item = new productclass("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
    private StudentInfo studentInit = new StudentInfo("BOB", 68797, "5813 7790 9177 7731", 15);
    @Test
    void testAddAndRemoveProduct() {
        studentInit.addProduct(item, 5);
        assert(studentInit.getActivity());
        studentInit.removeProduct(item, 5);
        assertEquals(false, studentInit.getActivity());
    }
    

    @Test
    void testGetAge() {
        assertEquals(15, studentInit.getAge());
    }

    @Test
    void testGetName() {
        assertEquals("BOB",studentInit.getName());
    }

    @Test
    void testGetPaymentInfo() {
        assertEquals("5813 7790 9177 7731",studentInit.getPaymentInfo());
    }

    @Test
    void testGetStudentId() {
        assertEquals(68797,studentInit.getStudentId());
    }

    @Test
    void testGetSubtotal() {
        studentInit.addProduct(item, 5);
        assert(1.20*5.00 == studentInit.getSubtotal());
    }

    @Test
    void testGetTotal() {
        studentInit.setDeliveryFee(10.50);
        studentInit.addProduct(item, 5);
        assert( 1.20*5.00 + 10.5 == studentInit.getTotal());
    }
}
