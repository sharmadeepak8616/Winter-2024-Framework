package Tests;


import Pages.LandingPage;
import Pages.SignUpPage;
import Web.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * class contains Test-method for scenarios related to SignUp feature
 */
public class SignUpTests extends Browser {
    /**
     * Testcase: Verify by default no gender radio button is selected on SignUp page
     * 1. Launch facebook.com
     * 2. Click on Create new account button
     * 3. Verify "female" radio button is NOT selected
     * 4. Verify "male" radio button is NOT selected
     * 5. Verify "Not specified" radio button is NOT selected
     */
    @Test
    public void verifyGenderButtonsDefaultBehavior() {
        // 2. Click on Create new account button
        // use the method present in POM(LandingPage.java) to click Create-new-account button
        LandingPage landingPage = new LandingPage();
        landingPage.clickCreateNewAccountBtn();

        // 3. Verify "female" radio button is NOT selected
        SignUpPage signUpPage = new SignUpPage();
        boolean isFemaleSelected = signUpPage.isFemaleBtnSelected();
        Assert.assertFalse(isFemaleSelected, "Female radio button is selected");

        // 4. Verify "male" radio button is NOT selected
        boolean isMaleSelected = signUpPage.isMaleBtnSelected();
        Assert.assertFalse(isMaleSelected, "Male radio button is selected");

        // 5. Verify "Not specified" radio button is NOT selected
        boolean isNotSpecifiedSelected = signUpPage.isNotSpecifiedBtnSelected();
        Assert.assertFalse(isNotSpecifiedSelected, "Not specified radio button is selected");

    }

    /**
     * Testcase: Verify error is displayed when gender is not selected
     * 1. Launch facebook.com
     * 2. Click on Create new account button
     * 3. Enter "Fname" in Firstname
     * 4. Enter "Lname in Surname
     * 5. Select 15 in Date dropdown
     * 6. Select Aug in Month dropdown
     * 7. Select 2000 in Year dropdown
     * 8. Enter "testingEmail@gmail.com"
     * 9. Enter "MyPassw0rd@@123" in Password
     * 10. Click "Sign Up" button
     * 11. Verify "Please choose a gender. You can change who can see this later." error is displayed
     */
    @Test
    public void verifyGenderNotSelectedError() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickCreateNewAccountBtn();

        SignUpPage signUpPage = new SignUpPage();
        signUpPage.enterFirstName("Fname");
        signUpPage.enterLastName("Lname");
        signUpPage.selectDateOfBirth("date", "15");
        signUpPage.selectDateOfBirth("month", "Aug");
        signUpPage.selectDateOfBirth("year", "2000");
        signUpPage.enterMobileEmail("testingEmail@gmail.com");
        signUpPage.enterPassword("MyPassw0rd@@123");
        signUpPage.clickSignUpBtn();

        boolean isErrorDisplayed = signUpPage.isGenderErrorDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Gender error is NOT displayed");
    }

}
