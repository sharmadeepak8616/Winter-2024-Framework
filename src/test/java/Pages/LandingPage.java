package Pages;

import Web.Browser;
import org.openqa.selenium.By;

public class LandingPage extends Browser {
    // create variables to store locators of webElements on LandingPage
    By createNewAccountBtnLocator = By.linkText("Create new account");






    // create methods to interact with webElements on LandingPage
    public void clickCreateNewAccountBtn() {
        findWebElement(createNewAccountBtnLocator).click();
    }





}
