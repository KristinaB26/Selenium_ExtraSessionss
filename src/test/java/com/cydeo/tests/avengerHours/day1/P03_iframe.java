package com.cydeo.tests.avengerHours.day1;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
1- Navigate to website : "http://www.uitestpractice.com/"
2- Type the name into "Enter your name" inputbox -> "Mike Johnson"
3- Retrieve the name from inputbox -> "Mike Johnson"
4- Click on the link "uitestpractice.com"
5- Verify "Drag and Drop control" menu is displayed in iframe
 */
public class P03_iframe extends TestBase {
/*
possible reasons for NSe
*locator might be wrong (dynamic or not correct) or changed by developer
*no enough wait time (that is why we use implicitly wait)
*iframe
 */
    @Test
    public void test(){
        driver.get("http://www.uitestpractice.com/");

        //2- Type the name into "Enter your name" inputbox -> "Mike Johnson"


        driver.switchTo().frame("iframe_a");
        WebElement inputBox = driver.findElement(By.xpath("//body/input[@id='name']"));
        inputBox.sendKeys("MikeJohnson");


       //3- Retrieve the name from inputbox -> "Mike Johnson"
        System.out.println(inputBox.getAttribute("value"));
        System.out.println(inputBox.getAttribute("localName"));


        //Click on the link "uitestpractice.com"
        driver.switchTo().defaultContent();
        WebElement link = driver.findElement(By.xpath("//a[@target='iframe_a']"));

        link.click();

        //5- Verify "Drag and Drop control" menu is displayed in iframe

        //again it is a part of iframe so we need to switch
        driver.switchTo().frame("iframe_a");

        WebElement drag_and_drop_control = driver.findElement(By.xpath("//h3[@style='color: crimson;']"));

        Assert.assertTrue(drag_and_drop_control.isDisplayed());
    }
}
