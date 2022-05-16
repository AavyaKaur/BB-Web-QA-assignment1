package com.selenium.BackbasePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePage {

    WebDriver driver;

    @FindBy(xpath ="//html/body/app-root/app-layout-header/nav/div/ul/li[4]/a")
    WebElement UserProfile;
    @FindBy(xpath = "//html/body/app-root/app-profile-page/div/div[2]/div/div/div/ul/li[2]/a")
    WebElement FavoritedPosts;
    @FindBy(xpath ="/html/body/app-root/app-profile-page/div/div[2]/div/div/app-profile-favorites/app-article-list/div[2]")
    WebElement TextMsg;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public ProfilePage Click_UsrProfile(){
        UserProfile.click();
        return this;
    }
    public ProfilePage Click_FavoritedPosts(){
        FavoritedPosts.click();
        return this;
    }
    public void ErrorTextMessage(String NoPost){
        String EMessage = TextMsg.getText();
        System.out.println(EMessage);
        Assert.assertEquals(EMessage,NoPost,"Wrong Error Message");
    }
}
