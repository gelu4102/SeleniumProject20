package com.cybertek.Utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/*
In this class we will store utility methods that can be applied to any browser containt
Any time you fill like you have a good logic that you can use in the future,
create a method of it and store it in this class.
Then call it in the future to use it.
 */
public class BrowserUtils {
    /**
    Accepts a list of Web Element
    @param Lis<WebElement>
    @return List<String>
    Method should be returning a list of Strings
     */
    public static List<String> getElementText(List<WebElement>list){
       List<String> webElementAsString = new ArrayList<>();
        for (WebElement each : list) {
          webElementAsString.add(each.getText());
        }
        return webElementAsString;
    }

 /*
    Create a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that I pass as parameter should be accepted as SECONDS
    Handle checked exception with try/catch
     */

    public static void wait(int sec) {
        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception caught");
        }
    }
}


