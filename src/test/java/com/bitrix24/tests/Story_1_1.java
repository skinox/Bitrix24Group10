package com.bitrix24.tests;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Story_1_1 extends AbstractBaseTest {

    /*
    1. User should be able to click on upload files icon to upload files and pictures from local disks,
     download from external drive, select documents from bixtrix24, and create files to upload.
     */


    @Test
    public void uploadFromLocalDisk(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPage asp = new ActivityStreamPage();
        asp.clickFile();
        asp.uploadFromLocalDisk("/Users/arsilanaji/Desktop/image (1).png");
    }

    @Test
    public void verifyUploadOptions(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPage asp = new ActivityStreamPage();
        asp.clickFile();
        Assert.assertTrue(asp.getBitrixUpload().isDisplayed());
        Assert.assertTrue(asp.getCreateUsing().isDisplayed());
        Assert.assertTrue(asp.getExternalDrive().isDisplayed());
    }


}
