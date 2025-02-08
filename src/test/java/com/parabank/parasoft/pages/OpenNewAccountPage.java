package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewAccountPage selectAccountType(String txt) {
        getSelect(By.cssSelector("#type")).selectByVisibleText(txt);
        return this;
    }

    public OpenNewAccountPage selectAccountType(int index) {
        ParaBankUtil.waitForDom();
        getSelect(By.cssSelector("#type")).selectByIndex(index);
        return this;
    }

    public OpenNewAccountPage selectFromAccountId(String txt) {
        getSelect(By.cssSelector("#fromAccountId")).selectByVisibleText(txt);
        return this;
    }

    public OpenNewAccountPage selectFromAccountId(int index) {
        new Select(getWebElement(By.cssSelector("#fromAccountId"))).selectByIndex(index);
        return this;
    }

    public OpenedAccountPage clickOpenAccountBtn(){
        clickElement(By.cssSelector("input[value='Open New Account']"));
        return getInstance(OpenedAccountPage.class);
    }
}
