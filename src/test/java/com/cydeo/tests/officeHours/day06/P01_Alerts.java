package com.cydeo.tests.officeHours.day06;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_Alerts extends TestBase {

    @Test
    public void htmlAlerts() {

        /*

		Task 1  -- HTML POP UP

			- Open "https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126"
			- Click Confirm button
			- Click YES from pop up
			- Verify message equals "You have accepted"

         */
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=5f126");

        // confirm button -->  xpath --> //span[.="Confirm"]
        driver.findElement(By.xpath("//span[.=\"Confirm\"]")).click();

        // Yes button from pop up --> xpath --> //span[.="Yes"]
        driver.findElement(By.xpath("//span[.=\"Yes\"]")).click();

        // Verification message --> //p[.='You have accepted']
        String expected = "You have accepted";

        String actual = driver.findElement(By.xpath("//p[.='You have accepted']")).getText();

        Assert.assertEquals(actual,expected);


    }

    @Test
    public void jsAlerts() {

        /*
        Task 2  -- INFORMATION

			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Alert
			- Click OK button from Alert
			- Verify message equals "You have clicked on ok button in alert window"
         */
        driver.get("http://www.uitestpractice.com/Students/Switchto");

        // alert -- css --- #alert

        //  Alert alert=driver.switchTo().alert();  -- if there is no alert it will throw
        // NoAlertPresentException: no such alert
        System.out.println("---- INFORMATION-----");
        driver.findElement(By.cssSelector("#alert")).click();
        Alert alert=driver.switchTo().alert();
        // use Alert to handle it
        alert.accept();

        // Verify message is "You have clicked on ok button in alert window""
        WebElement message = driver.findElement(By.cssSelector("#demo"));
        String actual = message.getText();

        String expected="You have clicked on ok button in alert window";

        Assert.assertEquals(actual,expected);



        System.out.println("---- CONFIRMATION-----");

        /*
         Task 3  -- CONFIRM

			- Open "http://www.uitestpractice.com/Students/Switchto"
			- Click Confirm
			- Click Cancel button from Alert
			- Verify message equals "You pressed Cancel in confirm window"
         */

        // confirm with css --> #confirm
         driver.findElement(By.cssSelector("#confirm")).click();

        // Click cancel with Alert
         alert.dismiss();
        // Verify message "You pressed Cancel in confirm window"
        expected="You pressed Cancel in confirm window";
        // driver.navigate().refresh(); --> cause of this step message element will give StaleElemenException
        actual= message.getText();

        Assert.assertEquals(actual,expected);



        System.out.println("---- PROMPT-----");

    /*
        Task 4  -- PROMPT

                - Open "http://www.uitestpractice.com/Students/Switchto"
                - Click Prompt
                - Send name as "Mike" into this alert field
                - CLick OK
                - Verify  message contains "Mike"

     */

        // prompt -- css --   #prompt
        driver.findElement(By.cssSelector("#prompt")).click();

        String name ="Mike";

        // send name
        alert.sendKeys(name);

        // click OK
        alert.accept();

        // get actual data from webpage


        actual= message.getText();

        Assert.assertTrue(actual.contains(name));



    }
}
