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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {
    private Login loginSystem;

    @Before
    public void setUp() {
        loginSystem = new Login();
    }

    @Test
    public void testCheckUserName_Valid() {
        assertTrue(loginSystem.checkUserName("user_name"));
    }

    @Test
    public void testCheckUserName_Invalid_NoUnderscore() {
        assertFalse(loginSystem.checkUserName("username"));
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse(loginSystem.checkUserName("user_name_long"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(loginSystem.checkPasswordComplexity("Password1!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_TooShort() {
        assertFalse(loginSystem.checkPasswordComplexity("Pass1!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoUpperCase() {
        assertFalse(loginSystem.checkPasswordComplexity("password1!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoDigit() {
        assertFalse(loginSystem.checkPasswordComplexity("Password!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoSpecialChar() {
        assertFalse(loginSystem.checkPasswordComplexity("Password1"));
    }

    @Test
    public void testRegisterUser_Valid() {
        String result = loginSystem.registerUser("user_name", "Password1!", "John", "Doe");
        assertEquals("User successfully registered!", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String result = loginSystem.registerUser("username", "Password1!", "John", "Doe");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        String result = loginSystem.registerUser("user_name", "pass", "John", "Doe");
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", result);
    }

    @Test
    public void testLoginUser_Valid() {
        loginSystem.registerUser("user_name", "Password1!", "John", "Doe");
        boolean result = loginSystem.loginUser("user_name", "Password1!");
        assertTrue(result);
    }

    @Test
    public void testLoginUser_InvalidUsername() {
        loginSystem.registerUser("user_name", "Password1!", "John", "Doe");
        boolean result = loginSystem.loginUser("wrong_username", "Password1!");
        assertFalse(result);
    }

    @Test
    public void testLoginUser_InvalidPassword() {
        loginSystem.registerUser("user_name", "Password1!", "John", "Doe");
        boolean result = loginSystem.loginUser("user_name", "wrong_password");
        assertFalse(result);
    }
}