/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_regandlogin;

import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author Mmakwena Masenya
 */
public class POE_RegAndLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();


       System.out.println("Welcome to Rosebank College Registration System!");
        System.out.println("1. Create an account");
        System.out.println("2. Login");


       int choice = scanner.nextInt();
        scanner.nextLine(); 


       if (choice == 1) {
            String username = login.promptUsername(scanner);
            String password = login.promptPassword(scanner);
            String firstName = login.promptFirstName(scanner);
            String lastName = login.promptLastName(scanner);


           String registrationResult = login.registerUser(username, password, firstName, lastName);
            System.out.println(registrationResult);
            
            if (registrationResult.equals("User registered successfully.")) {
                // Prompt for login after successful registration
                System.out.println("Please enter your credentials to log in:");
                String loginUsername = login.promptUsername(scanner);
                String loginPassword = login.promptPassword(scanner);
                boolean loginStatus = login.loginUser(loginUsername, loginPassword);
                if (loginStatus) {
                    User user = new User(username, password, firstName, lastName);
                    System.out.println(login.returnLoginStatus(true, user));
                } else {
                    System.out.println(login.returnLoginStatus(false, null));
                }
            }
        } else if (choice == 2) {
            String username = login.getStoredUsername(); // Retrieve stored username
            String password = login.getStoredPassword(); // Retrieve stored password


           if (username == null || password == null) {
                System.out.println("No user registered. Please register first.");


               // Prompt user to register
                username = login.promptUsername(scanner);
                password = login.promptPassword(scanner);
                String firstName = login.promptFirstName(scanner);
                String lastName = login.promptLastName(scanner);


               String registrationResult = login.registerUser(username, password, firstName, lastName);
                System.out.println(registrationResult);


               if (registrationResult.equals("User registered successfully.")) {
                    // Prompt for login after successful registration
                    System.out.println("Please enter your credentials to log in:");
                    String loginUsername = login.promptUsername(scanner);
                    String loginPassword = login.promptPassword(scanner);
                    boolean loginStatus = login.loginUser(loginUsername, loginPassword);
                    if (loginStatus) {
                        User user = new User(username, password, firstName, lastName);
                        System.out.println(login.returnLoginStatus(true, user));
                    } else {
                        System.out.println(login.returnLoginStatus(false, null));
                    }
                }
            } else {
                boolean loginStatus = false;
                while (!loginStatus) {
                    String enteredUsername = login.promptUsername(scanner);
                    String enteredPassword = login.promptPassword(scanner);
                    loginStatus = login.loginUser(enteredUsername, enteredPassword);
                    if (loginStatus) {
                        User user = new User(username, password, "Mmakwena", "Masenya"); 
                        System.out.println(login.returnLoginStatus(true, user));
                    } else {
                        System.out.println(login.returnLoginStatus(false, null));
                    }
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }


       scanner.close();
    }
}