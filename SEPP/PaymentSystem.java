package SEPP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;

public class PaymentSystem {
    private class Order {
        LocalDateTime orderDate;
        List<String> products;
        double totalCost;
        double deliveryFee;
        
        Order(List<String> products, double totalCost, double deliveryFee) {
            this.orderDate = LocalDateTime.now();
            this.products = new ArrayList<>(products);
            this.totalCost = totalCost;
            this.deliveryFee = deliveryFee;
        }
    }

    private HashMap<StudentInfo, List<Order>> orderHistory;
    private HashMap<StudentInfo, Double> weeklyBudgets;
    private HashMap<StudentInfo, Double> weeklySpending;
    private House house;
    
    public PaymentSystem(House house) {
        this.house = house;
        this.orderHistory = new HashMap<>();
        this.weeklyBudgets = new HashMap<>();
        this.weeklySpending = new HashMap<>();
    }

    public void setWeeklyBudget(StudentInfo student, double budget) {
        weeklyBudgets.put(student, budget);
        weeklySpending.putIfAbsent(student, 0.0);
    }

    public boolean placeOrder(StudentInfo student, String password) {
        if (!verifyPassword(student, password)) {
            return false;
        }

        Basket basket = getStudentBasket(student);
        if (basket == null || !basket.isActive()) {
            return false;
        }

        double orderTotal = calculateOrderTotal(basket);
        
        
        if (exceedsBudget(student, orderTotal)) {
            return false;
        }

        
        updateWeeklySpending(student, orderTotal);
        
        
        Order newOrder = new Order(
            basket.getProducts(),
            orderTotal,
            basket.getDeliveryFee()
        );
        
        orderHistory.putIfAbsent(student, new ArrayList<>());
        orderHistory.get(student).add(newOrder);
        
      
        basket.getProducts().clear();
        
        return true;
    }

    private boolean exceedsBudget(StudentInfo student, double orderTotal) {
        Double budget = weeklyBudgets.get(student);
        if (budget == null) return false; // No budget set
        
        Double currentSpending = weeklySpending.get(student);
        return (currentSpending + orderTotal) > budget;
    }

    private void updateWeeklySpending(StudentInfo student, double amount) {
        Double current = weeklySpending.getOrDefault(student, 0.0);
        weeklySpending.put(student, current + amount);
    }

    public void resetWeeklySpending() {
        weeklySpending.clear();
    }

    public List<Order> getOrderHistory(StudentInfo student) {
        return orderHistory.getOrDefault(student, new ArrayList<>());
    }

    public double getWeeklyBudget(StudentInfo student) {
        return weeklyBudgets.getOrDefault(student, 0.0);
    }

    public double getCurrentSpending(StudentInfo student) {
        return weeklySpending.getOrDefault(student, 0.0);
    }

    private double calculateOrderTotal(Basket basket) {
        return basket.getBasketTotal() + basket.getDeliveryFee();
    }

    private boolean verifyPassword(StudentInfo student, String password) {
        return password != null && !password.isEmpty();
    }

    private Basket getStudentBasket(StudentInfo student) {
        // how would we store baskets in the system?
        
        return null; 
    }

    //  view recent orders
    public String viewRecentOrders(StudentInfo student) {
        List<Order> orders = orderHistory.get(student);
        if (orders == null || orders.isEmpty()) {
            return "No order history found.";
        }

        StringBuilder history = new StringBuilder("Order History:\n");
        for (Order order : orders) {
            history.append("Date: ").append(order.orderDate)
                  .append("\nItems: ").append(order.products)
                  .append("\nTotal: £").append(order.totalCost)
                  .append("\nDelivery Fee: £").append(order.deliveryFee)
                  .append("\n-----------------\n");
        }
        return history.toString();
    }
}


/*  This is how you can implement the payment system in java fx

PaymentSystem paymentSystem = new PaymentSystem(house);

// Set a weekly budget
paymentSystem.setWeeklyBudget(student, 100.0);

// Place an order
boolean success = paymentSystem.placeOrder(student, "password123");

// View order history
String history = paymentSystem.viewRecentOrders(student);

// Check current spending
double spent = paymentSystem.getCurrentSpending(student);

*/
