package com.cydeo.tests.officeHours.day09;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_FileUpload extends TestBase {
    @Test
    public void test1() {


        // choose File -- > id --> fileinput

        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        WebElement chooseFile = driver.findElement(By.cssSelector("#fileinput"));

        String path="/Users/soyturk/IdeaProjects/B26/Selenium_ExtraSessions/Selenium_ExtraSessions/src/test/resources/fileUpload/UploadTest.txt";

        chooseFile.sendKeys(path);




        // general file --id -- #itsafile
        driver.findElement(By.cssSelector("#itsafile")).click();


        chooseFile.submit();

        /*
        If this current element is a form, or an element within a form, then this will be submitted to the remote server.
         If this causes the current page to change, then this method will block until the new page is loaded.
         */

        // upload -- xpath --//input[@type='submit']

        /*
        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='submit']"));
        uploadButton.click();

         */

        // result -- class -- .explanation

        String expectedResult = "You uploaded a file. This is the result.";
        String actualText = driver.findElement(By.cssSelector(".explanation")).getText();

        Assert.assertEquals(actualText,expectedResult);

    }
}
