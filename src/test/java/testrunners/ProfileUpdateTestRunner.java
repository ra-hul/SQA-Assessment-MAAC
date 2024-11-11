package testrunners;

import configs.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class ProfileUpdateTestRunner extends Setup {

    ProfilePage profileUpdate;
    LoginPage loginPage;

    @Test
    public void doProfileUpdateOFUser() throws IOException, ParseException {

        driver.get("https://www.xampro.org/login");

        JSONArray users = Utils.readJSONFile();

        JSONObject user = (JSONObject) users.get(users.size() - 1);

        String email = (String) user.get("email");
        String password = (String) user.get("password");

        String dob = "05/28/1998";
        String education = "BSC";
        String university = "American International University-Bangladesh(AIUB)";
        String imagePath = System.getProperty("user.dir") + "/src/test/img/ppp.jpg";

        loginPage = new LoginPage(driver);
        loginPage.doLogin(email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic-nav-dropdown")));


        profileUpdate = new ProfilePage(driver);
        profileUpdate.doProfileUpdate(dob, education, university, imagePath);

    }
}
