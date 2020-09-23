package com.cybertek.tests.day2_Locaters_gitText_gitAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationsAndTitleVerification {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation
        //1- Open a chrome browser
        //setting up the browser driver
        WebDriverManager.chromedriver().setup();
        //open browser and create an instance of the driver
        WebDriver driver = new ChromeDriver();
        //2- Go to: https://www.google.com
        driver.get("https://www.google.com");
        //3- Click to Gmail from top right.
        //4- Verify title contains:
        //Expected: Gmail
        //5- Go back to Google by using the .back();
        //6- Verify title equals:
        //Expected: Google

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();


        if (actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google title verification PASSED!");
        }else{
            System.out.println("Google title verification FAILED!!!");
        }

    }

}

