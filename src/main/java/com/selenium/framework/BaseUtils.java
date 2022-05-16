package com.selenium.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseUtils {

    WebDriver driver;

    BaseUtils(WebDriver driver){

        this.driver=driver;
    }
    public WebDriver launchBrowser(String browser){
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", PropertiesLoader.chromeDriverPath);
            driver = new ChromeDriver();
    }else if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", PropertiesLoader.firefoxDriverPath);
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", PropertiesLoader.edgeDriverPath);
            driver = new EdgeDriver();
        }
        if (PropertiesLoader.maximizeMode) {
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(PropertiesLoader.pageLoadTime, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(PropertiesLoader.implicitWaitTime, TimeUnit.SECONDS);
        this.driver = driver;
        return driver;
    }
    public void closeBrowser(){
        driver.close();
    }
    public void closeAllBrowsers(){
        driver.quit();
    }
}
