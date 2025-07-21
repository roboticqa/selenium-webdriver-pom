package com.roboticqa;

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

        driver.get("https://roboticqa.com/");

        driver.manage().window().maximize();

        driver.findElement(By.id("identifier")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("password123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@aria-label,'Notifications')]//li")));
        WebElement msg=driver.findElement(By.xpath("//div[text()='Welcome back!']"));
        Assert.assertEquals(msg.getText(),"Welcome back!");

        driver.close();

    }

}
