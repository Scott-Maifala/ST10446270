/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TESTloginsystem;

/**
 *
 * @author RC_Student_lab
 */
public class js {
    
}
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {
    private Login login;

    @Before
    public void setUp() {
        login = new Login();
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("user_name"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_NoUnderscore() {
        assertFalse(login.checkUserName("username"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_TooLong() {
        assertFalse(login.checkUserName("user_long"));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Pass123!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_NoUppercase() {
        assertFalse(login.checkPasswordComplexity("pass123!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_NoNumber() {
        assertFalse(login.checkPasswordComplexity("Password!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_NoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password123"));
    }

    @Test
    public void testLoginSuccessful() {
        login.registerUser("test_user", "Pass123!");
        assertTrue(login.loginUser("test_user", "Pass123!"));
    }

    @Test
    public void testLoginFailed() {
        login.registerUser("test_user", "Pass123!");
        assertFalse(login.loginUser("wrong_user", "wrong_pass"));
    }
}
