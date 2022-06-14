package com.cydeo.tests.officeHours.day06;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P02_iFrame extends TestBase {

    @Test
    public void frameEx() {
        /*
        Task 1

			- Open "https://demoqa.com/frames"
			- Verify child frames texts are equal : "This is a sample page"

         */

        driver.get("https://demoqa.com/frames");

        //switch frame -- id -- frame1
        driver.switchTo().frame("frame1");

        // sampleHeading
        WebElement sampleHeading = driver.findElement(By.cssSelector("#sampleHeading"));
        String actual = sampleHeading.getText();
        String expected = "This is a sample page";

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void nestedFrames() {

        /*

		Task 2

			- Open "http://practice.cybertekschool.com/nested_frames"
			- Switch to middle frame
			- Verify text is equal "MIDDLE"
		    - Switch to right frame
		    - Verify text is equal "RIGHT"
		    - Switch to bottom frame
		    - Verify text is equal "BOTTOM"
         */

        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("----- MIDDLE-----");
        String middle = driver.findElement(By.cssSelector("#content")).getText();

        Assert.assertEquals(middle,"MIDDLE");

        // driver.switchTo().frame("frame-right"); -- first we need to go parent FRame


        driver.switchTo().parentFrame();  // frame-top
        driver.switchTo().frame(2);    // frame -right


        System.out.println("----- RIGHT-----");

        String right = driver.findElement(By.tagName("body")).getText();
        Assert.assertEquals(right,"RIGHT");

        /*
        driver.switchTo().parentFrame();  // frame-top
        driver.switchTo().parentFrame();  // main html

         */
        driver.switchTo().defaultContent();  // main html

        System.out.println("----- BOTTOM-----");
        driver.switchTo().frame(1);

        String bottom = driver.findElement(By.tagName("body")).getText();
        Assert.assertEquals(bottom,"BOTTOM");



    }
}
