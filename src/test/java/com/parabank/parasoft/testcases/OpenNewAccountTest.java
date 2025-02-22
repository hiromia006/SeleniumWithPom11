package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test
    public void openNewAccountShouldSucceed() {
        LoginPage loginPg = pg.getInstance(LoginPage.class);


        HomePage homePg = loginPg
                .doLogin(getUsername(), getPassword());

        OpenNewAccountPage newAccountPg = homePg
                .clickOpenedAccountLink()
                .selectAccountType(1);

        OpenedAccountPage openedAccountPg = newAccountPg
                .clickOpenAccountBtn();
        Assert.assertTrue(openedAccountPg.hasNewAccountId());

//        OpenedAccountPage openedAccountPg2 = pg.getInstance(LoginPage.class)
//                .doLogin(getUsername(), getPassword())
//                .clickOpenedAccountLink()
//                .selectAccountType(1)
//                .selectFromAccountId(0)
//                .clickOpenAccountBtn();
//        Assert.assertTrue(openedAccountPg2.hasNewAccountId());


    }

}
