package com.cydeo.tests.officeHours.day04;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P01_ImplicitWait {


    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();



        driver.get("http://practice.cydeo.com/dynamic_loading/4");

        //Thread.sleep(10000);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String helloWorldText = driver.findElement(By.cssSelector("#finish")).getText();

        System.out.println(helloWorldText);

        driver.quit();
    }



}
