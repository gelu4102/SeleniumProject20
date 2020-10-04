package com.cybertek.tests.day10_testbase_properties_driverutil;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_test(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

        //Key = Value
        //os.name = Windows 10
        //User.name = sabuk
        //Keys has to be exactly the same value when you pass it
        //Otherwise it will not work. so if you are getting 'null' make sure your key is correct


    }

}
