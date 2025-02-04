package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage fillFirstName(String firstName) {
        getWebElement(By.cssSelector("input[id='customer.firstName']")).sendKeys(firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName) {
        getWebElement(By.cssSelector("input[id='customer.lastName']")).sendKeys(lastName);
        return this;
    }

    public RegisterPage fillAddress(String address) {
        getWebElement(By.cssSelector("input[id='customer.address.street']")).sendKeys(address);
        return this;
    }

    public RegisterPage fillCity(String city) {
        getWebElement(By.cssSelector("input[id='customer.address.city']")).sendKeys(city);
        return this;
    }

    public RegisterPage fillState(String state) {
        getWebElement(By.cssSelector("input[id='customer.address.state']")).sendKeys(state);
        return this;
    }

    public RegisterPage fillZipCode(String zipCode) {
        getWebElement(By.cssSelector("input[id='customer.address.zipCode']")).sendKeys(zipCode);
        return this;
    }

    public RegisterPage fillPhone(String phone) {
        getWebElement(By.cssSelector("input[id='customer.phoneNumber']")).sendKeys(phone);

        return this;
    }

    public RegisterPage fillSsn(String ssn) {
        getWebElement(By.cssSelector("input[id='customer.ssn']")).sendKeys(ssn);

        return this;
    }

    public RegisterPage fillUsername(String username) {
        getWebElement(By.cssSelector("input[id='customer.username']")).sendKeys(username);

        return this;
    }

    public RegisterPage fillPassword(String password) {
        getWebElement(By.cssSelector("input[id='customer.password']")).sendKeys(password);

        return this;
    }

    public RegisterPage fillConfirm(String confirm) {
        getWebElement(By.cssSelector("#repeatedPassword")).sendKeys(confirm);

        return this;
    }
}
