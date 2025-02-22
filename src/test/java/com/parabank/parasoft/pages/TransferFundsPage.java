package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {
    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public TransferFundsPage fillAmount(int amount) {
        getWebElement(By.cssSelector("#amount")).sendKeys(String.valueOf(amount));
        return this;
    }

    public TransferFundsPage selectFromAccount(int index) {
        ParaBankUtil.waitForDom();
        getSelect(By.cssSelector("#fromAccountId")).selectByIndex(index);
        return this;
    }

    public TransferFundsPage selectToAccount(int index) {
        getSelect(By.cssSelector("#toAccountId")).selectByIndex(index);
        return this;
    }

    public TransferFundsPage clickFundTransferBtn() {
        clickElement(By.cssSelector("input[value='Transfer']"));
        return this;
    }

    public boolean hasComplete() {
        return getWebElements(By.cssSelector("div[id='showResult'] h1[class='title']")).size() > 0;
    }
}
