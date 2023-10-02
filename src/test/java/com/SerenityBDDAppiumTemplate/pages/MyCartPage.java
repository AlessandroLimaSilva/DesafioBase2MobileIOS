package com.SerenityBDDAppiumTemplate.pages;

import com.SerenityBDDAppiumTemplate.bases.PageBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MyCartPage extends PageBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='remove item']")
    protected List<WebElement> excluirItensButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Oh no! Your cart is empty. Fill it up with swag to complete your purchase.']")
    protected WebElement carrinhoVazioLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Proceed To Checkout button']")
    protected WebElement proceedToCheckoutButton;

    public MyCartPage(WebDriver driver) {
        super(driver);
    }

    public void excluirItemButton(){
        for(WebElement element: excluirItensButton){
            element.click();
            break;
        }
    }

    public boolean retornaSeCarrinhoVazioLabelEVisivel(){
        return carrinhoVazioLabel.isDisplayed();
    }

    public void excluirTodosOsItensDoCarrinho(){
        if(!excluirItensButton.isEmpty()){
            try {
                while(!excluirItensButton.isEmpty()){
                    excluirItensButton.get(0).click();
                }
            }catch (Exception e){

            }
        }
    }

    public void clicarProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
}
