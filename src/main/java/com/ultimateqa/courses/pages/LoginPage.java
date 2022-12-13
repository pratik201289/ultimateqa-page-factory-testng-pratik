package com.ultimateqa.courses.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//li[@class='header__nav-item header__nav-sign-in']//a[1]")
    WebElement loginPageLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement GetActualWelcomeText;

    @CacheLookup
    @FindBy(name = "user[email]")
    WebElement enterEmailAddress;
    @CacheLookup
    @FindBy(name = "user[password]")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement loginButtonClick;

    @CacheLookup
    @FindBy(xpath = "//li[@class='form-error__list-item' and contains(text(),'Invalid email')]")
    WebElement GetInvalidMessageText;

    public void clickOnLoginPage() {
        Reporter.log("Click on Login Link " + loginPageLink.toString());
        clickOnElement(loginPageLink);

    }

    public String VerifyWelcomeBackText() {
        Reporter.log("Verify on Welcome Back Text " + GetActualWelcomeText.toString());
        return getTextFromElement(GetActualWelcomeText);
    }

    public void setEnterEmailAddress(String userName) {

        Reporter.log("Enter Email " + userName + " to emailAddress field " + enterEmailAddress.toString());
        sendTextToElement(enterEmailAddress, userName);
        CustomListeners.test.log(Status.PASS, "Enter Username " + userName);
    }

    public void setEnterPassword(String password) {
        Reporter.log("Enter Password " + password + " to password field " + enterPassword.toString());
        sendTextToElement(enterPassword, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {

        Reporter.log("Click on Login Button " + loginButtonClick.toString());
        clickOnElement(loginButtonClick);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public String getActualErrorMessage() {
        Reporter.log("Getting Actual Error Message" + GetInvalidMessageText.toString());
        String message = getTextFromElement(GetInvalidMessageText);
        CustomListeners.test.log(Status.PASS, "Get Actual Error Message");
        return message;

    }
}
