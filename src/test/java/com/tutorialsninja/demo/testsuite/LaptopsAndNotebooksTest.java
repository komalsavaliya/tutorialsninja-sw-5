package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteneres.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Create the class LaptopsAndNotebooksTest
 * Write the following test
 * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
 * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
 * 1.2 Click on “Show All Laptops & Notebooks”
 * 1.3 Select Sort By "Price (High > Low)"
 * 1.4 Verify the Product price will arrange in High to Low order.
 * 2. Test name verifyThatUserPlaceOrderSuccessfully()
 * 2.1 Mouse hover on Laptops & Notebooks Tab and click
 * 2.2 Click on “Show All Laptops & Notebooks”
 * 2.3 Select Sort By "Price (High > Low)"
 * 2.4 Select Product “MacBook”
 * 2.5 Verify the text “MacBook”
 * 2.6 Click on ‘Add To Cart’ button 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
 * 2.8 Click on link “shopping cart” display into success message
 * 2.9 Verify the text "Shopping Cart"
 * 2.10 Verify the Product name "MacBook"
 * 2.11 Change Quantity "2" 2.12 Click on “Update” Tab 2.13 Verify the message “Success: You have modified your shopping cart!”
 * 2.14 Verify the Total £737.45
 * 2.15 Click on “Checkout” button
 * 2.16 Verify the text “Checkout”
 * 2.17 Verify the Text “New Customer”
 * 2.18 Click on “Guest Checkout” radio button
 * 2.19 Click on “Continue” tab
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “Continue” Button
 * 2.22 Add Comments About your order into text area
 * 2.23 Check the Terms & Conditions check box
 * 2.24 Click on “Continue” button 2.25 Verify the message “Warning: Payment method required!”
 */

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {
    HomePage homePage;
    LaptopAndBooksPage laptopAndBooksPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void intIt() {
        homePage = new HomePage();
        laptopAndBooksPage = new LaptopAndBooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutPage = new CheckOutPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.clickOnLaptopsAndNotebooks();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        laptopAndBooksPage.sortByPriceHighToLow();

//        //1.4 Verify the Product price will arrange in High to Low order
//        String actualPrice = laptopAndBooksPage.verifyProductPriceArrangeInHighToLow();
//        String expectedPrice = "$2,000.00\n" +
//                "Ex Tax:$2,000.00";
//        String expectedMessage = expectedPrice + "\n" +
//                "Ex Tax:" + expectedPrice;
//        Assert.assertEquals(actualPrice, expectedMessage, "Incorrect price  order!");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {

        // Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();

        //Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundAndClick();

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.clickOnLaptopsAndNotebooks();

        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopAndBooksPage.sortByPriceHighToLow();

        //2.4 Select Product “MacBook”
        laptopAndBooksPage.selectMacBookProduct();

        //2.5 Verify the text “MacBook”
        String actualText = macBookPage.verifyTheTextMacBook();
        String expectedText = "MacBook";
        Assert.assertEquals(actualText, expectedText, "Incorrect Product Text displayed!");

        //2.6 Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCart();

        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualSuccessMessage = macBookPage.verifySuccessMessageForAddingProductToShoppingCart();
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!\n×";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Invalid Success Message!");

        //2.8 Click on link “shopping cart” display into success message
        macBookPage.clickOnLinkToShoppingCartMessage();

        //2.9 Verify the text "Shopping Cart"
        String actualCartText = shoppingCartPage.verifyShoppingCartText();
        String expectedCartText = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(actualCartText, expectedCartText, "Incorrect Shopping Cart Message displayed!");

        //2.10 Verify the Product name "MacBook"
        String actualProductName = shoppingCartPage.verifyProductNameIsMacBook();
        String expectedProductName = "MacBook";
        Assert.assertEquals(actualProductName, expectedProductName, "Incorrect product Name displayed!");

        //2.11 Change Quantity "2"
        shoppingCartPage.clearTheQtyBox();
        shoppingCartPage.enterQuantityInToTheBox("2");

        // 2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTheQuantityBox();

        // 2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualUpdatedMessage = shoppingCartPage.verifyUpdatedSuccessMessage();
        String expectedUpdatedMessage = "Success: You have modified your shopping cart!\n×";
        Assert.assertEquals(actualUpdatedMessage, expectedUpdatedMessage, "Incorrect updated message displayed!");

        //2.14 Verify the Total £737.45
        String actualTotalPrice = shoppingCartPage.verifyTotalPrice();
        String expectedTotalPrice = "£737.45";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Incorrect total price displayed!");

        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutButton();

        //2.16 Verify the text “Checkout”
        String actualCheckOutText = checkOutPage.verifyCheckOutText();
        String expectedCheckOutText = "Checkout";
        Assert.assertEquals(actualCheckOutText, expectedCheckOutText, "Incorrect checkout text displayed!");

        //2.17 Verify the Text “New Customer”
        String actualNewCustomerText = checkOutPage.verifyTextNewCustomer();
        String expectedNewCustomerText = "Checkout";
        Assert.assertEquals(actualNewCustomerText, expectedNewCustomerText, "Incorrect new customer text displayed!");

        // * 2.18	Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckOutButton();

        //2.19 Click on “Continue” tab
        checkOutPage.clickOnContinueButtonTab();

        //2.20 Fill the mandatory fields
        checkOutPage.fillAllMandatoryField("Mary", "John", "maryjohn@gmail.com", "918-456-1234",
                "2250 144th street", "Tulsa", "71433", "United States", "Oklahoma");

        //2.21 Click on “Continue” Button
        checkOutPage.clickOnContinueButtonForGuest();

        //2.22 Add Comments About your order into text area
        checkOutPage.addCommentsAboutYourOrderIntoTheTextArea("Leave it By near Door Plzz");

        //2.23 Check the Terms & Conditions check box
        checkOutPage.clickOnCheckBoxForTermsAndConditions();

        //2.24 Click on “Continue” button
        checkOutPage.clickOnContinueButtonForPaymentMethod();

        //2.25 Verify the message “Warning: Payment method required!”
        String actualWarningText = checkOutPage.verifyWarningMessageForPaymentMethod();
        String expectedWarningText = "Warning: Payment method required!\n×";
        Assert.assertEquals(actualWarningText, expectedWarningText, "Incorrect warning message displayed!");
    }
}





