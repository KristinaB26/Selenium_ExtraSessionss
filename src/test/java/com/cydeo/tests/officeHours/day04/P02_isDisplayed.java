package com.cydeo.tests.officeHours.day04;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P02_isDisplayed {
    @Test
    public void isDisplayedTest() {

// xpath ---> //small[.="first name must be more than 2 and less than 64 characters long"]
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        driver.get("http://practice.cydeo.com/registration_form");


        String xpathLocator="//small[.='first name must be more than 2 and less than 64 characters long']";

        WebElement errorMessage = driver.findElement(By.xpath(xpathLocator));

        System.out.println(errorMessage.getText());

        System.out.println(errorMessage.isDisplayed());

        // errorMessage.click(); -->  ElementNotInteractableException: element not interactable


        driver.findElement(By.name("firstname")).sendKeys("a");

       System.out.println(errorMessage.isDisplayed());

        System.out.println(errorMessage.getText());

        errorMessage.click();
        System.out.println("We clicked this elemenet without any exception since it is displayed");



        driver.quit();
    }


}
