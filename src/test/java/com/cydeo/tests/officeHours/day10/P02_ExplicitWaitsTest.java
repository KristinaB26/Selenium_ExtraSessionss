package com.cydeo.tests.officeHours.day10;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P02_ExplicitWaitsTest extends TestBase {
    @Test
    public void test1() {
    /*
    	Task 1

		- Go to "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html"
		- Click buttons in order
		- Verify messages are equal after click all buttons
				- All Buttons Clicked
				- Clickable Buttons
				- Click Buttons In Order
     */

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");


        WebElement start = driver.findElement(By.id("button00"));
        System.out.println(start.isEnabled());     // true

        WebElement one = driver.findElement(By.id("button01"));
        System.out.println(one.isEnabled());      // false

        WebElement two = driver.findElement(By.id("button02"));
        System.out.println(two.isEnabled());      // false

        WebElement three = driver.findElement(By.id("button03"));
        System.out.println(three.isEnabled());      // false


        start.click();
        //wait.until(ExpectedConditions.elementToBeClickable(one));
        BrowserUtils.waitForClickablility(one,10);

        one.click();
        wait.until(ExpectedConditions.elementToBeClickable(two));

        two.click();
        wait.until(ExpectedConditions.elementToBeClickable(three));

        three.click();

        // locator for texts buttonmessage


        String expectedResult = "All Buttons Clicked";
        String actualResult = driver.findElement(By.cssSelector("#buttonmessage")).getText();
        Assert.assertEquals(actualResult,expectedResult);

        // Assert.assertEquals(driver.findElement(By.cssSelector("#buttonmessage")).getText(),expectedResult);



         expectedResult = "Clickable Buttons";
         wait.until(ExpectedConditions.textToBe(By.cssSelector("#buttonmessage"),"Clickable Buttons"));
         actualResult = driver.findElement(By.cssSelector("#buttonmessage")).getText();
         Assert.assertEquals(actualResult,expectedResult);




         expectedResult = "Click Buttons In Order";
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#buttonmessage"),"Click Buttons In Order"));
        actualResult = driver.findElement(By.cssSelector("#buttonmessage")).getText();
        Assert.assertEquals(actualResult,expectedResult);



    }
}
