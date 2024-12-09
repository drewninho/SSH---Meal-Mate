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


public class Grocery {
    private static List<productclass> product = new ArrayList<>();
    private static List<recipeclass> recipe = new ArrayList<>();
    private static Cart Cart = new Cart();
    //private static PaymentSystem payment = new PaymentSystem(new House());
    
    public Grocery(){
        initializeData();
    }
    
    public void run(Scanner scanner){    
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. View Products");
            System.out.println("2. View Recipes");
            System.out.println("3. Check Product Stock");
            System.out.println("4. Suggest Recipe");
            System.out.println("5. Add to Cart");
            System.out.println("6. Remove items");
            System.out.println("7. View Cart");
            System.out.println("8. Proceed to Payment");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> viewproducts();
                case 2 -> viewrecipe();
                case 3 -> checkproductstock(scanner);
                case 4 -> suggestrecipe();
                case 5 -> addtocart(scanner);
                case 6 -> removeitems(scanner);
                case 7 -> Cart.viewcart();
                case 8 -> payment(scanner);
                case 9 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choices");
            }
        }
        
    }
    
    private static void initializeData() { 
    //Add our list of products here
    product.add(new productclass("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber")));
    product.add(new productclass("Milk", 143, 4.99, "25 - 12 - 2024", 10, Arrays.asList("Calcium", "Protein")));
    product.add(new productclass("Egg", 321, 3.99, "20 - 12 - 2024", 10, Arrays.asList("Protien", "Vitamin D")));
    product.add(new productclass("Rice", 231, 2.00, "20 - 12 - 2024", 10, Arrays.asList("Carbohydrates", "Fiber")));
    product.add(new productclass("Meat", 546, 5.99, "14 - 12 - 2024", 10, Arrays.asList("Protein", "Fiber")));
    product.add(new productclass("Vegetables",785, 3.69, "17 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber")));
    product.add(new productclass("Beverages", 671, 2.99, "19 - 12 - 2024", 10, Arrays.asList("Sugar", "Vitamins")));
    
    //Add our list of recipe here
    recipe.add(new recipeclass("Fruit Salad", Arrays.asList("Apple")));
    recipe.add(new recipeclass("Omelette", Arrays.asList("Milk", "Egg")));
    recipe.add(new recipeclass("Fried Rice", Arrays.asList("Egg", "Rice", "Vegetables")));
    }
    
    private static void viewproducts(){
        System.out.println("\nProducts: ");
        for (productclass products : product){
            products.displayproduct();   
            System.out.println();
        }
    }
    
    private static void viewrecipe(){
       System.out.println("\nRecipes: ");
       for (recipeclass recipes : recipe){
           recipes.displayrecipe();
           System.out.println();
       }
    }
    
    private static void checkproductstock(Scanner scanner){
        System.out.println("\nEnter product name: ");
        String name = scanner.nextLine();
       
        for (productclass products : product){
            if (products.getname().equalsIgnoreCase(name)){
                System.out.println("Product is avaliable");
                products.displayproduct();
                return;
            } 
        } System.out.println("Product is unavaliable");
    }
    
    private static void suggestrecipe(){
        System.out.println("\nRecipe you can make: ");
        for (recipeclass recipes : recipe) {
            if (recipes.getrecipe(product));
            recipes.displayrecipe();
        } 
    }
    
    private static void addtocart(Scanner scanner){
    System.out.println("\nEnter the product name to add to cart");
    String name = scanner.nextLine();
    boolean found = false;
    
    for (productclass products : product){
        if (products.getname().equalsIgnoreCase(name)){
        System.out.println("Enter quantity");
        int quantity = scanner.nextInt();
        
        Cart.addtocart(products, quantity);
        found = true;
        break; //Exit the loop after adding the product into the cart
    } 
  }
    if (!found){
        System.out.println("Product not found");
    }
}
    
    private static void removeitems(Scanner scanner){
    System.out.println("\nEnter the product name to remove from cart");
    String name = scanner.nextLine();
    boolean found = false;
    
    for (productclass products : product){
        if (products.getname().equalsIgnoreCase(name)){
        System.out.println("Enter quantity");
        int quantity = scanner.nextInt();
        
        Cart.removefromcart(products, quantity);
        found = true;
        break; //Exit the loop after removing the product into the cart
    } 
  }
    if (!found){
        System.out.println("Product not found");
    }
}
        
    private static void payment(Scanner scanner){
    Cart.viewcart();
    double total = Cart.calculatecost();
    
    if (total == 0) {
        System.out.println("Cart is empty, please add some items to it");
}
    System.out.println("Total amount to pay : $" + total);
    System.out.println("Enter the payable amount : ");
    double payments = scanner.nextDouble();
    scanner.nextLine();
    
    if (payments >= total){
        System.out.println("Payment successful");
        Cart.clearcart();
        System.out.println("Thank you for shoppoing with the app");
    } else {
        System.out.println("Insufficient Funds");
   }   
 }
}    
