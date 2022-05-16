package com.selenium.framework;

import com.selenium.framework.frameworkExceptions.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {

    static Properties configProperties;
    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String ieDriverPath;
    public static String firefoxDriverPath;
    public static String edgeDriverPath;
    public static Boolean maximizeMode;
    public static Integer implicitWaitTime;
    public static Integer explicitWaitTime;
    public static Integer pageLoadTime;


    public static void initializeProperties() throws  Exception{
        if(configProperties == null){
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//configs.properties"));
            configProperties.load(fileInputStream);
        }
        runOnBrowser=configProperties.getProperty("RunOnBrowser");
        takeScreenshot=Boolean.valueOf(configProperties.getProperty("TakeScreenShot"));
        chromeDriverPath=configProperties.getProperty("ChromeDriverPath");
        ieDriverPath=configProperties.getProperty("IEDriverPath");
        edgeDriverPath=configProperties.getProperty("EdgeDriverPath");
        firefoxDriverPath=configProperties.getProperty("FirefoxDriverPath");
        maximizeMode=Boolean.valueOf(configProperties.getProperty("MaximizeMode"));
        implicitWaitTime=Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        explicitWaitTime=Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageLoadTime=Integer.valueOf(configProperties.getProperty("PageLoadWait"));

    }
    public static void validateConfigurations()throws  Exception {
        if (runOnBrowser.equalsIgnoreCase("Chrome")) {
            if (chromeDriverPath.isEmpty()) {
                throw new ConfigurationException("ChromeDriverPath empty");
            }
        }
        if (runOnBrowser.equalsIgnoreCase("Firefox")) {
            if (firefoxDriverPath.isEmpty()) {
                throw new ConfigurationException("FirefoxDriverPath empty");
            }
            if (runOnBrowser.equalsIgnoreCase("Edge")) {
                if (edgeDriverPath.isEmpty()) {
                    throw new ConfigurationException("EdgeDriverPath empty");
                }
            }
            if (runOnBrowser.equalsIgnoreCase("IE")) {
                if (ieDriverPath.isEmpty()) {
                    throw new ConfigurationException("IEDriverPath empty");
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesLoader.validateConfigurations();
    }
}
