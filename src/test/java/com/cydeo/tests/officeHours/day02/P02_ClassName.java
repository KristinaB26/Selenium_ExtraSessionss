package com.cydeo.tests.officeHours.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.test.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

public class P02_ClassName {
    public static void main(String[] args) throws InterruptedException {

        /*

	1- Open a chrome browser
	2- Go to: https://practice.cydeo.com/
	3- Get Text of Test Automaton Practice
	4- Locate A/B Testing
	5- Click on A/B Testing
	6- Verify title is "No A/B Test"

         */


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/");


        // Get Text of Test Automaton Practice

        WebElement element = driver.findElement(By.className("h1y"));
        String textFromElement = element.getText();
        System.out.println(textFromElement);

        // Locate A/B Testing
        WebElement abTesting = driver.findElement(By.partialLinkText("A/B"));
        abTesting.click();

        // getTitle
        String title = driver.getTitle();
        System.out.println(title);

        if(title.equals("No A/B Test"))
            System.out.println("PASSED");
        else
            System.out.println("FAILED");



        driver.quit();



    }
}
