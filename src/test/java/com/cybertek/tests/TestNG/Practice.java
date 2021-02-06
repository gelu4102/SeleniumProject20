package com.cybertek.tests.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice {

    @Test
    public void test1(){
        SoftAssert sf = new SoftAssert();
        Assert.assertEquals(2, 3, "Failed!!");
    }


}
