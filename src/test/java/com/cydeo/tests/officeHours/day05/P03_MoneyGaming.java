package com.cydeo.tests.officeHours.day05;

import com.cydeo.tests.base.TestBase;
import org.apache.commons.lang3.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P03_MoneyGaming extends TestBase {

    @Test
    public void moneyGaming() {

        /*
        Task IQ :  It is very slow website. Just try to locate your element and run.It will take 2-3 min to give result



        1. Navigate to: https://moneygaming.qa.gameaccount.com/
        2. Click the JOIN NOW button to open the registration page
        3. Select a title value from the dropdown
        4. Enter your first name and surname in the form
        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        6. Submit the form by clicking the JOIN NOW button
        7. Validate that a validation message with text "This field is required" appears under the date of birth box
        8. Validate that 18 "This field is required" messages  appears
         */

        //1. Navigate to: https://moneygaming.qa.gameaccount.com/
        driver.get("https://moneygaming.qa.gameaccount.com/");

        //2. Click the JOIN NOW button to open the registration page
        // joinNow -- css --.newUser.green
        driver.findElement(By.cssSelector(".newUser.green")).click();

        //3. Select a title value from the dropdown
        //select[@name="map(title)"]
        //select[@id="title"]
        // css --> .title.required
        WebElement titleDropdown = driver.findElement(By.xpath("//select[@name=\"map(title)\"]"));
        Select select=new Select(titleDropdown);


        select.selectByVisibleText("Mr");
       //  select.deselectByVisibleText("Mr");   -- >
        // java.lang.UnsupportedOperationException: You may only deselect options of a multi-select


        //4. Enter your first name and surname in the form
        // name     --    //input[@name="map(firstName)"]
        // surname  -- //input[@name="map(lastName)"]
        driver.findElement(By.xpath("//input[@name=\"map(firstName)\"]")).sendKeys("Mike");
        driver.findElement(By.xpath("//input[@name=\"map(lastName)\"]")).sendKeys("Smith");


        //5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        // -- checkbox - //input[@name='map(terms)']
        driver.findElement(By.xpath("//input[@name='map(terms)']")).click();


        //6. Submit the form by clicking the JOIN NOW button
        // joinNow -- //input[@id='form']
        driver.findElement(By.xpath("//input[@name='map(terms)']")).click();
        driver.findElement(By.xpath("//input[@id='form']")).click();
        //7. Validate that a validation message with text "This field is required" appears under the date of birth box
        //   //label[@for='dob']
        WebElement errorMessage = driver.findElement(By.xpath("//label[@for='dob']"));
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.isDisplayed());


        //8. Validate that 18 "This field is required" messages  appears
        // //label[.='This field is required']

        List<WebElement> allErrorMessages = driver.findElements(By.xpath("//label[.='This field is required']"));
        Assert.assertEquals(allErrorMessages.size(),18);


        /*

         //label[.='This field is required'][1]

         //label[.='This field is required'][2]
         //label[.='This field is required']3]

        ...
        ...
        ...
        ..
        .
        Create a for loop with index .In each iteration locate one of the element to use
         //label[.='This field is required'][i]
         */

    }
}
