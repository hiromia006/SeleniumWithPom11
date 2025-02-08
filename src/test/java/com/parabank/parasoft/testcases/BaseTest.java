package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class BaseTest {
    WebDriver driver;
    Page pg;

    @BeforeMethod
    public void browserSetup() {
        String browserName = "firefoxHeadless";

        if (Objects.equals(browserName, "firefox")) {
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "firefoxHeadless")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else if (Objects.equals(browserName, "chrome")) {
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Please provide valid browser name");
        }

        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/");
        pg = new BasePage(driver);
    }

    @AfterMethod
    public void quiteBrowser() {
        driver.quit();
    }


    public WebDriver getWebDriver() {
        return driver;
    }

}
