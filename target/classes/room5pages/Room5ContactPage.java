package room5pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.SeleniumRepository;
/**
 *
 * @author abinav
 *This class is the Page Object Class for Room5 Contact Page
 */
public class Room5ContactPage {

    static Log log = LogFactory.getLog(Room5ContactPage.class);

    WebDriver driver;

    @FindBy(xpath = "//textarea[@class='contact-msg']")

    WebElement contactTextMessageArea;

    @FindBy(xpath = "//input[@class='contact-input']")

    WebElement contactName;

    @FindBy(xpath = "//input[@id='contact-email']")

    WebElement contactEmailId;

    @FindBy(xpath = "//input[@id='confirm']")

    WebElement confirmCheckBox;

    @FindBy(xpath = "//button[@class='contact-submit']")

    WebElement submitContactButton;

    @FindBy(xpath = "//div[@class='alert-error'][1]")

    WebElement checkBoxErrorMessage;

    public Room5ContactPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the message present on Room5 Contact Page
     */
    public void enterMessage(String msg){
        log.info("Entering Message on Contact page");
        contactTextMessageArea.sendKeys(msg);
    }
    /**
     * Enter the name present on Room5 Contact Page
     */
    public void enterName(String name){
        log.info("Entering Name on Contact page");
        contactName.sendKeys(name);
    }
    /**
     * Enter Email Id present on Room5 Contact Page
     */
    public void enterEmailId(String emailId){
        log.info("Entering Email Id on Contact page");
        contactEmailId.sendKeys(emailId);
    }
    /**
     * Clicks on Checkbox  present on Room5 Contact Page
     */
    public void confirmContactCheckBox(){
        log.info("Clicking on Check box present on Contact page");
        confirmCheckBox.click();
    }
    /**
     * Clicks on Submit Button present on Room5 Contact Page
     */
    public void setSubmitContactButton(){
        log.info("Submitting details on Contact page");
        submitContactButton.click();
    }
}
