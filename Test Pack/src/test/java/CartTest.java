import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import SEPP.Cart;
import SEPP.productclass;


class CartTest {
    @Test
    void testAddingItems(){
        productclass item = new productclass ("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
        Cart Basket = new Cart(); Basket.addtocart(item, 5);
        Map<productclass, Integer> cartMap = Basket.getCart(); 
        
        assert(cartMap.containsKey(item));
        assertEquals(5,cartMap.get(item));
    }

    @Test
    void testRemoveFromCart(){
        productclass item = new productclass ("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
        Cart Basket = new Cart(); Basket.addtocart(item, 5);
        Basket.removefromcart(item, 2);
        Map<productclass, Integer> cartMap = Basket.getCart(); 

        assertEquals(3,cartMap.get(item));
    }
    @Test
    void testCalculateTotal(){
        productclass item = new productclass ("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
        Cart Basket = new Cart(); Basket.addtocart(item, 5);
        assertEquals(1.2*5, Basket.calculatecost());
    }
    @Test
    void testClearCart(){
        productclass item = new productclass ("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
        Cart Basket = new Cart(); Basket.addtocart(item, 5); Basket.clearcart();
        assert(Basket.getCart().isEmpty());
    } 
    @Test
    void testCartActivity(){
        productclass item = new productclass ("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber"));
        Cart Basket = new Cart();
        assertEquals(false,Basket.cartactivity());
        Basket.addtocart(item, 5); 
        assertEquals(true,Basket.cartactivity());
    }
}
