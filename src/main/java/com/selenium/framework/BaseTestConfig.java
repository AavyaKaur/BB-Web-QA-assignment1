package com.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTestConfig {

    public WebDriver driver;
    BaseUtils baseUtils;

    @BeforeSuite
    public void setUpConfigurations()throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesLoader.validateConfigurations();
    }
    @BeforeMethod
    public void setUpBrowser() throws Exception {
       baseUtils= new BaseUtils(driver);
       driver= baseUtils.launchBrowser(PropertiesLoader.runOnBrowser);

    }
    @AfterMethod
    public void tearDownBrowser(){
        baseUtils.closeBrowser();
    }
    @AfterSuite
    public void tearDownObjects()throws Exception{
        PropertiesLoader.configProperties= null;
        baseUtils = null;
    }
}


