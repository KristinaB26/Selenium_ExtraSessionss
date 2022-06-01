package com.cydeo.tests.officeHours.day03;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_Day3Hw1 {
    public static void main(String[] args) {


        /*


        DAY3- HOMEWORK1

        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/
        3- Verify “remember me” label text is as expected:
        Expected: Remember me on this computer
        4- Verify “forgot password” link text is as expected:
        Expected: Forgot your password?
        5- Verify “forgot password” href attribute’s value contains expected:
        Expected: forgot_password=yes
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // Remember me with Xpath
        ////label[.="Remember me on this computer"]

        driver.get("https://login1.nextbasecrm.com/");
        WebElement rememberMe = driver.findElement(By.xpath("//label[.=\"Remember me on this computer\"]"));
        String actualText = rememberMe.getText();
        String expectedText = "Remember me on this computer";

        if(actualText.equals(expectedText))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");

        // forgot password with CSS
        //.login-link-forgot-pass

        WebElement forgotPass = driver.findElement(By.cssSelector(".login-link-forgot-pass"));
         actualText = forgotPass.getText();
         expectedText = "FORGOT YOUR PASSWORD?";

         if(actualText.equals(expectedText))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");

        String actualHref = forgotPass.getAttribute("href");
        String extepectedHref = "forgot_password=yes";

        if(actualHref.contains(extepectedHref))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");

        driver.quit();

    }
}
