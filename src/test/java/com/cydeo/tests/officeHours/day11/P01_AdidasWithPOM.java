package com.cydeo.tests.officeHours.day11;

import com.cydeo.tests.pages.AdidasPage;
import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class P01_AdidasWithPOM {

    /*
    SHOP: https://www.demoblaze.com/index.html


	• Customer navigation through product categories: Phones, Laptops and Monitors
	• Navigate to "Laptops" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
	• Click on "Place order".
	• Fill in all web form fields.
	• Click on "Purchase"
	• Capture and log purchase Id and Amount.
	• Assert purchase amount equals expected.
	• Click on "Ok"
	• Verify that there is no product in the cart


NOTE : We will create Page Object Model (POM) to solve this task

     */

    @Test
    public void adidas() {


        Driver.getDriver().get(ConfigurationReader.getProperty("adidasUrl"));


        AdidasPage adidasPage=new AdidasPage();

        int expectedPrice = adidasPage.addProduct("Laptops", "Sony vaio i5");
        expectedPrice += adidasPage.addProduct("Phones", "Samsung galaxy s6");
        expectedPrice += adidasPage.addProduct("Monitors", "Apple monitor 24");

        System.out.println(expectedPrice);

        adidasPage.cart.click();
        BrowserUtils.waitFor(1);

        expectedPrice -= adidasPage.removeProduct("Apple monitor 24");
        System.out.println("After delete product");

        System.out.println(expectedPrice);


        adidasPage.placeOrder.click();

        adidasPage.fillForm();

        adidasPage.purchaseButton.click();

        // STEPS AFTER THIS POINT IS SHARED


       //• Capture and log purchase Id and Amount.
        String confirmationMessage = adidasPage.confirmation.getText();
        System.out.println("confirmationMessage = " + confirmationMessage);

        //Manipulation to get data to get an array
        String[] confirmationArray = confirmationMessage.split("\n");
        System.out.println("Arrays.toString(confirmationArray) = " + Arrays.toString(confirmationArray));

        //get me ORDER ID
        String orderID=confirmationArray[0].substring(confirmationArray[0].indexOf(" ")+1);
        System.out.println("orderID = " + orderID);

        //get me TOTAL PRICE
        String[] totalPrice = confirmationArray[1].split(" ");
        System.out.println("Arrays.toString(totalPrice) = " + Arrays.toString(totalPrice));

        int actualPrice = Integer.parseInt(totalPrice[1]);

        System.out.println("actualPrice = " + actualPrice);
        System.out.println("expectedPrice = " + expectedPrice);

        //• Assert purchase amount equals expected.
        Assert.assertEquals(expectedPrice, actualPrice);
        BrowserUtils.waitFor(2);
        //• Click on "Ok"
        adidasPage.OK.click();
        BrowserUtils.waitFor(3);

        adidasPage.cart.click();

        //• Verify that there is no product in the cart
        /*

          We use table tr to get number of product from cart page
            @FindBy(xpath = "//tbody//tr")
            public List<WebElement> allProductFromCart;

          if there is no product it will return EMPTY list.It means there is no product in cart

         */
        System.out.println(adidasPage.allProductFromCart.size());
        BrowserUtils.waitFor(2);
        Assert.assertTrue(adidasPage.allProductFromCart.size()==0);




        Driver.closeDriver();
    }
}
