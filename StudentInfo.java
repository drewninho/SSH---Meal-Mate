package SEPP; 
import java.util.ArrayList;

public class StudentInfo {
    private String name;
    private int studentId;
    private String paymentInfo;
    private int age;
    private cart basket;
    private double deliveryFee = 0.00;

    public StudentInfo(String name, int studentId, String paymentInfo, int age) {
        this.name = name;
        this.studentId = studentId;
        this.paymentInfo = paymentInfo;
        this.age = age;
        this.basket = new cart();
    }

    public void addProduct(productclass item, int quantity) {
        basket.addtocart(item , quantity);
    }

    /*public String viewBasket() {
        if (basket.isEmpty()) {
            return "Your basket is empty.";
        }
        return "Products in your basket: " + String.join(", ", basket);
    } */

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public int getAge() {
        return age;
    }
    public double getSubtotal() {
        return this.basket.calculatecost();
    }
    public boolean getActivity(){
        return (basket.cartactivity());
    }
    public void setDeliveryFee(double fee){
        this.deliveryFee = fee;
    }
    public double getTotal(){
        return this.basket.calculatecost() + this.deliveryFee;
    }
    
}
