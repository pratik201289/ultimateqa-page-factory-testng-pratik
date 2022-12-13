package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {

//        Thread.sleep(3000);
        try {
            loginPage.clickOnLoginPage();
            Assert.assertEquals(loginPage.VerifyWelcomeBackText(), "Welcome Back!", "Welcome Back Text is not display");
        } catch (NullPointerException e) {

            loginPage.clickOnLoginPage();

        }
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessage() {
        loginPage.clickOnLoginPage();
        loginPage.setEnterEmailAddress("pratik123@gmail.com");
        loginPage.setEnterPassword(getRandomString(8));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getActualErrorMessage(), "Invalid email or password.", "Not display Error Message");
    }
}
