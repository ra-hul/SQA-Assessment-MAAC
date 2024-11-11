package testrunners;

import configs.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProfilePage;

import java.awt.*;
import java.io.IOException;

public class MyTestRunner extends Setup {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;

    @Test
    public void doLoginUsingValidCred() throws IOException, ParseException, InterruptedException, AWTException {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.doLogin();
        dashboardPage = new DashboardPage(driver);
        dashboardPage.navigateToProfile();
        profilePage = new ProfilePage(driver);
        profilePage.updateImage("./src/test/img/ppp.jpg");
        profilePage.updateDob("05/28/1998");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 900)");

        profilePage.updateGender();
        profilePage.updateEducation("BSC");
        profilePage.updateUniversity("American International University - Bangladesh (AIUB)");
//        profilePage.submitUpdate();
    }
}
