package com.cydeo.tests.officeHours.day03;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_Day3Hw2 {
    public static void main(String[] args) {

        /*

    DAY3- HOMEWORK2
        TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        1- Open a chrome browser
        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        3- Enter incorrect username into login box:
        4- Click to `Reset password` button
        5- Verify “error” label is as expected
        Expected: Login or E-mail not found

         */



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");


        //3- Enter incorrect username into login box:
        //loginBox XPath (//input[@class="login-inp"])[1]

        WebElement loginBox = driver.findElement(By.xpath("(//input[@class=\"login-inp\"])[1]"));
        loginBox.sendKeys("user");

        WebElement resetButton = driver.findElement(By.cssSelector(".login-btn"));
        resetButton.click();

        WebElement error = driver.findElement(By.cssSelector(".errortext"));
        String actualText = error.getText();
        String expectedText = "Login or E-mail not found";


        if(actualText.equals(expectedText))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");


        driver.quit();


    }
}
