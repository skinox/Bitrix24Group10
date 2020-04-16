package com.bitrix24.tests;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.LoginPage;
import com.bitrix24.tests.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Story_1_6 extends AbstractBaseTest {
    /*
    User should be able to add mention by clicking on
    the Add mention icon and select contacts from the
    lists provided in dropdown.
     */
    @Test
    public void addMentionTest (){
        LoginPage loginPage= new LoginPage();
        loginPage.login();
        ActivityStreamPage activityStreamPage = new ActivityStreamPage();
        activityStreamPage.addMention();
        Assert.assertEquals(activityStreamPage.getContactName(), activityStreamPage.getAddedContactName());

    }
}
