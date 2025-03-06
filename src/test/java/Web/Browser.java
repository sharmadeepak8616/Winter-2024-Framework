package Web;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Browser {

    static WebDriver driver = null;

    /**
     * Method is used to launch a new Chrome-window and launch given url
     * Due to @BeforeMethod-Annotation, the method will automatically execute before each Test-method.
     */
    @BeforeMethod
    public static WebDriver openWebPage() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");
        return driver;
    }

    /**
     * Method is used to close all Chrome-windows opened due to automation
     * Due to @AfterMethod-Annotation, the method will automatically execute after each Test-method.
     */
    @AfterMethod
    public static void closeAllWebPages() {
        driver.quit();
    }

    public static WebElement findWebElement(By locator) {
        Wait fWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(InvalidSelectorException.class)
                .withMessage("Element is NOT found or condition is NOT met within 30-seconds");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }



}
