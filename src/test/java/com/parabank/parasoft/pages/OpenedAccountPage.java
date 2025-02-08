package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenedAccountPage extends BasePage {
    public OpenedAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasNewAccountId() {
        return getWebElements(By.cssSelector("#newAccountId")).size() > 0;
    }
}
