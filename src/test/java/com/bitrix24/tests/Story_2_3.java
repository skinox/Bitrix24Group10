package com.bitrix24.tests;

import com.bitrix24.pages.LoginPage;
import com.bitrix24.utilities.BrowserUtilities;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Story_2_3 extends AbstractBaseTest{
    LoginPage loginPage = new LoginPage();
    protected By task = By.id("feed-add-post-form-tab-tasks");
    protected By upload_icon = By.id("bx-b-uploadfile-task-form-lifefeed_task_form");
    protected By upload_local = By.xpath("//input[@name='bxu_files[]']");
    protected By uploaded_text = By.xpath("//a[.='My Drive / Uploaded files']");
    protected By select_doc = By.cssSelector(".diskuf-extended[dropzone='copy f:*/*'] .diskuf-selector-link");
    protected By image_from_docs = By.xpath("//a[.='image.png']");
    protected By select_doc_button = By.xpath("//span[@class='popup-window-button popup-window-button-accept']");

   @Test
   public void LoginTest() throws InterruptedException {
       loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
       BrowserUtilities.wait(1);
       driver.findElement(task).click();
       BrowserUtilities.wait(1);
       boolean check_upload_button_isDisplayed = driver.findElement(upload_icon).isDisplayed();
       Assert.assertTrue(check_upload_button_isDisplayed==true);
       driver.findElement(upload_icon).click();
       BrowserUtilities.wait(2);
       driver.findElement(upload_local).sendKeys("/Users/jumaev/Desktop/CyberTek Interview/image.png");
       BrowserUtilities.wait(2);
       String displayed_text_once_uploaded = driver.findElement(uploaded_text).getText();
       Assert.assertEquals("My Drive / Uploaded files",displayed_text_once_uploaded);

   }
   @Test
    public void Task_Select_Doc(){
       loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
       BrowserUtilities.wait(1);
       driver.findElement(task).click();
       BrowserUtilities.wait(1);
       driver.findElement(upload_icon).click();
       BrowserUtilities.wait(1);
       driver.findElement(select_doc).click();
       BrowserUtilities.wait(1);
       driver.findElement(image_from_docs).click();
       driver.findElement(select_doc_button).click();
       BrowserUtilities.wait(1);
       String image_selected = driver.findElement(By.xpath("//span[@class='f-wrap']")).getText();
       Assert.assertEquals("image.png",image_selected);

   }


}
