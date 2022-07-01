package com.cydeo.tests.pages;



import com.cydeo.tests.utilities.BrowserUtils;
import com.cydeo.tests.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class AdidasPage {

    public AdidasPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement purchasePrice;

    //a[.='Add to cart']
    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addCart;


    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrder;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;


    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;

   @FindBy(xpath = "//p[@class='lead text-muted ']")
   public WebElement confirmation;


    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    public WebElement OK;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> allProductFromCart;


    public void fillForm() {
        Faker faker=new Faker();

        name.sendKeys(faker.name().fullName());
        country.sendKeys(faker.country().name());
        city.sendKeys(faker.country().capital());
        card.sendKeys(faker.finance().creditCard());
        month.sendKeys(String.valueOf(faker.number().numberBetween(1, 12)));
        year.sendKeys(String.valueOf(faker.number().numberBetween(2022, 2030)));

    }

    public int addProduct(String categoryName,String productName) {

         /*

        Locator for categories

        //a[.="categoryName"]

        Locator for products

        //a[.="productsName"]


         */
        String categoryLocator="//a[.='"+categoryName+"']";
        String productLocator="//a[.='"+productName+"']";

        Driver.getDriver().findElement(By.xpath(categoryLocator)).click();
        BrowserUtils.waitFor(1);

        Driver.getDriver().findElement(By.xpath(productLocator)).click();
        BrowserUtils.waitFor(1);

        String priceString = purchasePrice.getText();
        System.out.println(priceString);

       /*
       Time for java to make manipulation
        */
        String[] split = priceString.split(" ");
        int price = Integer.parseInt(split[0].substring(1));

        System.out.println(price);


        addCart.click();
        /*
        BrowserUtils.waitFor(2);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();

        we acn use BrowserUtils method to wait alerts dynamicly
         */

        BrowserUtils.waitForAlertIsPresent(10);
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();



        homeLink.click();

        return price;



    }


    public int removeProduct(String productName) {


        String priceForProductLocator="//tbody//td[.='"+productName+"']/../td[3]";

        String price = Driver.getDriver().findElement(By.xpath(priceForProductLocator)).getText();


        String productDelete="//tbody//td[.='"+productName+"']/../td/a";

        Driver.getDriver().findElement(By.xpath(productDelete)).click();

        BrowserUtils.waitFor(3);


        return Integer.parseInt(price);



    }
}
