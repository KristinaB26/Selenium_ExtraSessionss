package com.cydeo.tests.avengerHours.day1;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

/*
1-navigate to website "http://www.uitestpractice.com/";
2-click on Home tab
3-search for the name "Mike Johnson"
4-Verify "There are zero students with this search text Page 0 of 0" msg displayed on page
 */
public class P02_SearchName extends TestBase {

    @Test
    public void test() {
        //1-navigate to website "http://www.uitestpractice.com/";
        driver.navigate().to("http://www.uitestpractice.com/");

        //2-click on Home tab
        WebElement homeTab = driver.findElement(By.linkText("Home"));
        homeTab.click();

        //3-search for the name "Mike Johnson"
        WebElement searchBox = driver.findElement(By.cssSelector("#Search_Data"));
        searchBox.sendKeys("Mike Johnson");
//searchBox.sendKeys("Mike Johnson" + Keys.ENTER);

        WebElement findBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        findBtn.click();


        //4-Verify "There are zero students with this search text Page 0 of 0" msg displayed on page

        WebElement msgText = driver.findElement(By.xpath("//div[2]/div[1]"));

        System.out.println(msgText.getText());

        String expected = "There are zero students with this search text Page 0 of 0";

        Assert.assertTrue(msgText.getText().contains(expected));

    }
}
