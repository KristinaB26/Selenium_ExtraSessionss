package com.cydeo.tests.officeHours.day03;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

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

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes ");








        driver.quit();


    }
}
