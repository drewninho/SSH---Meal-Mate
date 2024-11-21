import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<String> products;
    private StudentInfo student;
    private double deliveryFee;
    private boolean ordering;

    
    public Basket(StudentInfo student) {
        this.student = student;
        this.products = new ArrayList<>();
        this.ordering = true;
        this.deliveryFee = 0;
    }

  
    public void addProduct(String product) {
        products.add(product);
    }

  
    public void removeProduct(String product) {
        products.remove(product);
    }

    
    public double getBasketTotal() {
        return products.size() 
    }

    public List<String> getProducts() {
        return new ArrayList<>(products);
    }

    
    public void setDeliveryFee(double fee) {
        this.deliveryFee = fee;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setordering(boolean ordering) {
        this.ordering = ordering;
    }

    public boolean isordering() {
        return active;
    }

    public StudentInfo getStudent() {
        return student;
    }
}
