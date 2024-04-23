/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_regandlogin;

import java.util.Scanner;

/**
 *
 * @author Mmakwena Masenya
 */
class Login {
    private String storedUsername;
    private String storedPassword;


   public void setStoredCredentials(String username, String password) {
        storedUsername = username;
        storedPassword = password;
    }


   public String getStoredUsername() {
        return storedUsername;
    }


   public String getStoredPassword() {
        return storedPassword;
    }


   public boolean checkUserName(String username) {
        return username.matches("^\\w{1,5}$");
    }


   public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }


   public String registerUser(String username, String password, String firstName, String lastName) {
    if (!checkUserName(username)) {
        return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
    } else {       
        System.out.println("Username captured successfully");
    }   
    if (!checkPasswordComplexity(password)) {       
        return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
    } else {     
        System.out.println("Password captured successfully");
        setStoredCredentials(username, password);
        return "User registered successfully.";
    }
}


   public boolean loginUser(String username, String password) {
        if (storedUsername == null || storedPassword == null) {
            return false; 
        }
        return (username.equals(storedUsername) && password.equals(storedPassword));
    }


   public String returnLoginStatus(boolean loginStatus, User user) {
        if (loginStatus) {
            return "Welcome " + user.getFirstName() + " " + user.getLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }


   // Methods for user input
    public String promptUsername(Scanner scanner) {
        System.out.println("Enter username:");
        return scanner.nextLine();
    }


   public String promptPassword(Scanner scanner) {
        System.out.println("Enter password:");
        return scanner.nextLine();
    }


   public String promptFirstName(Scanner scanner) {
        System.out.println("Enter first name:");
        return scanner.nextLine();
    }


   public String promptLastName(Scanner scanner) {
        System.out.println("Enter last name:");
        return scanner.nextLine();
    }
}

