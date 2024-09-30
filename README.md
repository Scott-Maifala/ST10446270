# ST10446270
A World of innovative Java and HTML code
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: First name and last name
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        // Input: Username
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        
        // Validate Username
        if (isValidUsername(username)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }
        
        // Input: Password
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
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
        // Asses if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }
        
        // Asses if the password contains at least one capital letter
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.find()) {
            return false;
        }
        
        // Asses if the password contains at least one number
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            return false;
        }
        
        // Asses if the password contains at least one special character
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            return false;
        }
        
        return true; 
    }
}
