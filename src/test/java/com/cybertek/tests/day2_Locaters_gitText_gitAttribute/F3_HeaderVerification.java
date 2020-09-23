package com.cybertek.tests.day2_Locaters_gitText_gitAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_HeaderVerification {
    public static void main(String[] args) {
        //TC #3: Facebook header verification
        WebDriverManager.chromedriver().setup();

        // 1.Open Chrome browser
        WebDriver driver = new ChromeDriver();
        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        // 3.Verify header text is as expected:
        // Expected: “Connect with friends and the world around you on Facebook."
        String expectedHeaderText = "Connect with friends and the world around you on Facebook.";
        String actualHeaderText = driver.findElement(By.className("_8eso")).getText();
      // System.out.println( driver.findElement(By.className("_8eso")));
        //System.out.println( driver.findElement(By.className("_8eso")).getText());
        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header verification passed");
        }else {
            System.out.println("Header verification failed");
        }

    }
}
