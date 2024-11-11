package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.io.IOException;

public class LoginPage {


    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(css = "[type = submit]")
    WebElement btnLogin;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://www.xampro.org/login");
    }

    public void doLogin(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void doLogin() throws IOException, ParseException {
        JSONArray users = Utils.readJSONFile();
        JSONObject user = (JSONObject) users.get(users.size() - 1);
        String email = (String) user.get("email");
        String password = (String) user.get("password");
        doLogin(email, password);
    }
}
