package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By usernameSl = By.cssSelector("input[name='username']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username) {
        getWebElement(usernameSl).sendKeys(username);
        return this;
    }

    public boolean hasUsernameField() {
        return getWebElements(usernameSl).size() > 0;
    }

    public LoginPage fillPassword(String password) {
        getWebElement(By.cssSelector("input[name='password']")).sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn() {
        clickElement(By.cssSelector("input[value='Log In']"));
        return getInstance(HomePage.class);
    }

    public LoginPage clickLoginBtnForFail() {
        clickElement(By.cssSelector("input[value='Log In']"));
        return this;
    }

    public CustomerLookupPage clickForgetLink() {
        clickElement(By.cssSelector("a[href='lookup.htm']"));
        return getInstance(CustomerLookupPage.class);

    }

    public RegisterPage clickRegisterLink() {
        clickElement(By.cssSelector("a[href='register.htm']"));
        return getInstance(RegisterPage.class);
    }


    public boolean hasError() {
        return getWebElements(By.cssSelector(".error")).size() > 0;
    }
}
