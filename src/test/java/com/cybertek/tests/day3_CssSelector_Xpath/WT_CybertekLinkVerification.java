package com.cybertek.tests.day3_CssSelector_Xpath;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WT_CybertekLinkVerification {
    public static void main(String[] args) {

        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
       // driver.findElement(By.name("email")).sendKeys("anyemail@domain.com");
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("anyemail@domain.com");

        // 4.Click on Retrieve password
        //driver.findElement(By.id("form_submit")).click();
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        // 5.Verify URL contains: Expected: “email_sent”
        //Expected: "email_sent"
        String expectedInRel = "email_sent";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInRel)) {

            System.out.println("URL verification PASSED!");
        }else {
            System.out.println("URL verification FAILED");
        }
        // 6.Verify text box displayed the content as expected.
        // Expected: "Your e-mail’s been sent!"
        //verify the text
        WebElement confirmationMassage = driver.findElement(By.name("confirmation_message"));

        String actualText = confirmationMassage.getText();
        String expectedText = "Your e-mail's been sent!";

        System.out.println("actualText = " + actualText);
        System.out.println("expectedText = " + expectedText);

        if (actualText.equals(expectedText)){
            System.out.println("Header text value verification PASSED!");
        }else {
            System.out.println("Header text value verification FAILED!!!");
        }
        //verify if the web element is displayed or not
        if (confirmationMassage.isDisplayed()){
            System.out.println("Confirmation message is displayed.verification PASSED!");
        }else {
            System.out.println("Confirmation message is NOT displayed.verification FAILED!!!");
        }


    }
}