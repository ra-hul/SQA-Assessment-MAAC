package testrunners;

import configs.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.Utils;

import java.io.IOException;

public class RegistrationTestRunner extends Setup {

    RegistrationPage registrationPage;

    @Test
    public void testRegistration() throws IOException, ParseException {
        driver.get("https://www.xampro.org/signup");

        JSONArray users = Utils.readJSONFile();

        JSONObject user = (JSONObject) users.get(0);

        String name = (String) user.get("name");
        String email = (String) user.get("email");
        String phone = (String) user.get("phone");
        String password = (String) user.get("password");
        String confirmPassword = (String) user.get("confirmPassword");

        registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(name, email, phone, password, confirmPassword);

    }
}
