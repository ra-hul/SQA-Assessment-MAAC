package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "basic-nav-dropdown")
    WebElement btnDropDown;

    @FindBy(css = ".profile-view-btn")
    WebElement btnProfile;

    @FindBy(css = ".bx.bx-user-circle")
    WebElement btnProfileDropDown;

    @FindBy(name = "dob")
    WebElement txtDob;

    @FindBy(id = "radio-gender-male")
    WebElement txtGender;

    @FindBy(id = "education")
    WebElement txtEducation;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement txtUnversity;

    @FindBy(css = "[type = submit]")
    WebElement btnUpdate;

    @FindBy(css = ".hover-image-upload-button-view")
    WebElement btnUploadPic;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void updateImage(String imagePath) throws AWTException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnUploadPic).perform();
        actions.click().perform();
        String imageFileAbsoluteLocation = new File(imagePath).getAbsolutePath();


        Robot robot = new Robot();


        StringSelection selection = new StringSelection(imageFileAbsoluteLocation);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);


        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);


        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void updateUniversity(String university) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(txtEducation).perform();
        actions.sendKeys(Keys.TAB).perform();
//        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(university).perform();
//        Thread.sleep(60000);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void doProfileUpdate(String dob, String education, String university, String imagePath) {
        btnDropDown.click();
        btnProfile.click();
        btnProfileDropDown.click();
        btnUploadPic.sendKeys(imagePath);
        txtDob.sendKeys(dob);
        txtEducation.sendKeys(education);
        txtUnversity.sendKeys(university);
        txtGender.click();
//        btnUpdate.click();
    }

    public void updateDob(String dob) {
        String[] parts = dob.split("/");
        Actions actions = new Actions(driver);
        actions.moveToElement(txtDob).perform();
        actions.click().perform();
        actions.sendKeys(parts[0]).perform();
        actions.sendKeys(parts[1]).perform();
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        actions.sendKeys(parts[2]).perform();
    }

    public void updateEducation(String education) {
        txtEducation.sendKeys(education);
    }



    public void updateGender() {

        txtGender.click();
    }

    public void submitUpdate() {

        btnUpdate.click();
    }
}


