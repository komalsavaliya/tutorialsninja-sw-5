package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customelisteneres.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    //Click On Desktop TAB
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement clickOnDesktopsTab;

    //click On Show All Desktops
    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement clickOnShowAllDesktops;

    //Verify the text ‘Desktops’
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement verifyTextDesktops;

    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement clickOnLaptopsAndNotebooks;

    // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
    @CacheLookup
    @FindBy(xpath = "Show AllLaptops & Notebooks")
    WebElement clickOnShowAllLaptopsAndNotebooks;

    //2.3 Verify the text ‘Laptops & Notebooks’
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement verifyTextLaptopsAndNotebooks;

    //3.1 Mouse hover on “Components” Tab and click
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement clickOnComponentsTab;

    //3.2 call selectMenu method and pass the menu = “Show All Components”
    @CacheLookup
    @FindBy(xpath = "Show AllComponents")
    WebElement clickOnShowAllComponents;

    //3.3 Verify the text ‘Components'
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement verifyTextComponents;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement dropdown;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='£Pound Sterling'])[1]")
    WebElement sterling;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement accountLink;



    //------------------------------------------------------------------------------//

    public void selectMenu(String menu) {
        Reporter.log("topMenu");
        CustomListeners.test.log(Status.PASS, "topMenu");
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements((By) topMenuList);
        }
    }

    public void clickOnDesktopsTab() {
        mouseHoverToElementAndClick(clickOnDesktopsTab);
    }

    public String verifyTextDesktops() {
        String message = getTextFromElement(verifyTextDesktops);
        CustomListeners.test.log(Status.PASS, "Text Displayed");
        return message;
    }
    public void clickOnLaptopsAndNotebooks() {
        mouseHoverToElementAndClick(clickOnLaptopsAndNotebooks);
    }

    public String verifyTextLaptopsAndNotebooks() {
        String message = getTextFromElement(verifyTextLaptopsAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Text Displayed");
        return message;
    }
    public void clickOnComponentsTab() {
        mouseHoverToElementAndClick(clickOnComponentsTab);
    }

    public String verifyTextComponents() {
        String message = getTextFromElement(verifyTextComponents);
        CustomListeners.test.log(Status.PASS, "Text Displayed");
        return message;
    }
    public void mouseHoverOnCurrencyDropdownAndClick() {
        mouseHoverToElementAndClick(dropdown);
    }

    public void mouseHoverOnPoundAndClick() {
        mouseHoverToElementAndClick(sterling);
    }

    public void clickOnAccountLink() {
        mouseHoverToElementAndClick(accountLink);
    }
}



