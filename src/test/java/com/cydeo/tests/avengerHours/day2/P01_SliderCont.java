package com.cydeo.tests.avengerHours.day2;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
            1-Navigate to "http://www.uitestpractice.com/"
            2-Verify number "20" is not displayed in "Slider Control" part of the page
            3-Move to right the Slider Handle and make number "20" visible
            4-Now verify number "20" is displayed in "Slider Control" part of the page
 */
public class P01_SliderCont extends TestBase {

    @Test
    public void slider() throws InterruptedException {
        //1-Navigate to "1-Navigate to "http://www.uitestpractice.com/""
        driver.get(ConfigurationReader.getProperty("uiTestURL"));

        //2-Verify number "20" is not displayed in "Slider Control" part of the page
        WebElement twenty = driver.findElement(By.xpath("//div[.='20']"));
        Assert.assertFalse(twenty.isDisplayed());
        //Assert.assertEquals(twenty.isDisplayed(),false);

        // 3-Move to right the Slider Handle and make number "20" visible
        WebElement sliderHandle = driver.findElement(By.cssSelector(".ui-slider-handle.ui-state-default.ui-corner-all"));

        actions.moveToElement(sliderHandle).clickAndHold().moveByOffset(700,0).perform();

        // 4-Now verify number "20" is displayed in "Slider Control" part of the page
        Thread.sleep(3000);
        Assert.assertTrue(twenty.isDisplayed());


    }



}
