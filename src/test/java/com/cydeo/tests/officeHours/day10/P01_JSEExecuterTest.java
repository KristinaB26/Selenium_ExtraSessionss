package com.cydeo.tests.officeHours.day10;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P01_JSEExecuterTest extends TestBase {
    @Test
    public void techCrunch() {
        /*
        	 Task 1


       - Go to  "https://techcrunch.com/"
       - Click TechCrunch from Footer > About > TechCrunch
       - Verify title contains "TechCrunch"

         */

        driver.get("https://techcrunch.com/");

        WebElement techCrunch = driver.findElement(By.xpath("//a[@data-ga-event-label=\"TechCrunch\"]"));


        JavascriptExecutor jse=(JavascriptExecutor)driver;


        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(0,250)");
            BrowserUtils.waitFor(1);
        }


        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollBy(0,-250)");
            BrowserUtils.waitFor(1);
        }



        jse.executeScript("arguments[0].scrollIntoView(true)",techCrunch);

        BrowserUtils.waitFor(3);
        techCrunch.click();


    }


    @Test
    public void etsyTask() {





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
        JavascriptExecutor jse=(JavascriptExecutor)driver;


        WebElement free_shipping = driver.findElement(By.name("free_shipping"));
        // free_shipping.click();  -> it gives ElementClickInterceptedException

        jse.executeScript("arguments[0].click()",free_shipping);
        BrowserUtils.waitFor(3);

        driver.findElement(By.xpath("//button[@aria-label=\"Apply\"]")).click();

        //6. Print count of results
        // xpath ---> //span[contains(text(),"results,")]

        BrowserUtils.waitFor(3);
        String result = driver.findElement(By.xpath("//span[contains(text(),\"results,\")]")).getText();

        System.out.println(result);

    }
}
