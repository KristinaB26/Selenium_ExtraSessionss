package com.cydeo.tests.officeHours.day04;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P03_Day6Hw {
    @Test
    public void test01() throws InterruptedException {

        /*

        Task for Etsy

		TC: Etsy checkbox and radio button
		1. Go to https://www.etsy.com
		2. Search for “wooden spoon”
		3. Click on filters
		4. Select free shipping, on sale
		5. Select under $25 Click on apply filters
		6. Print count of results


         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);




        //1. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");


        //2. Search for “wooden spoon”
        // search area --> xpath --> //input[@data-id="search-query"]
        // use Keys.ENTER to search
        WebElement searchArea = driver.findElement(By.xpath("//input[@data-id=\"search-query\"]"));
        searchArea.sendKeys("wooden spoon"+ Keys.ENTER);


        //3. Click on filters
        // filter --> xpath --> //span[.="All Filters"]
        driver.findElement(By.xpath("//span[.=\"All Filters\"]")).click();


        //4. Select free shipping, on sale
        // name --> free_shipping
        driver.findElement(By.xpath("//label[@for=\"special-offers-free-shipping\"]")).click();

        driver.findElement(By.xpath("//label[@for='special-offers-on-sale']")).click();

        //5. Select under $25 Click on apply filters

        driver.findElement(By.xpath("//label[@for='price-input-1']")).click();
        driver.findElement(By.xpath("//button[@aria-label=\"Apply\"]")).click();

        //6. Print count of results
        // xpath ---> //span[contains(text(),"results,")]
        Thread.sleep(3000);
        String result = driver.findElement(By.xpath("//span[contains(text(),\"results,\")]")).getText();

        System.out.println(result);
        driver.quit();

    }
}
