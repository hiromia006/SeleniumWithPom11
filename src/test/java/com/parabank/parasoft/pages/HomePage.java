package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogoutLink() {
        return getWebElements(By.cssSelector("a[href='logout.htm']")).size() > 0;
    }

    public OpenNewAccountPage clickOpenedAccountLink(){
        clickElement(By.cssSelector("a[href='openaccount.htm']"));
        return getInstance(OpenNewAccountPage.class);
    }

    public TransferFundsPage clickTransferFundsLink(){
        clickElement(By.cssSelector("a[href='transfer.htm']"));
        return getInstance(TransferFundsPage.class);
    }
}
