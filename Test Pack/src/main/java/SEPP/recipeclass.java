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

public class recipeclass { 
    private final String name;
    private final List<String> ingredients;

    public recipeclass(String name, List<String> ingredients){
        this.name = name;
        this.ingredients = ingredients;
    }
    //here to get recipe of its ingredient, this is linked to the product class
    public boolean getrecipe (List<productclass> product){
        for (String ingredient : ingredients) { 
            //the ingredient will match the product, letter casing does not matter here
            boolean found = product.stream().anyMatch(p -> p.getname().equalsIgnoreCase(ingredient));
            if (!found) return false;
        } 
        return true;
    }
    
    public void displayrecipe(){
        System.out.println("Recipe :" + name);
        System.out.println("Ingredients : " + String.join(", " , ingredients));
    }
}
