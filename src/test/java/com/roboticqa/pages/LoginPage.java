package com.roboticqa.pages;

import com.roboticqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="identifier")
    private WebElement usernameField;

    @FindBy(id="password")
    private WebElement passwordFiled;

    @FindBy(css="button[type='submit']")
    private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordFiled.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public LoginPage login(String username,String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginBtn();
        return new LoginPage(driver);
    }
}
