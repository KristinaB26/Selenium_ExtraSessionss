package com.cydeo.tests.officeHours.day09;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class P02_Actions extends TestBase {




    @Test
    public void test1() throws InterruptedException {

         /*
     Task 1

       - Go to  "http://automationpractice.com/index.php"
       - Hover over on Dresses button
       - Verify following subCategories are displayed

       				Casual Dresses
       				Evening Dresses
       				Summer Dresses
     */

        driver.get("http://automationpractice.com/index.php");

        // Dresses -- xpath --> (//a[@title="Dresses"])[2]

        WebElement dresses = driver.findElement(By.xpath("(//a[@title=\"Dresses\"])[2]"));

        // all subCategoris --> (//a[@title="Dresses"])[2]/..//li

        List<WebElement> subCategories = driver.findElements(By.xpath("(//a[@title=\"Dresses\"])[2]/..//li"));


        for (WebElement subCategory : subCategories) {
            System.out.println(subCategory.isDisplayed());
        }


        actions.moveToElement(dresses).perform();


        Thread.sleep(3000);

        for (WebElement subCategory : subCategories) {
            System.out.println(subCategory.isDisplayed());
            Assert.assertTrue(subCategory.isDisplayed());
        }




    }


    @Test
    public void test2() {

        /*

     Task 2

 	   - Go to  "https://www.globalsqa.com/demo-site/draganddrop/"
       - Drag and Drop "High Tatras" and "High Tatras 2" into "Trash"
       - Verify Trash has 2 photo
         */

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        //iframe
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
        driver.switchTo().frame(iframe);


        // Extra practice
        // to get Text of this picture

        List<WebElement> elements = driver.findElements(By.xpath("//h5[contains(.,\"High\")]"));

        System.out.println(BrowserUtils.getElementsText(elements));

        System.out.println(BrowserUtils.getElementsTextWithStream(elements));


        // Tasks


        // first
        //h5[.="High Tatras"]
        WebElement first = driver.findElement(By.xpath("//h5[.=\"High Tatras\"]"));

        // second
       //h5[.="High Tatras 2"]
        WebElement second = driver.findElement(By.xpath("//h5[.=\"High Tatras 2\"]"));

        // trash
        // css --> #trash

        WebElement trash = driver.findElement(By.cssSelector("#trash"));


        // drag first picture

        actions.dragAndDrop(first,trash).perform();

        // drag second picture


        actions.moveToElement(second).clickAndHold().moveToElement(trash).pause(3000).release().perform();

        // trash elements --xpath -- //div[@id='trash']//li


        BrowserUtils.waitFor(3);
        List<WebElement> trashElements = driver.findElements(By.xpath("//div[@id='trash']//li"));


        Assert.assertTrue(trashElements.size()==2);

    }
    @Test
    public void keyboardAction() {
        Actions actions=new Actions(driver);

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        // enter password
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        // click login
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));


        actions.moveToElement(username).click()
                .keyDown(Keys.SHIFT)
                .sendKeys("test")
                .keyUp(Keys.SHIFT)
                // .doubleClick()    // choose all text
                .keyDown(Keys.COMMAND).sendKeys("A")
                .keyUp(Keys.COMMAND)
                .pause(3000)
                .keyDown(Keys.COMMAND).sendKeys("C")
                .keyUp(Keys.COMMAND)
                .pause(3000)
                .sendKeys(Keys.TAB)
                .keyDown(Keys.COMMAND).sendKeys("V")
                .keyUp(Keys.COMMAND)
                .pause(3000)
                .moveToElement(loginButton)
                .click()
                .perform();


        String actualText = driver.findElement(By.cssSelector(".error")).getText();

        String expectedText="Invalid Login or Password.";

        Assert.assertEquals(expectedText, actualText);


    }
}
