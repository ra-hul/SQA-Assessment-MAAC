package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(className = "show-student-profile")
    WebElement profileIcon;

    @FindBy(linkText = "Profile")
    WebElement profileLink;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToProfile() {
        profileIcon.click();
        profileLink.click();
    }
}
