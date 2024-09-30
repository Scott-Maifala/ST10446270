/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login_system;

import java.util.Scanner;


/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Account creation
        System.out.println("=== Create Account ===");
        System.out.print("Enter First Name: ");
        String firstName = input.nextLine().trim();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine().trim();

        // Create a Login object for user management
        Login userLogin = new Login();
        userLogin.registerUser(input);

        System.out.println("Account creation successful!");
        System.out.println("Welcome, " + firstName + " " + lastName + "!");

        // Login
        System.out.println("\n=== Login ===");
        if (userLogin.loginUser(input)) {
            System.out.println("Login successful! Welcome back, " + firstName + " " + lastName + "!");
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }

        input.close();
    }
}

class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String loginStatus;

    public void registerUser(Scanner input) {
        // Register username
        String username;
        do {
            System.out.print("Enter Username (must contain an underscore and be no more than 5 characters): ");
            username = input.nextLine().trim();
            if (checkUserName(username)) {
                registeredUsername = username;
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Invalid username. Ensure it contains an underscore and is no more than 5 characters long.");
            }
        } while (true);

        // Register password
        String password;
        do {
            System.out.print("Enter Password (must be at least 8 characters long, contain a capital letter, a number, and a special character): ");
            password = input.nextLine().trim();
            if (checkPasswordComplexity(password)) {
                registeredPassword = password;
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Invalid password. Ensure it meets all criteria.");
            }
        } while (true);
    }

    public boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false;

        if (!Pattern.compile("[0-9]").matcher(password).find()) return false;

        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false;

        return true;
    }

    public boolean loginUser(Scanner input) {
        System.out.print("Enter Username: ");
        String username = input.nextLine().trim();

        System.out.print("Enter Password: ");
        String password = input.nextLine().trim();

        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
            loginStatus = "Login successful";
            return true; // Login successful
        } else {
            loginStatus = "Login failed";
            return false; // Login failed
        }
    }

    public String returnLoginStatus() {
        return loginStatus;
    }
}
