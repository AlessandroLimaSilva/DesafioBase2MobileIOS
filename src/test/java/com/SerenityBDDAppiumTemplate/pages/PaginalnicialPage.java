package com.SerenityBDDAppiumTemplate.pages;

import com.SerenityBDDAppiumTemplate.bases.PageBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginalnicialPage extends PageBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='tab bar option menu']")
    protected WebElement menuButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='tab bar option catalog']")
    protected WebElement catalogButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='tab bar option cart']")
    protected WebElement cartButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Sauce Labs Backpack']")
    protected WebElement sauceLabsBackPackCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Sauce Labs Bike Light']")
    protected WebElement sauceLabsBikeLightCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Sauce Labs Bolt T-Shirt']")
    protected WebElement sauceLabsBoltTShirtCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Sauce Labs Fleece Jacket']")
    protected WebElement sauceLabsFleeceJacketCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Sauce Labs Onesie']")
    protected WebElement sauceLabsOnesieCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Test.allTheThings() T-Shirt']")
    protected WebElement testAllTheThingsTShirtCard;


    public PaginalnicialPage(WebDriver driver) {
        super(driver);
    }

    public void clicarMenuButton(){
        menuButton.click();
    }

    public void clicarCatalogButton(){
        catalogButton.click();
    }

    public void clicarCartButton(){
        cartButton.click();
    }

    public void clicarSauceLabsBackPackCard(){
        sauceLabsBackPackCard.click();
    }

    public void clicarSauceLabsBikeLightCard(){
        sauceLabsBikeLightCard.click();
    }

    public void clicarSauceLabsBoltTShirtCard(){
        sauceLabsBoltTShirtCard.click();
    }

    public void clicarSauceLabsFleeceJacketCard(){
        sauceLabsFleeceJacketCard.click();
    }

    public void clicarSauceLabsOnesieCard(){
        sauceLabsOnesieCard.click();
    }

    public void clicarTestAllTheThingsTShirtCard(){
        testAllTheThingsTShirtCard.click();
    }
}
