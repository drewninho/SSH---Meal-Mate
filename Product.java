/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SEPP;

/**
 *
 * @author User
 */
import java.util.*;

public class SEPP {
    private static List<productclass> product = new ArrayList<>();
    private static List<recipeclass> recipe = new ArrayList<>();
    //private static cart Cart = new cart();
    
    public static void main (String[] args){
        initializeData();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. View Products");
            System.out.println("2. View Recipes");
            System.out.println("3. Check Product Stock");
            System.out.println("4. Suggest Recipe");
            //System.out.println("5. Add to Cart");
            //System.out.println("6. View Cart");
            //System.out.println("7. Proceed to Payment");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> viewproducts();
                case 2 -> viewrecipe();
                case 3 -> checkproductstock(scanner);
                case 4 -> suggestrecipe();
                //case 5 -> addtocart(scanner);
                //case 6 -> Cart.viewcart();
                //case 7 -> payment(scanner);
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choices");
            }
        }
        
    }
    
    private static void initializeData() { 
    //Add our list of products here
    product.add(new productclass ("Apple", 132, 1.2, "10 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber")));
    product.add(new productclass ("Milk", 143, 4.99, "25 - 12 - 2024", 10, Arrays.asList("Calcium", "Protein")));
    product.add(new productclass ("Egg", 321, 3.99, "20 - 12 - 2024", 10, Arrays.asList("Protien", "Vitamin D")));
    product.add(new productclass ("Rice", 231, 2.00, "20 - 12 - 2024", 10, Arrays.asList("Carbohydrates", "Fiber")));
    product.add(new productclass ("Meat", 546, 5.99, "14 - 12 - 2024", 10, Arrays.asList("Protein", "Fiber")));
    product.add(new productclass ("Vegetables",785, 3.69, "17 - 12 - 2024", 10, Arrays.asList("Vitamin C", "Fiber")));
    product.add(new productclass ("Beverages", 671, 2.99, "19 - 12 - 2024", 10, Arrays.asList("Sugar", "Vitamins")));
    
    //Add our list of recipe here
    recipe.add(new recipeclass ("Fruit Salad", Arrays.asList("Apple")));
    recipe.add(new recipeclass ("Omelette", Arrays.asList("Milk", "Egg")));
    recipe.add(new recipeclass ("Fried Rice", Arrays.asList("Egg", "Rice", "Vegetables")));
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
}    
    
