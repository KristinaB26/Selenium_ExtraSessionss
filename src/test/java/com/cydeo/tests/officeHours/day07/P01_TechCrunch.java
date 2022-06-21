package com.cydeo.tests.officeHours.day07;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P01_TechCrunch extends TestBase {
    @Test
    public void testCrunch() {
        /*
        IQ : TECH CRUNCH

    Using any test automation framework, Java language (except record/play tools) and Maven dependency management, please do following:

	1- Go to https://techcrunch.com/
	2- For “The Latest News” list, verify followings;
		a. each news has an author
		b. each news has an image
	3- Click one of news from “The Latest News” list to reach the full content and verify followings;
		a. the browser title is the same with the news title
		b. the links within the news content

         */

        // author -- xpath --       //span[@class='river-byline__authors']//a
        // Dynamic  (//span[@class='river-byline__authors']//a)[5]

        // img    -- xpath --       //div[@class="river river--homepage "]//img
       // Dynamic --> (//div[@class="river river--homepage "]//img)[5]



        driver.get(ConfigurationReader.getProperty("techCrunch"));

        List<WebElement> authorList = driver.findElements(By.xpath("//span[@class='river-byline__authors']//a"));

        List<WebElement> imgList = driver.findElements(By.xpath("//div[@class=\"river river--homepage \"]//img"));


        for (int i = 0; i <authorList.size(); i++) {

            Assert.assertTrue(authorList.get(i).isDisplayed());
            Assert.assertTrue(imgList.get(i).isDisplayed());

        }


        /*
        3- Click one of news from “The Latest News” list to reach the full content and verify followings;
		a. the browser title is the same with the news title
		b. the links within the news content
         */


        // article - xpath -- //article[@class="post-block post-block--image post-block--unread"]

        List<WebElement> latestNews = driver.findElements(By.xpath("//article[@class=\"post-block post-block--image post-block--unread\"]"));

        /* if you have Exception to click use this code block

          // iframe

        // id -- offer_724e67ad478b6fa1c300-0

        driver.switchTo().frame("offer_724e67ad478b6fa1c300-0");

        // close pop up

        driver.findElement(By.cssSelector(".pn-ribbon__close")).click();

        //turn back main HTML

        driver.switchTo().defaultContent();

         */



        latestNews.get(5).click();

        // title -- xpath -- //h1[@class="article__title"]

        String expectedTitle = driver.findElement(By.xpath("//h1[@class=\"article__title\"]")).getText();

        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));



        // links -- xpath -- //div[@class='article-content']//a

        List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='article-content']//a\n"));


        Assert.assertTrue(allLinks.size()>0);

        for (WebElement eachLink : allLinks) {
            System.out.print(eachLink.getText());
            System.out.println("------> "+eachLink.getAttribute("href"));
        }

    }
}
