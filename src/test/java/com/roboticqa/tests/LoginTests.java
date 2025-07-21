package com.roboticqa.tests;

import com.roboticqa.factory.PageFactory;
import com.roboticqa.pages.HomePage;
import com.roboticqa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public void successfullyLogin(){

        WebDriver driver=new ChromeDriver();
        PageFactory pageFactory=new PageFactory(driver);

        driver.get("https://roboticqa.com/");
        driver.manage().window().maximize();

        // Use the factory to het page object
        LoginPage loginPage=pageFactory.getLoginPage();
        loginPage.login("standard_user","password123");

        //get meesage and assert in test loaded
        HomePage homePage=pageFactory.getHomePage();
        String actualMessage=homePage.getBoxText();
        Assert.assertEquals(actualMessage,"Welcome back!");

        driver.close();

    }

}
