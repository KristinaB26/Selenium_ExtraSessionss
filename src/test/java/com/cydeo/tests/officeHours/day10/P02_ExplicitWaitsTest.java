package com.cydeo.tests.officeHours.day10;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement start = driver.findElement(By.id("button00"));
        System.out.println(start.isEnabled());     // true

        WebElement one = driver.findElement(By.id("button01"));
        System.out.println(one.isEnabled());      // false

        WebElement two = driver.findElement(By.id("button02"));
        System.out.println(two.isEnabled());      // false

        WebElement three = driver.findElement(By.id("button03"));
        System.out.println(three.isEnabled());      // false


        start.click();
        wait.until(ExpectedConditions.elementToBeClickable(one));

        one.click();
        wait.until(ExpectedConditions.elementToBeClickable(two));

        two.click();
        wait.until(ExpectedConditions.elementToBeClickable(three));

        three.click();


    }
}
