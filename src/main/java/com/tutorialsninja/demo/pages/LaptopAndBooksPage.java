package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.browserfactory.MangeBrowser;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopAndBooksPage extends Utility {
//    @CacheLookup
//    @FindBy(xpath = "(//select[@id='input-sort'])[1]")
//    WebElement sortByPriceHighToLow;
//
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement arrayListOfProducts;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortByPriceHighToLow;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    WebElement getSortByHighToLowOrder;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement price;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement product;

        public void selectSortByPriceHighToLow(String options) {
        selectByVisibleTextFromDropDown(sortByPriceHighToLow, options);
        getArrayListOfProductsInChoice(arrayListOfProducts);
    }
     public String verifyProductPriceArrangeInHighToLow() {
        return verifyProductPriceArrangeInHighToLow();
    }
    public String sortByPriceHighToLow() {
        Reporter.log("Sort By PriceHighToLow" + sortByPriceHighToLow.toString());
        selectByVisibleTextFromDropDown(sortByPriceHighToLow, "Price (High > Low)");
        return null;
    }

    public String GetSortByHighToLowOrder() {
        List<WebElement> products;
        MangeBrowser ManageBrowser = null;
        products = ManageBrowser.driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        products = ManageBrowser.driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return null;
    }

    public void sortByPrice(String option) {
        selectByVisibleTextFromDropDown(price, option);
    }

    public void selectMacBookProduct() {
        clickOnElement(product);
    }
}
