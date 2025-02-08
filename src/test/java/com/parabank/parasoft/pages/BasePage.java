package com.parabank.parasoft.pages;

import com.aventstack.extentreports.Status;
import com.parabank.parasoft.report.ReportTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement element = null;
        try {
            addInfo("Selenium Webdriver going to find a WebElement with " + selector + " Locator");
            element = driver.findElement(selector);
            addInfo("Selenium Webdriver found a Web Element with " + selector + " Locator");

        } catch (Exception e) {
            addFailInfo("Selenium Webdriver is not found a Web Element with " + selector + " Locator");
            throw new RuntimeException(selector.toString() + " No such selector found and sorry for that");
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> elements = null;

        try {
            addInfo("Selenium Webdriver going to find a WebElements with " + selector + " Locator");
            elements = driver.findElements(selector);
            addInfo("Selenium Webdriver found a Web Elements with " + selector + " Locator");
        } catch (RuntimeException e) {
            addFailInfo("Selenium Webdriver is not found a Web Elements with " + selector + " Locator");

            throw new RuntimeException(selector.toString() + " Selector not found and sorry for that");
        }
        return elements;
    }

    @Override
    public void waitForElement(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    @Override
    public void clickElement(By selector) {
        getWebElement(selector).click();
    }

    @Override
    public String getElementText(By selector) {
        return getWebElement(selector).getText().trim();
    }

    public String getPageTittle() {
        return driver.getTitle();
    }

    public Select getSelect(By selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        return new Select(getWebElement(selector));
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }

    public void addFailInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }
}
