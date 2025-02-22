package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.HomePage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    @Test
    public void transferFundsShouldSucceed() {
        LoginPage loginPg = pg.getInstance(LoginPage.class);
        loginPg = loginPg
                .fillUsername(getUsername())
                .fillPassword(getPassword());

        HomePage homePg = loginPg
                .clickLoginBtn();

        TransferFundsPage transferFundsPg = homePg
                .clickTransferFundsLink()
                .selectFromAccount(0)
                .selectToAccount(0)
                .clickFundTransferBtn();
        Assert.assertTrue(transferFundsPg.hasComplete());


//        TransferFundsPage fundsPg = pg.getInstance(LoginPage.class)
//                .fillUsername("sqa")
//                .fillPassword("sqa")
//                .clickLoginBtn()
//                .clickTransferFundsLink()
//                .selectFromAccount(0)
//                .selectToAccount(0)
//                .clickFundTransferBtn();
//        Assert.assertTrue(fundsPg.hasComplete());


    }
}
