package com.cybertek.tests.day8_Iframes_Windows;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
  1. Create a new class called: IframePractice
    2. Create new test and make set ups
    3. Go to: http://practice.cybertekschool.com/iframe
    4. Assert: “Your content goes here.” Text is displayed.
    5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
     */

public class IframePractice {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }
    @Test
    public void p4_iframe_Practice(){
       //3 ways of locating and switching an IFRAME.
       //1- ByIndex
        //driver.switchTo().frame(0);

        //2- ById or name
        //driver.switchTo().frame("mce_0_ifr");

        //3- Locate as a web element,then switch to it
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
//Locating paragraph tag as a web element
        WebElement yourContentGoesHereText = driver.findElement(By.xpath("//p"));

        //Assert that the text is displayed on the page
        Assert.assertTrue(yourContentGoesHereText.isDisplayed(), "Text is not displayed. Verification FAILED!!!");

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();

        WebElement headerText= driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed(), "Header text is not displayed. Verification FAILED!!!");






    }



    }
