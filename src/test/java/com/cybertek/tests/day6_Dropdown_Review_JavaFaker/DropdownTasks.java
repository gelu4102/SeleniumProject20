package com.cybertek.tests.day6_Dropdown_Review_JavaFaker;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;
   /* @BeforeClass
    public void setupClass(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    */
   //@AfterMethod
  //public void tearDownMethod(){
 // driver.close();
//    }
    @BeforeMethod
    public void setupMethod(){
        //open a new browser
        driver = WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get the page
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    //TC #2: Selecting state from State dropdown and verifying result
    @Test
    public void test2_verify_state_dropdown() throws InterruptedException{
        // we need to locate the dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois --> selecting by visible text
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia --> selecting by value
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California --> select by index
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);
        //6. Verify final selected option is California.

        String expectedResult = "California";
        String actualResult = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult,"Actual VS Expected is not Equal");
        //Use all Select options. (visible text, value, index)
    }
    @Test
    public void test3_date_dropdown_verification(){
        //TC #3: Selecting date on dropdown and verifying
        //locate all the web elements/dropdown

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id = 'day']")));

        //creating expected value in one place

        String expectedYear = "1921";
        String expectedMonth = "December";
        String expectedDay = "1";

        //3. Select “December 1 , 1921” and verify it is selected.
        //selecting year using text
         yearDropdown.selectByVisibleText("1921");

        //selecting month by value attributes value
         monthDropdown.selectByValue("11");
         //selecting the day using index
        dayDropdown.selectByIndex(0);

        //getting our actual values from the web page
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //creating assert lines to compare actual vs expected
        Assert.assertEquals(actualYear,expectedYear,"Actual year VS Expected year is not Equal");
        Assert.assertEquals(actualMonth,expectedMonth,"Actual month VS expected month is not equal");
        Assert.assertEquals(actualDay,expectedDay,"Actual day VS expected day is not equal");
    }

    //TC #4: Selecting value from multiple select dropdown
    @Test
    public void test4_multiple_value_select_dropdown()throws InterruptedException{

        //3. Select all the options from multiple select dropdown.
       // locate the dropdown

        Select multiSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //crating a list of web element to store all of the options inside of this dropdown
        List<WebElement>allOptions = multiSelectDropdown.getOptions();

        //loop through the options to select all of them

        for (WebElement eachOptions : allOptions){
            Thread.sleep(500);
            eachOptions.click();//this will click each options with every iteration

            //4. Print out all selected values.
            System.out.println("Selected: "+eachOptions.getText());

            //Asserting the option is actually selected or not
            Assert.assertTrue(eachOptions.isSelected(),"The option: "+eachOptions.getText()+"is not selected!");
        }

        //5. Deselect all values.
          multiSelectDropdown.deselectAll();
        for (WebElement eachOption : allOptions){
            Assert.assertTrue(!eachOption.isSelected());//it will be false boolean value, with ! we make it "true

            //assertFalse method looks for "false"boolean value to pass the test
            Assert.assertFalse(eachOption.isSelected());
        }
    }
    @Test
    public void test5_html_dropdown_handling(){
        //Locate the HTML dropdown as a regular web element
        WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));

        //3. Click to non-select dropdown
        websiteDropdown.click();

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        facebookLink.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle, expectedTitle, "Actual title does not match expected title!");
    }



}