package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteneres.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> listOfProducts;

//    @CacheLookup
//    @FindBy(id = "input-sort")
//    WebElement descendingOrder;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    WebElement allProductsName;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement positionAtoZ;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement positionZtoA;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement ascendingOrder;

    @CacheLookup
    @FindBy(linkText = "HTC Touch HD")
    WebElement product1;

    @CacheLookup
    @FindBy(linkText = "iPhone")
    WebElement product2;

    @CacheLookup
    @FindBy(linkText = "Palm Treo Pro")
    WebElement product3;

    //-----------------------------------------------------------------------------------//
//    public void verifySortedElementInReverseOrder() {
//        Reporter.log("Get elements sorted in reverse order" + descendingOrder.toString());
//        List<WebElement> elements = listOfProducts;
//        ArrayList<String> originalElementList = new ArrayList<>();
//        for (WebElement e : elements) {
//            originalElementList.add(e.getText());
//        }
//        System.out.println(originalElementList);
//
//        Collections.reverse(originalElementList);
//        System.out.println(originalElementList);
//
//        elements = listOfProducts;
//        ArrayList<String> aftersortByReverseList = new ArrayList<>();
//        for (WebElement e : elements) {
//            originalElementList.add(e.getText());
//        }
//        System.out.println(aftersortByReverseList);
//        CustomListeners.test.log(Status.PASS, "Get elements sorted in reverse order");
//    }

//    public void selectSortByOption(String option) {
//        Reporter.log("Select sortBy option" + descendingOrder.toString());
//        selectByVisibleTextFromDropDown(descendingOrder, option);
//        CustomListeners.test.log(Status.PASS, "Select sortBy option" + option);
//    }

    public void selectPositionByZtoA() {
        Reporter.log("select position ByZtoA");
        CustomListeners.test.log(Status.PASS, "select position ByZtoA");
        selectByVisibleTextFromDropDown(positionZtoA, "Name (Z - A)");
    }

    public List<WebElement> returnZtoAElementsLocator() {
        Reporter.log("return ZtoA elements locator");
        CustomListeners.test.log(Status.PASS, "return ZtoA elements locator");
        List<WebElement> listOfElements = driver.findElements(By.id("input-sort"));
        return listOfElements;

    }

    public void selectPositionByAtoZ() {
        Reporter.log("select Position By AtoZ");
        CustomListeners.test.log(Status.PASS, "select Position By AtoZ");
        selectByVisibleTextFromDropDown(positionAtoZ, "Name (A - Z)");
    }

    public void sortByNameAToZPosition(String option) {
        selectByVisibleTextFromDropDown(ascendingOrder, option);
    }

    public void selectProduct1(String product) {
        mouseHoverToElementAndClick(product1);
    }

    public void selectProduct2(String product) {
        mouseHoverToElementAndClick(product2);
    }

    public void selectProduct3(String product) {
        mouseHoverToElementAndClick(product3);
    }
}
