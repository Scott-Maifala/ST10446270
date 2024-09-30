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
import java.util.regex.Matcher;

public class Loginsystem {
    public static void main(String[] args) {
        String name;
        String password;
        Scanner input = new Scanner(System.in);
        
        //prompt user to  Input: First name and last name
        System.out.print("Enter First Name: ");
        name = input.nextLine();
        System.out.print("Enter Last Name: ");
        name = input.nextLine();
        
        // Input: Username
        System.out.print("Enter Username: ");
        name = input.nextLine();
        
        // Validate Username
        if (isValidUsername(name)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }

        // Input: Password
        System.out.print("Enter Password: ");
        password = input.nextLine();
        
        // Validate Password
        if (isValidPassword(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }
    }
    
    // Method to validate username
    public static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }
    
    // Method to validate password
    public static boolean isValidPassword(String password) {
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }
        
        // Check if the password contains at least one capital letter
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.find()) {
            return false;
        }
        
        // Check if the password contains at least one number
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            return false;
        }
        
        // Check if the password contains at least one special character
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            return false;
        }
        
        return true;
    }
}