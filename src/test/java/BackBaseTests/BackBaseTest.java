package BackBaseTests;

import com.selenium.BackbasePages.HomePage;
import com.selenium.BackbasePages.ProfilePage;
import com.selenium.framework.BaseTestConfig;
import org.testng.annotations.Test;

public class BackBaseTest extends BaseTestConfig {

    @Test

    public void testBackBase() throws Exception{

        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.LaunchConduitSite();
        Thread.sleep(2000);
        homePage.Click_SignIn();
        Thread.sleep(2000);
        homePage.Enter_Email("cutebubblyprincess@gmail.com");
        Thread.sleep(2000);
        homePage.Enter_Password("qa-is-cool");
        Thread.sleep(2000);
        homePage.Click_SignInButton();
        Thread.sleep(2000);

        ProfilePage profilePage = new ProfilePage(driver);
        Thread.sleep(2000);
        profilePage.Click_UsrProfile();
        Thread.sleep(2000);
        profilePage.Click_FavoritedPosts();
        Thread.sleep(2000);
        profilePage.ErrorTextMessage("No articles are here... yet.");
        Thread.sleep(2000);
    }
}
