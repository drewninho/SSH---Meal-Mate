/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SEPP;

/**
 *
 * @author User
 */
import java.util.*;

public class productclass {
    private final String name;
    private final int productID;
    private final double price;
    private final String expiryDate;
    private int quantity;
    private final List<String> nutrients;

    public productclass (String name, int productID, double price, String expiryDate, int quantity, List<String> nutrients){
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.nutrients = nutrients;
    }

    public String getname(){
        return name;
    }

    public int getproductID(){
        return productID;
    }
    
    public double getprice(){
        return price;
    }
    
    public String getexpiryDate(){
        return expiryDate;
    }
    
    public int getquantity(){
        return quantity;
    }
    
    public List<String> getnutrients(){
        return nutrients;
    }

    public void reducequantity (int amount){
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            System.out.println("Insufficient quantity of product");
        }
    }

    public void displayproduct(){
        System.out.println("Name: " + name);
        System.out.println("Price: $ " + price);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Quantity: " + quantity);
        System.out.println("Nutrients: " + String.join(", " , nutrients));
    }
}

