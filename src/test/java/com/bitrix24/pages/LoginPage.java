package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractBasePage {

    //=========== Login Page =====================

    @FindBy(className = "log-popup-header")
    private WebElement authorizationLogo;

    @FindBy(name = "USER_LOGIN")
    private WebElement username; //+

    @FindBy(name="USER_PASSWORD") //+
    private WebElement password;

    @FindBy(className = "login-btn") //+
    private WebElement login;

    @FindBy(className = "login-link-forgot-pass")
    private WebElement forgotPassword;

    @FindBy (className = "errortext") //+
    private WebElement warningMessage;

    @FindBy(id = "USER_REMEMBER")
    private WebElement remember;

    //================ Forgot Password Page ==================

    @FindBy(className = "log-popup-header")
    private WebElement forgotGetPasswordLogo;

    @FindBy(name = "USER_LOGIN")
    private WebElement forgotLogin;

    @FindBy(name = "USER_EMAIL")
    private WebElement forgotEmail;

    @FindBy(xpath = "//a[.='Authorization']")
    private  WebElement forgotAuthorizationBtn;

    @FindBy(className = "login-btn")
    private WebElement resetPasswordBtn;

    @FindBy(className = "errortext")
    private WebElement forgotErrorMessage;





    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.wait(3);
    }

    public void login(){
        BrowserUtilities.wait(3);
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }



}

