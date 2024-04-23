
package poe_regandlogin;


import org.junit.Test;
import static org.junit.Assert.*;


public class RegAndLoginTest {
    
    @Test
    public void testRegisterUser() {
        Login login = new Login();
        assertEquals("Username captured successfully.", login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Masenya"));
        assertEquals("Password captured successfully.", login.registerUser("kyl_1", "Ch&&sec@ke99!", "Kyle", "Masenya"));
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "Kyle", "Masenya"));
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", login.registerUser("kyl_1", "password", "Kyle", "Masenya"));
    }
    
    @Test
    public void testLoginUser() {
        Login login = new Login();
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("kyl_1", "password"));
    }
    
}