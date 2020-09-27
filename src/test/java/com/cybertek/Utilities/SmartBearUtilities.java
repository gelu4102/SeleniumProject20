package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {
    //Mini-Task:
    //#1- Create a new class called : SmartBearUtilities
    //#2- Create a static method called loginToSmartBear
    //#3- This method simply logs in to SmartBear when you call it.
    //#4- Accepts WebDriver type as parameter

        public static void loginToSmartBear(WebDriver driver){
            //3. Enter username: “Tester”

            WebElement usernameInput = driver.findElement(By.id("ctl00_MainContent_username"));
            usernameInput.sendKeys("Tester");

            //4. Enter password: “test”
            WebElement passwordInput = driver.findElement(By.id("ctl00_MainContent_password"));
            passwordInput.sendKeys("test");
            //5. Click to Login button
            WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
            loginButton.click();
        }
//PRACTICE #4: Method: verifyOrder
// •Create a method named verifyOrderin SmartBearUtils class.
// •Method takes WebDriver object and String(name).
// •Method should verify if given name exists in orders.
// •This method should simply accepts a name(String), and assert whether given name is in the list or not.
// •Create a new TestNG test to test if the method is working as expected

    public static void verifyOrder(WebDriver driver,String name){

            List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));


         for (WebElement each : namesList) {
             if (each.getText().equals(name)){
                 Assert.assertTrue(true);
                 return;
             }
         }
         Assert.fail("Name does not exist in the list!");
     }


    }
