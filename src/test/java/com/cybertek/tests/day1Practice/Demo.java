package com.cybertek.tests.day1Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demo {

            static WebDriver driver;

    @BeforeClass
    public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
   @AfterClass
   public void tearDown(){
        driver.close();
   }

   @Test
    public void test1(){
         driver.get("https://www.facebook.com/");
//        driver.findElement(By.id("email")).sendKeys("7086327506");
//        driver.findElement(By.id("pass")).sendKeys("gelu1101", Keys.ENTER);
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       String actual = driver.getTitle();
       String expected = "Facebook - Log In or Sign Up";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       Assert.assertEquals(expected, actual);


   }
}
