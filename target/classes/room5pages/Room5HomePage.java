package room5pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import util.SeleniumRepository;

/**
 *
 * @author abinav
 *This class is the Page Object Class for Room5 Home Page
 */

public class Room5HomePage {

    static Log log = LogFactory.getLog(Room5HomePage.class);

    WebDriver driver;

    @FindBy(xpath = "//div[@class='search-icon']")

    WebElement searchBar;

    @FindBy(xpath = "//input[@placeholder='Search']")

    WebElement searchAreaLocation;

    @FindBy(xpath = "//a[contains(text(),'Contact')]")

    WebElement contactButton;

    @FindBy(xpath = "//input[@id='confirm']")

    WebElement confirmCheckBox;

    @FindBy(xpath = "//input[@name='email']")

    WebElement emailSubsribeTextBox;

    @FindBy(xpath = "//button[@type='submit']")

    WebElement subscribeButton;

    @FindBy(xpath = "//div[@class='nav-icon']")

    WebElement navigationIcon;

    @FindBy(xpath = "//div[@class='destination-menu']")

    WebElement destinationButton;

    @FindBy(xpath = "//span[@class='trivago-magazine-footer']")

    WebElement trivagoFooter;

    @FindBy(xpath = "//select[@class='locales-dropdown']")

    WebElement dropDownCountry;

    @FindBy(xpath = "//div[@class='Cookie__content']")

    WebElement cookieContent;

    public Room5HomePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on Search Bar present on Room5 Home Page
     */
    public void clickSearchBar(){
        log.info("Clicking Search Bar");
        searchBar.click();
    }
    /**
     * Clicks on Search Bar present on Room5 Home Page
     */
    public void setSearchLocation(String location){
        log.info("Setting Search location");
        searchAreaLocation.sendKeys(location);
    }
    /**
     * Clicks on Confirm Check box present on Room5 Home Page
     */
    public void clickConfirmCheckbox() throws InterruptedException {
        log.info("Navigating to Contact Button present at bottom of the home page");
        SeleniumRepository.goToElement(contactButton);
        Thread.sleep(5000);
        confirmCheckBox.click();
    }
    /**
     * Clicks on Contact Button present on Room5 Home Page
     */
    public void clickContactButton() throws InterruptedException {
        log.info("Navigating to Trivago Footer present at bottom of the home page");
        SeleniumRepository.goToElement(trivagoFooter);
        contactButton.click();

    }
    /**
     * Enter Email Id present on Room5 home Page
     */
    public void enterEmailId(String emailId){
        log.info("Entering Email Id while subsribing to newsletter");
        emailSubsribeTextBox.sendKeys(emailId);
    }
    /**
     * Clicks on Subscribe Button to Subscribe to Newsletter
     */
    public void clickSubsribeButton(){
        log.info("Clicking on Subscribe Button present at bottom of home page");
        subscribeButton.click();
    }
    /**
     * Clicks on Navigation Icon present on Room5 Home Page
     */
    public void clickNavigationIcon(){
        log.info("Clicking on Navigation Icon");
        navigationIcon.click();
    }
    /**
     * Clicks on a Destination once the user clicks on Navigation Icon
     */
    public void clickDestination(){
        log.info("Clicking on Destination Button present at bottom of home page");
        destinationButton.click();
    }

    public void selectCountryDropdown(String country){
        Select drpCountry = new Select(this.dropDownCountry);
        drpCountry.selectByVisibleText(country);
    }

    public void verifyCookieContentVisibility(){
        log.info("Verifying Cookie Content");
        org.testng.Assert.assertTrue(this.cookieContent.isDisplayed(),"Cookie Content is not visible to the user");
    }
}
