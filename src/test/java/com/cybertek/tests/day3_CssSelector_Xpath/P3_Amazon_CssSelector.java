package com.cybertek.tests.day3_CssSelector_Xpath;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_CssSelector {
    public static void main(String[] args) {
       //TC #3: Amazon link number verification
        //1. Open Chrome browser
        // 2. Go to https://www.amazon.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        
        // 3. Enter search term (use cssSelectorto locate search box)
        WebElement searchBox = driver.findElement(By.cssSelector("input[id ='twotabsearchtextbox'"));
        //WebElement searchBox = driver.findElement(By.cssSelector("input[id ='twotabsearchtextbox'"));

        // 4. Verify title contains search term
    }
}
