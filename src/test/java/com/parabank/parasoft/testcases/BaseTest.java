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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page pg;
    private Properties prop;

    public BaseTest() {
        prop = new Properties();
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @BeforeMethod
    public void browserSetup() {
        String browserName = prop.getProperty("browserName");

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
        driver.get(prop.getProperty("baseUrl"));
        pg = new BasePage(driver);
    }

    @AfterMethod
    public void quiteBrowser() {
        driver.quit();
    }


    public WebDriver getWebDriver() {
        return driver;
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}
