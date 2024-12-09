package SEPP;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import java.util.*;

public class Cart {
    private Map<productclass, Integer> cartitems;
    
    public Cart() {
        this.cartitems = new HashMap<>();
    }
    

    public void addtocart(productclass product, int quantity){
        //initiallize the adding product into the cart
        if (product.getquantity() >= quantity){
            cartitems.put(product, cartitems.getOrDefault(product, 0) + quantity);
            product.reducequantity(quantity);
            System.out.println(quantity + " " + product.getname() + "(s) added to cart.");
        } else {
            System.out.println("Insufficient stock for " + product.getname());
        }
    }
    public void removefromcart(productclass product, int quantity){
        if (cartitems.containsKey(product)) {
            int currentquantity = cartitems.get(product);
            
            if (quantity >= currentquantity){
                cartitems.remove(product);
                System.out.println("Removed " + product.getname() + " completely from the cart.");
                product.reducequantity(-currentquantity); // Add back the stock to the product
            } else {
                // If the quantity to remove is less than the cart quantity, just reduce the quantity
                cartitems.put(product, currentquantity - quantity);
                product.reducequantity(-quantity); // Add back the removed quantity to the product's stock
                System.out.println("Removed " + quantity + " " + product.getname() + "(s) from the cart.");
            }
        } else {
            System.out.println("Product not found in the cart.");
        }
    }
            
    public void viewcart() {
        if (cartitems.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }
        System.out.println("\nCart items");
        double total = 0;
        //To register the items selected into the cart 
        for (Map.Entry<productclass, Integer> entry : cartitems.entrySet()) {
            productclass product = entry.getKey();
            int quantity = entry.getValue();
            double cost = product.getprice() * quantity;
            total += cost;
            
            System.out.printf("%s  Quantity: %d - Price: $%.2f - Total: $%.2f%n", product.getname(), quantity, product.getprice(), cost);
        }
        
        System.out.println("Total Price: $" + String.format("%.2f", total));
    }
    
    public double calculatecost(){
        double total = 0;
        for (Map.Entry<productclass, Integer> entry : cartitems.entrySet()){
        productclass product = entry.getKey();
        int quantity = entry.getValue();
        total += product.getprice() * quantity;
      } 
        return total;
    }
   
    public void clearcart(){
        cartitems.clear();
    }
    public boolean cartactivity(){
        if (cartitems.isEmpty()) {
            return false;
        }
        return true;
    }
    public Map<productclass,Integer> getCart(){
        return cartitems;
    }
}
