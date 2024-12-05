/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

import SEPP.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        //login $ register part
        LoginSystem loginsystem = new LoginSystem();
        ArrayList<House> houses = new ArrayList<>();
        Scanner scan = new Scanner(System.in); 
        //Into the grocery app
        Grocery app = new Grocery();
        
        while (true){
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            
            System.out.println("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            
            //If no account, register first then check if its reigstration is on display
            //If registered account is displayed, please login to use the app
            switch (choice){
                case 1:
                    houses = (ArrayList<House>) loginsystem.registerStudent(houses, scan);
                    break;
                case 2:
                    loginsystem.loginStudent(scan);
                    app.run(scan);
                    break;
                case 3:
                    loginsystem.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");   
                    return;
            }
        }
    }
}

