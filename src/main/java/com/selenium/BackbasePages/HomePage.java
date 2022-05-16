package com.selenium.BackbasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    String URL="https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";

    @FindBy(xpath = "//a[@routerlink='/login']")
    WebElement SignIn;
    @FindBy(xpath = "//input[contains(text(),Email)]")
    WebElement EmailId;
    @FindBy(xpath = "//input[@type='password']")
    WebElement Password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement Sign_InButton;


    public HomePage (WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }
    public HomePage LaunchConduitSite(){
        driver.get(URL);
        return this;
    }
    public HomePage Click_SignIn(){
        SignIn.click();
        return this;
    }
    public HomePage Enter_Email(String email){
        EmailId.sendKeys(email);
        return this;
    }
    public HomePage Enter_Password(String password){
        Password.sendKeys(password);
        return this;
    }
    public HomePage Click_SignInButton(){
        Sign_InButton.click();
        return this;
    }
}
