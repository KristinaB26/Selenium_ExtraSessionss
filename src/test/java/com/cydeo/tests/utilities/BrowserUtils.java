package com.cydeo.tests.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserUtils {

    /**
     * A method to pause the thread certain seconds
     * @param seconds
     */
    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static List<String> getElementsText(List<WebElement> elements) {


        List<String> elementsText=new ArrayList<>();

        for (WebElement element : elements) {
            elementsText.add( element.getText());
        }

       return elementsText;
    }


    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

      return elements.stream().map(x->x.getText()).collect(Collectors.toList());
    }
}
