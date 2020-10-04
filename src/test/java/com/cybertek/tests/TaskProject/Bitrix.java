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
        driver.findElement(By.xpath("(//span[.='Message'])[1]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("(//span[@title='Add mention'])[1]")).click();

        driver.findElement(By.xpath("(//div[@class='bx-finder-box-item-t7-name'])[1]")).click();
        BrowserUtils.wait(2);

        //driver.findElement(By.xpath("(//a[@class='feed-add-destination-link'])[1]")).click();
       // driver.findElement(By.xpath("(//div[@class='bx-finder-box-item-t7-name'])[2]")).click();

        //driver.findElement(By.xpath("//span[@class='popup-window-close-icon']")).click();

        //WebElement contactAdded = driver.findElement(By.className("bxhtmled-metion"));


        //System.out.println(contactAdded.getText());

        //String expectedResult = "hr100@cybertekschool.com";
       // String actualResult = contactAdded.getText();

       // Assert.assertEquals(actualResult,expectedResult,"Contact Add Mention Verification FAILED!!");




    }


}
