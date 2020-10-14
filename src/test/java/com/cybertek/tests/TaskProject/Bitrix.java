package com.cybertek.tests.TaskProject;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bitrix {

    WebDriver driver;

    @BeforeMethod
    public void login_to_bitrix_page(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        driver.manage().window().maximize();
        WebElement UserName = driver.findElement(By.name("USER_LOGIN"));
        UserName.sendKeys("helpdesk6@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser"+ Keys.ENTER);


    }

    @Test
    public void addMentionButton(){
        //Given I am on the "Activity Stream"
        //When I click on the "Message" button
        driver.findElement(By.xpath("(//span[.='Message'])[1]")).click();

        //Then I should be able to see the blank message page
        BrowserUtils.wait(2);
        //When I hover to the bottom of the blank message page
        //Then I should be able to locate "Add Mention" feature
        driver.findElement(By.xpath("(//span[@title='Add mention'])[1]")).click();

        //And I should be able to click "Add Mention"
        driver.findElement(By.xpath("(//div[@class='bx-finder-box-item-t7-name'])[1]")).click();
        BrowserUtils.wait(2);
        /*
        //driver.findElement(By.xpath("(//a[@class='feed-add-destination-link'])[1]")).click();
       // driver.findElement(By.xpath("(//div[@class='bx-finder-box-item-t7-name'])[2]")).click();

        //driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();

        //WebElement contactAdded = driver.findElement(By.className("bxhtmled-metion"));


        //System.out.println(contactAdded.getText());

        //String expectedResult = "hr100@cybertekschool.com";
       // String actualResult = contactAdded.getText();

       // Assert.assertEquals(actualResult,expectedResult,"Contact Add Mention Verification FAILED!!");
        */


        //Then I should be able to see list of contacts
        //When I select a contact from the list of contacts
        //Then I should be able to add the selected contacts to "Add Mention"
        driver.findElement(By.xpath("//button[@id = 'blog-submit-button-save']")).click();

        WebElement AddMention = driver.findElement(By.xpath("(//a[@class='feed-add-post-destination-new'])[1]"));
        //System.out.println(AddMention);
        BrowserUtils.wait(3);
        String actualValue = AddMention.getText();
        System.out.println(actualValue);
        String expectedValue = "hr75@cybertekschool.com";
        //asserting the expected value with the actual value
        Assert.assertEquals(actualValue,expectedValue,"Add Mention verification FAILED!!!");


    }


}
