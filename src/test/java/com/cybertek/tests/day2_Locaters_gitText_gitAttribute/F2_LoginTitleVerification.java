package com.cybertek.tests.day2_Locaters_gitText_gitAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_LoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        //TC #2: Facebook incorrect login title verification
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        //Create instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        // 2.Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        //we are going to have to locate
        //some web element to be able to send data to them
        // 3.Enter incorrect username
        driver.findElement(By.id("email")).sendKeys("anything@gmail.com");
        // 4.Enter incorrect password
        driver.findElement(By.id("pass")).sendKeys("asdfasdf"+ Keys.ENTER);
        // 5.Verify title changed to:
        // Expected: “Log into Facebook | Facebook”

        String expectedTitle = "Log into Facebook | Facebook";
        Thread.sleep(5000);
        String actualTitle =driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }

    }
}
