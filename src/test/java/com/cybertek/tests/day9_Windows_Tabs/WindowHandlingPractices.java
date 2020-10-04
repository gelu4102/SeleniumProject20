package com.cybertek.tests.day9_Windows_Tabs;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");

    }

    /*
    TC5 # : Window Handle practice
    1. Create a new class called: WindowHandlePractice
    2. Create new test and make set ups
    3. Go to : http://practice.cybertekschool.com/windows
    4. Assert: Title is “Practice”
    5. Click to: “Click Here” text
    6. Switch to new Window.
    7. Assert: Title is “New Window”
     */

    @Test
    public void p5_handling_windows(){
        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        Assert.assertTrue(actualTitle.equals("Practice"));

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

       String mainHandle =  driver.getWindowHandle();

        System.out.println("mainHandle = " + mainHandle);
          //Set allows only unique values.
        //alt+enter for windows
        //option+enter for mac
        Set<String>windowHandles = driver.getWindowHandles();
         //we loop through the set of window handles so that we can get the window handle of other window
        //then using switch to().window()method we switch to the other window
        for (String each : windowHandles) {
            driver.switchTo().window(each);

            System.out.println("Current title = "+driver.getTitle());
            System.out.println("Current WINDOW HANDEL = "+driver.getWindowHandle());
        }

        //Getting the current(actual)title,and comparing with expected title
        Assert.assertTrue(driver.getTitle().equals("New Window"));

        BrowserUtils.wait(2);
       // driver.close();//driver close will close the current focused windoe/tab

        //If i want to switch back to main page ,to continue with some other actions:
        driver.switchTo().window(mainHandle);
        //driver.quit will close all the tabs that are opened in that session together.
        driver.quit();

    }

    @Test
    public void p6_handling_more_than_two_windows(){

        driver.get("https://amazon.com");
        //THIS LINE IS BASICALLY: we are downcasting our driver type to JavaScriptExecutor
        // The only
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current Page Title = "+driver.getTitle());

            if (driver.getCurrentUrl().contains("esty")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }
        }



    }



}
