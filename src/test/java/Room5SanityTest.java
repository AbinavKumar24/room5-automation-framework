import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import room5pages.Room5ContactPage;
import room5pages.Room5HomePage;
import util.ExcelUtils;
import util.PropertyFileUtil;
import util.SeleniumRepository;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author abinak
 * This class contains test cases for Sanity Suite
 */
public class Room5SanityTest {

    public static WebDriver driver = null;
    Room5HomePage room5HomePage;
    Room5ContactPage room5ContactPage;

    /**
     * Method to initialize the WebDriver
     */
    @BeforeMethod
    public void setup() throws Exception {
        driver = SeleniumRepository.startBrowser(PropertyFileUtil.readFile("Configuration.properties", "BrowserType"));
        SeleniumRepository.goToURL(PropertyFileUtil.readFile("Configuration.properties", "Room5HomePageURL"));
        ExcelUtils.setExcelFile("Room5 Data");
}

    @Test(groups = {"Room5Sanity"}, description = "Verify if the user is able to Search location by clicking on Search Bar present at Home Page")
    public void searchLocationTest() throws Exception {
        String searchLocation = ExcelUtils.getCellData(1, 0);
        room5HomePage = new Room5HomePage(driver);
        room5HomePage.clickSearchBar();
        room5HomePage.setSearchLocation(searchLocation);
    }

    @Test(groups = {"Room5Sanity"}, description = "Verify if the user is able to Subscribe to Newsletter by providing Email ID")
    public void subsribeToNewsletterTest() throws Exception {
        String emailId = ExcelUtils.getCellData(1, 1);
        room5HomePage = new Room5HomePage(driver);
        room5HomePage.clickConfirmCheckbox();
        room5HomePage.enterEmailId(emailId);
        room5HomePage.clickSubsribeButton();
    }

    @Test(groups = {"Room5Sanity"}, description = "Verify if the user is able to Navigate to Destination from Home Page")
    public void navigateToDestinationTest() throws Exception {
        room5HomePage = new Room5HomePage(driver);
        room5HomePage.clickNavigationIcon();
        room5HomePage.clickDestination();
    }

    @Test(groups = {"Room5Sanity"}, description = "Verify if the user is able to Fill Contact Form")
    public void fillContactFormTest() throws Exception {
        String message = ExcelUtils.getCellData(1, 3);
        String name = ExcelUtils.getCellData(1, 2);
        String email = ExcelUtils.getCellData(1, 1);
        room5HomePage = new Room5HomePage(driver);
        room5ContactPage = new Room5ContactPage(driver);
        room5HomePage.clickContactButton();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

       for(String winHandle : driver.getWindowHandles())
           driver.switchTo().window(winHandle);

        room5ContactPage.enterMessage(message);
        room5ContactPage.enterName(name);
        room5ContactPage.enterEmailId(email);
        Thread.sleep(5000);
        room5ContactPage.confirmContactCheckBox();
        room5ContactPage.setSubmitContactButton();
    }
    @Test(groups = {"Room5Sanity"}, description = "Verify if the Cookie content is visible to the user once the user opens the website")
    public void cookieContentTest() throws Exception {
        room5HomePage = new Room5HomePage(driver);
        room5HomePage.verifyCookieContentVisibility();
    }

    @Test(groups = {"Room5Sanity"}, description = "Verify if the user is able to Navigate to Other Country Website")
    public void changeCountryNavigationTest() throws Exception {
        String country = ExcelUtils.getCellData(1, 4);
        String countryUrl = ExcelUtils.getCellData(1, 5);
        room5HomePage = new Room5HomePage(driver);
        room5HomePage.selectCountryDropdown(country);
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),countryUrl);
    }

    /**
     * Method to kill the WebDriver
     */
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
