package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement element = null;
        try {
            element = driver.findElement(selector);
        } catch (Exception e) {
            throw new RuntimeException(selector.toString() + " No such selector found and sorry for that");
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> elements = null;

        try {
            elements = driver.findElements(selector);
        } catch (RuntimeException e) {
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
}
