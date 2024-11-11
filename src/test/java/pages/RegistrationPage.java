package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {


    @FindBy( name = "name")
    WebElement txtUsername;

    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "phoneNumber")
    WebElement txtPhone;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "confirmPassword")
    WebElement txtConfirmPassword;

    @FindBy(css= "[type= submit]")
    WebElement btnRegister;

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    public void fillRegistrationForm(String name, String email, String phone, String password, String confirmPassword) {
        txtUsername.sendKeys(name);
        txtEmail.sendKeys(email);
        txtPhone.sendKeys(phone);
        txtPassword.sendKeys(password);
        txtConfirmPassword.sendKeys(confirmPassword);
        btnRegister.click();
    }
}
