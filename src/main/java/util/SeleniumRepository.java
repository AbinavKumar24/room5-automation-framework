package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
/**
 *
 * @author abinav
 *This Utility will fetch the driver instance based on the browserType mentioned in properties file.
 */
public class SeleniumRepository {

    public static WebDriver driver = null;


    public static WebDriver startBrowser(String browserName){

        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/geckodriver");
            driver = new FirefoxDriver();

        } else if (browserName.equals("ie")) {
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        } else if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver");
            driver = new ChromeDriver();

        } else {
            throw new RuntimeException("Driver name: " + browserName + " Add browser Name in Configuration.properties ");
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void goToURL(String url){
        driver.get(url);
    }
    public static void goToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
