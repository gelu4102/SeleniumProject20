package com.cybertek.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    /*
    TASK: NEW METHOD CREATION
    Method name: getDriver
    Static method
    Accepts string argument: browser Type --> will determine what browser opens
       -->if "Chrome" opens chrome browser
       -->if "firefox" opens firefox browser
    return type: WebDriver
     */
    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            //system.setProperty("webdriver.chrome.driver,""Path");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Given browser does not exist.Driver = null!");
            return null;
        }
    }
}
