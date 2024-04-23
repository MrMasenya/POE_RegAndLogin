
package poe_regandlogin;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    
    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }
}