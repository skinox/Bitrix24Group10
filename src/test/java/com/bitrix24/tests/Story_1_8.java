package com.bitrix24.tests;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Story_1_8 extends AbstractBaseTest{

    protected By topicIcon = By.id("lhe_button_title_blogPostForm");
    protected By topicMessage = By.id("POST_TITLE");


    /**
     *  * 1.8. User should be able to click on the Topic icon
     *  to see the Message Topic text box displays
     *  on top of the message box.
     */
    @Test
    public void story_1_8(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ActivityStreamPage activityStreamPage = new ActivityStreamPage();
        BrowserUtilities.waitForPageToLoad(20);

        activityStreamPage.clickMessage();
        BrowserUtilities.wait(5);
        activityStreamPage.getTopicIcon().click();

        Assert.assertTrue(activityStreamPage.getTopicMessage().isDisplayed(),"Topic");





    }


}
