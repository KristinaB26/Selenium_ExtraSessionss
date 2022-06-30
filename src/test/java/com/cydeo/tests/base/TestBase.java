package com.cydeo.tests.base;

import com.cydeo.tests.utilities.Driver;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        //driver= WebDriverFactory.getDriver("chrome");
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);

        wait=new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
