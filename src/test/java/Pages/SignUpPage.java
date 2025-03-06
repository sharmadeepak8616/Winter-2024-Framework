package Pages;

import Web.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends Browser {
    // create variables to store locators of webElements on SignUpPage
    By femaleBtnLocator = By.xpath("//label[text()='Female']//input");
    By maleBtnLocator = By.xpath("//label[text()='Male']//input");
    By notSpecifiedBtnLocator = By.xpath("//label[text()='Not specified']//input");
    By firstNameFieldLocator = By.name("firstname");
    By lastNameFieldLocator = By.name("lastname");
    By mobileEmailFieldLocator = By.name("reg_email__");
    By passwordFieldLocator = By.name("reg_passwd__");
    By dateDropdownLocator = By.id("day");
    By monthDropdownLocator = By.id("month");
    By yearDropdownLocator = By.id("year");
    By signUpButtonLocator = By.name("websubmit");
    By genderErrorLocator = By.xpath("//div[text()='Please choose a gender. You can change who can see this later.']");




    // create methods to interact with webElements on SignUpPage
    public boolean isFemaleBtnSelected() {
        return findWebElement(femaleBtnLocator).isSelected();
    }

    public boolean isMaleBtnSelected() {
        return findWebElement(maleBtnLocator).isSelected();
    }

    public boolean isNotSpecifiedBtnSelected() {
        return findWebElement(notSpecifiedBtnLocator).isSelected();
    }

    public void enterFirstName(String firstname) {
        findWebElement(firstNameFieldLocator).sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        findWebElement(lastNameFieldLocator).sendKeys(lastname);
    }

    public void enterMobileEmail(String mobileEmail) {
        findWebElement(mobileEmailFieldLocator).sendKeys(mobileEmail);
    }

    public void enterPassword(String pwd) {
        findWebElement(passwordFieldLocator).sendKeys(pwd);
    }

    public void selectDateOfBirth(String dropdownName, String dropdownValue) {
        WebElement dropdownElement = null;
        switch (dropdownName.toLowerCase()) {
            case "date":
                dropdownElement = findWebElement(dateDropdownLocator);
                break;
            case "month":
                dropdownElement = findWebElement(monthDropdownLocator);
                break;
            case "year":
                dropdownElement = findWebElement(yearDropdownLocator);
                break;
        }
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dropdownValue);
    }

    public void clickSignUpBtn() {
        findWebElement(signUpButtonLocator).click();
    }

    public boolean isGenderErrorDisplayed() {
        return findWebElement(genderErrorLocator).isDisplayed();
    }
}
