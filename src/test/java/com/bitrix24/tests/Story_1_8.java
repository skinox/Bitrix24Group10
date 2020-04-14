package com.bitrix24.tests;

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
        BrowserUtilities.waitForPageToLoad(10);

        driver.findElement(By.id("microoPostFormLHE_blogPostForm_inner")).click();
        BrowserUtilities.wait(2);
        driver.findElement(topicIcon).click();

        BrowserUtilities.wait(1);
        Assert.assertTrue(driver.findElement(topicMessage).isDisplayed(),"Topic");





    }


}
