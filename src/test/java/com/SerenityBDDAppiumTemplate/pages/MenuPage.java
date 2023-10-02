package com.SerenityBDDAppiumTemplate.pages;

import com.SerenityBDDAppiumTemplate.bases.PageBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends PageBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='menu item log in']")
    protected WebElement menuItemLogInButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='menu item log out']")
    protected WebElement menuItemLogOutButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Log Out']")
    protected WebElement logOutConfirmarButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You are successfully logged out.']")
    protected WebElement youAreSuccessFullyLoggedOutLabel;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void clicarMenuItemLogInButton(){
        menuItemLogInButton.click();
    }

    public void clicarMenuItemLogOutButton(){
        menuItemLogOutButton.click();
    }

    public void clicarLogOutConfirmarButton(){
        logOutConfirmarButton.click();
    }

    public String retornarTextoYouAreSuccessFullyLoggedOutLabel(){
        return youAreSuccessFullyLoggedOutLabel.getText();
    }
}
