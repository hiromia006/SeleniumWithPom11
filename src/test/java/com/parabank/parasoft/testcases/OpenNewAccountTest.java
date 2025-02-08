package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test
    public void openNewAccountShouldSucceed() {
        LoginPage loginPg = pg.getInstance(LoginPage.class);
        loginPg = loginPg
                .fillUsername("sqa")
                .fillPassword("sqa");

        HomePage homePg = loginPg
                .clickLoginBtn();

        OpenNewAccountPage newAccountPg = homePg
                .clickOpenedAccountLink()
                .selectAccountType(1)
                .selectFromAccountId(0);

        OpenedAccountPage openedAccountPg = newAccountPg
                .clickOpenAccountBtn();
        Assert.assertTrue(openedAccountPg.hasNewAccountId());

//        OpenedAccountPage openedAccountPg2 = pg.getInstance(LoginPage.class)
//                .fillUsername("sqa")
//                .fillPassword("sqa")
//                .clickLoginBtn()
//                .clickOpenedAccountLink()
//                .selectAccountType(1)
//                .selectFromAccountId(0)
//                .clickOpenAccountBtn();
//        Assert.assertTrue(openedAccountPg2.hasNewAccountId());


    }

}
