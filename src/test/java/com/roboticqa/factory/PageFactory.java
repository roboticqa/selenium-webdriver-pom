package com.roboticqa.factory;

import com.roboticqa.pages.HomePage;
import com.roboticqa.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    private WebDriver driver;

    public PageFactory(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }
    // Add more page object creation methods as needed
}
