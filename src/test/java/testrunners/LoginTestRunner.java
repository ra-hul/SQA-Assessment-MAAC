package testrunners;

import configs.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTestRunner extends Setup {

    LoginPage loginPage;

    @Test
    public void doLoginUsingValidCred() throws IOException, ParseException {
        driver.get("https://www.xampro.org/login");
        loginPage = new LoginPage(driver);
        loginPage.doLogin();
    }
}
