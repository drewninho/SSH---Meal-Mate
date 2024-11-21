import java.util.List;
import java.util.ArrayList;

public class StudentInfo {
    private String name;
    private int studentId;
    private String address;
    private String paymentInfo;
    private int age;
    private ArrayList<String> basket;

    public StudentInfo(String name, int studentId, String address, String paymentInfo, int age) {
        this.name = name;
        this.studentId = studentId;
        this.address = address;
        this.paymentInfo = paymentInfo;
        this.age = age;
        //this.basket = new ArrayList<>();
    }

    public void addProduct(String product) {
        basket.add(product);
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

    public String getAddress() {
        return address;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public int getAge() {
        return age;
    }
}
