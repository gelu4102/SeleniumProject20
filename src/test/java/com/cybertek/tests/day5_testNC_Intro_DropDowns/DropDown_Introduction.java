package com.cybertek.tests.day5_testNC_Intro_DropDowns;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown_Introduction {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void dropdown_test_1()throws InterruptedException{
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        //  WE MUST LOCATE THE DROPDOWN THEN PASS IT INTO SELECT CONSTRUCTOR

        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
        //return type is web element
        String actualSelectedOption = simpleDropdown.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Please select an option";

        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);

        Thread.sleep(2000);
        simpleDropdown.selectByVisibleText("Option 2");

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
    }
}
