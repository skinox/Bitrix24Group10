package com.bitrix24.pages;

import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {


protected WebDriver driver = Driver.getDriver();
protected WebDriverWait wait = new WebDriverWait(driver,20);


    @FindBy(id = "user-name")
    protected WebElement currentUserEmail;

public AbstractBasePage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

    public void navigateTo(String componentName){
        // all component name starts with capital letter like Drive, Mail
        String locator = "//span[contains(text(),'"+componentName+"')]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    public void search(String anything){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-textbox-input"))).sendKeys(anything, Keys.ENTER);

    }

    public String getCurrentUserEmail(){

        wait.until(ExpectedConditions.visibilityOf(currentUserEmail));
        return currentUserEmail.getText().trim();
    }



}
