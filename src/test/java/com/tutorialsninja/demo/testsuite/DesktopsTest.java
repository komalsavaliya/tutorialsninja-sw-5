package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customelisteneres.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resource.testdata.TestData;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab. and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total )
 * 2.1 Mouse hover on Currency Dropdown and click 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product <product>
 * 2.7 Enter Qty <qty> using Select class.
 * 2.8 Click on “Add to Cart” button
 * 2.9 Verify the Message <successMessage>
 * 2.10 Click on link “shopping cart” display into success message
 * 2.11 Verify the text "Shopping Cart"
 * 2.12 Verify the Product name <productName>
 * 2.13 Verify the Model <model>
 * 2.14 Verify the Total <total>
 * DATA SET
 * | product        |qty|                successMessage                                                   | productName   |   model         | total     |
 * | HTC Touch HD  | 1 |     Success: You have added HTC Touch HD to your shopping cart!      | HTC Touch HD  |     Product 1   | £74.73    |
 * | iPhone        | 2 |     Success: You have added iPhone to your shopping cart!            | iPhone        |     product 11  | £150.92   |
 * | Palm Treo Pro | 3 |     Success: You have added Palm Treo Pro to your shopping cart!     | Palm Treo Pro |   Product 2     | £1,242.11 |
 */

@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {
    HomePage homePage;
    DesktopsPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Mouse hover on Desktops Tab. and click
        homePage.clickOnDesktopsTab();

        //1.2 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //1.3 Select Sort By position "Name: Z to A"
        //desktopsPage.selectSortByOption("Name(Z - A)");
        desktopsPage.selectPositionByZtoA();


        //1.4 Verify the Product will arrange in Descending order.
        //desktopsPage.verifySortedElementInReverseOrder();
        ArrayList<String> actualList = getArrayListOfStringsFromWebElements(desktopsPage.returnZtoAElementsLocator());
        ArrayList<String> expectedList = getArrayListOfStringsFromWebElements(desktopsPage.returnZtoAElementsLocator());

        Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(expectedList);
        Assert.assertEquals(actualList, expectedList, "Error message: Products are not displayed in alphabetical order");
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "Product1", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
                                                             String successMessage, String productName, String model, String total) throws InterruptedException {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundAndClick();

        //2.3 Mouse hover on Desktops Tab.
        homePage.clickOnDesktopsTab();

        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.selectPositionByAtoZ();
        Thread.sleep(3000);

        //2.6 Select product <product>
        desktopsPage.selectProduct1(product);
//        desktopsPage.selectProduct2(product);
//        desktopsPage.selectProduct3(product);

        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQty(qty);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();

        //2.9 Verify the Message “Success: You have added product to your shopping cart!”
        String expectedMessage = successMessage + "\n×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Text!");

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String expectedText = "Shopping Cart  (0.15kg)";
        String actualText = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualText, expectedText, "Incorrect Text!");

        //2.12 Verify the Product name <productName>
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualText, expectedText, "Incorrect Text!");

        //2.13 Verify the Model <model>
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualText, expectedText, "Incorrect Model!");

        //2.14 Verify the Total <total>
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualText, expectedText, "Incorrect Total!");
    }


    @Test(groups = {"regression"}, dataProvider = "Product3", dataProviderClass = TestData.class)
    public void verifyProduct2AddedToShoppingCartSuccessFully(String product, String qty,
                                                              String successMessage, String productName, String model, String total) throws InterruptedException {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundAndClick();

        //2.3 Mouse hover on Desktops Tab.
        homePage.clickOnDesktopsTab();

        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select Sort By position "Name: A to Z"
        desktopsPage.selectPositionByAtoZ();
        Thread.sleep(3000);

        //2.6 Select product <product>
        // desktopsPage.selectProduct1(product);
        //desktopsPage.selectProduct2(product);
        desktopsPage.selectProduct3(product);

        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQty(qty);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();

        //2.9 Verify the Message “Success: You have added product to your shopping cart!”
        String expectedMessage = "Success: You have added Palm Treo Pro to your shopping cart!\n" +
                "×";
        String actualMessage = productPage.verifySuccessMessageToAddInCart();
        Assert.assertEquals(actualMessage, expectedMessage, "Success: You have added Palm Treo Pro to your shopping cart!\n" +
                "×");

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String expectedText = "Shopping Cart  (0.40kg)";
        String actualText = shoppingCartPage.verifyShoppingCartText();
        Assert.assertEquals(actualText, expectedText, "Incorrect Text!");

        //2.12 Verify the Product name <productName>
        String expectedName = productName;
        String actualName = shoppingCartPage.verifyProductName();
        Assert.assertEquals(actualText, expectedText, "Incorrect Text!");

        //2.13 Verify the Model <model>
        String expectedModel = model;
        String actualModel = shoppingCartPage.verifyModel();
        Assert.assertEquals(actualText, expectedText, "Incorrect Model!");

        //2.14 Verify the Total <total>
        String expectedTotal = total;
        String actualTotal = shoppingCartPage.verifyTotal();
        Assert.assertEquals(actualText, expectedText, "Incorrect Total!");
    }

}
