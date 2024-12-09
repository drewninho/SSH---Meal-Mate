
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import SEPP.productclass;

public class productclassTest {
    private productclass item = new productclass("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
    @Test
    void testGetexpiryDate() {
        assertEquals("10 - 12 - 2024", item.getexpiryDate());
    }

    @Test
    void testGetname() {
        assertEquals("Apple", item.getname());
    }

    @Test
    void testGetnutrients() {
        assertEquals(Arrays.asList("Vitamin C", "Fiber"), item.getnutrients());
    }

    @Test
    void testGetprice() {
        assertEquals(1.2,item.getprice());
    }

    @Test
    void testGetproductID() {
        assertEquals(132,item.getproductID());
    }

    @Test
    void testGetquantity() {
        assertEquals(10, item.getquantity());
    }

    @Test
    void testReducequantity() {
        item.reducequantity(5);
        assertEquals(5, item.getquantity());
    }
}
