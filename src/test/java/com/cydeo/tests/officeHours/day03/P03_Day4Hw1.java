package com.cydeo.tests.officeHours.day03;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_Day4Hw1 {
    public static void main(String[] args) {


        /*
        	TC #3: Practice Cydeo/ForgotPassword URL verification
	1. Open Chrome browser
	2. Go to http://practice.cydeo.com/forgot_password
	3. Enter any email into input box
	4. Click on Retrieve password
	5. Verify URL contains:
	Expected: “email_sent”
	6. Verify textbox displayed the content as expected.
	Expected: “Your e-mail’s been sent!”
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cydeo.com/forgot_password");

        // inputbox  xpath //input[@type='text']

        WebElement inputbox = driver.findElement(By.xpath("//input[@type='text']"));
        inputbox.sendKeys("miketest@gmail.com");

        WebElement retrievePassword = driver.findElement(By.xpath("//i[.=\"Retrieve password\"]"));
        retrievePassword.click();

        String expectedUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrl))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");

        WebElement message = driver.findElement(By.xpath("//*[.=\"Your e-mail's been sent!\"]"));
        String actualText = message.getText();
        String expectedText="Your e-mail's been sent!";

        if(actualText.equals(expectedText))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");


        driver.quit();


    }
}
