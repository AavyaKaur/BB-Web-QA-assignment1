package com.selenium.framework;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestAssertions {

    public static void checkIfTrue(){

    }

    public static void checkIfElementDisplayed(WebElement element){

    }

    public static void checkIfValuesAreEqual(String value1, String value2){
        Assert.assertEquals(value1,value2,"Value 1 ["+value1+"]and Value 2["+value2+"] are not equal");

    }

    public static void checkIfContains(String valueToCheck, String value){
        Assert.assertTrue(value.contains(valueToCheck));
    }
}
