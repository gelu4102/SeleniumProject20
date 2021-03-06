package com.cybertek.tests.day10_testbase_properties_driverutil;

import com.cybertek.Utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
   @Test
   public void reading_from_properties_file() throws IOException {
       //properties: Use properties class object
       // We create properties object to be able to read configuration.properties file
       //import from java.util
       Properties properties = new Properties();

       //FileInputStream: opens the file
       String path = "configuration.properties";

       //We need to pass the path of the file
       FileInputStream file = new FileInputStream(path);

       //we will load the file
       properties.load(file);

       //We read from the file
       System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
       System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

       //Close the file
       file.close();

    }

    @Test
    public void using_properties_utility_method(){
       //This will read the given "Key's" value and return it
       //as a string
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"smartbearUrl\") = " + ConfigurationReader.getProperty("smartbearUrl"));
    }

}
