package com.cybertek.tests.day2_Locaters_gitText_gitAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_FaceBookTitleVerifcation {
    public static void main(String[] args) {

     //TC #1: Facebook title verification
        // 1.Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // 3.Verify title
        // Expected: “Facebook -Log In or Sign Up”

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle =driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Facebook title verification passed! ");
        }else {
            System.out.println("Facebook title verification failed");
        }




    }


}
