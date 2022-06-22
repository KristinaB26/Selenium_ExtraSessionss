package com.cydeo.tests.officeHours.day08;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P02_WebTables extends TestBase {
    @Test
    public void getHeaders() {


        /*

	   Task 1  -- Example 1 Table

	        - Open "http://practice.cydeo.com/tables"
	        - Print out all table headers
	        - Verify
	        		- Table has 6 header

         */


        driver.get(ConfigurationReader.getProperty("tablesUrl"));

        // table headers -- xpath --//table[@id='table1']//span

        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='table1']//span"));

        System.out.println("allHeaders.size() = " + allHeaders.size());

        for (WebElement eachHeader : allHeaders) {
            System.out.println(eachHeader.getText());
        }


        Assert.assertEquals(allHeaders.size(),6);

    }

    @Test
    public void getRow() {

        /*
          Task 2  -- Example 1 Table

	        - Open "http://practice.cydeo.com/tables"
	        - Print out all table information
	        - Verify
	        		- Table has 4 row
         */
        driver.get(ConfigurationReader.getProperty("tablesUrl"));

        // second row information
        // xpath -- //table[@id='table1']/tbody/tr[2]

        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());

        // get me all row information
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRows.size());

        /*
        for (int i = 1; i <= allRows.size(); i++) {
            String eachRowPath="//table[@id='table1']/tbody/tr["+i+"]";

            System.out.println(driver.findElement(By.xpath(eachRowPath)).getText());


        }

         */

        for (WebElement eachRow : allRows) {
            System.out.println(eachRow.getText());
        }

        Assert.assertEquals(allRows.size(),4);


    }
}
