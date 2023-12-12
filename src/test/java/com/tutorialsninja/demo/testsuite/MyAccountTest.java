package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteneres.CustomListeners;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.MyAccountsPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1. Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 * 1.1 Clickr on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 * 2.1 Clickr on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 * 3.1 Clickr on My Account Link.
 * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 3.3 Enter First Name
 * 3.4 Enter Last Name
 * 3.5 Enter Email
 * 3.6 Enter Telephone
 * 3.7 Enter Password
 * 3.8 Enter Password Confirm
 * 3.9 Select Subscribe Yes radio button
 * 3.10 Click on Privacy Policy check box
 * 3.11 Click on Continue button 3.12 Verify the message “Your Account Has Been Created!” 3.13 Click on Continue button 3.14 Clickr on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 * 4.1 Clickr on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Clickr on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */

@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    MyAccountsPage myAccountsPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        myAccountsPage = new MyAccountsPage();
    }

    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option) {
        myAccountsPage.selectOption(option);
    }


    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 Click on My Account Link.
        homePage.clickOnAccountLink();

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”.
        registerPage.verifyRegisterAccountText();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1 Click on My Account Link.
        homePage.clickOnAccountLink();

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //2.3 Verify the text “Returning Customer”.
        registerPage.verifyTextReturningCustomerOnLoginPage();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        homePage.clickOnAccountLink();

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        registerPage.enterFirstName("Mary");

        //3.4 Enter Last Name
        registerPage.enterLastName("John");

        //3.5 Enter Email
        final String randomEmail;
        randomEmail = RegisterPage.randomEmail();
        registerPage.enterEmail(randomEmail);

        //3.6 Enter Telephone
        registerPage.enterTelephoneNumber("918-456-1234");

        //3.7 Enter Password
        registerPage.enterPassword("12345678");

        //3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("12345678");

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribeRadioButton();

        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicyCheckBox();

        //3.11 Click on Continue button
        registerPage.clickOnContinueButton();

        // 3.12 Verify the message “Your Account Has Been Created!”
        String actualMessage = myAccountsPage.verifyTheMessageYourAccountHasBeenCreated();
        String expectedMessage = "Your Account Has Been Created!";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect message displayed!");

        // 3.13 Click on Continue button
        myAccountsPage.clickOnContinueAccountButton();

        // 3.14 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //3.16 Verify the text “Account Logout”
        String actualLogoutText = myAccountsPage.verifyTextForAccountLogOut();
        String expectedLogOutText = "Logout";
        Assert.assertEquals(actualLogoutText, expectedLogOutText, "Incorrect logout message displayed!");

        //3.17 Click on Continue button
        myAccountsPage.clickOnContinueLogOutButton();
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        //4.1 Click on My Account Link.
        homePage.clickOnAccountLink();

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        registerPage.enterEmail("maryjohn@gmail.com");

        //4.5 Enter Password
        registerPage.enterPassword("12345678");

        //4.6 Click on Login button
        myAccountsPage.clickOnLoginButton();

        //4.7 Verify text “My Account”
        String actualText = myAccountsPage.verifyTheTextMyAccount();
        String expectedText = "My Account";
        Assert.assertEquals(actualText, expectedText, "Incorrect my account text displayed!");

        //4.8 Click on My Account Link.
        myAccountsPage.clickOnMyAccountLink();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        String actualLogoutText = myAccountsPage.verifyTextForAccountLogOut();
        String expectedLogOutText = "Logout";
        Assert.assertEquals(actualLogoutText, expectedLogOutText, "Incorrect logout message displayed!");

        //4.11 Click on Continue button
        myAccountsPage.clickOnContinueLogOutButton();
    }

    }
