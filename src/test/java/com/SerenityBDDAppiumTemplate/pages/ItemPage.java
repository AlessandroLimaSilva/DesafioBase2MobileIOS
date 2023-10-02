package com.SerenityBDDAppiumTemplate.pages;

import com.SerenityBDDAppiumTemplate.bases.PageBase;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends PageBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Add To Cart button']")
    protected WebElement adicionarItemAoCarrinhoButton;

    protected String classificarItemList = "//*[contains(@name,'review star #')]";

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Close Modal button']")
    protected WebElement closeModalButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Thank you for submitting your review!']")
    protected WebElement thankYouForSubmittingYourReviewLabel;


    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void clicarAdicionarItemAoCarrinhoButton(){

        waitForElement(adicionarItemAoCarrinhoButton);
        adicionarItemAoCarrinhoButton.click();
    }

    public void clicarClassificacaoItemList(String nota){
        WebElement notaProduto = driver.findElement(By.xpath(classificarItemList.replace("#",nota)));
        notaProduto.click();
    }

    public void clicarCloseModalButton(){
        waitForElement(closeModalButton);
        closeModalButton.click();
    }

    public String retornarTextoThankYouForSubmittingYourReviewLabel(){
        return thankYouForSubmittingYourReviewLabel.getText();
    }
}
