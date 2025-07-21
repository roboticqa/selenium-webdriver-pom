package com.roboticqa.pages;

import com.roboticqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath="//div[contains(@aria-label,'Notifications')]//li")
    private WebElement popUpBox;

    @FindBy(xpath="//div[text()='Welcome back!']")
    private WebElement popUpText;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getBox(){
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(popUpBox));
    }

    public String getBoxText(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(popUpText));
        return popUpText.getText();
    }
}
