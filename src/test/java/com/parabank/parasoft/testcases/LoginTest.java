package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.HomePage;
import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.util.ParaBankUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginTittle() {
        LoginPage loginPg = pg.getInstance(LoginPage.class);
        Assert.assertEquals(loginPg.getPageTittle(), ParaBankUtil.LOGIN_TITTLE);
    }

    @Test
    public void checkUsernameField() {
        LoginPage loginPg = pg.getInstance(LoginPage.class);
        Assert.assertTrue(loginPg.hasUsernameField());
    }

    @Test
    public void loginShouldSucceed() {
        LoginPage loginPg = pg.getInstance(LoginPage.class);
        loginPg = loginPg
                .fillUsername("sqa")
                .fillPassword("sqa");

        HomePage homePg = loginPg
                .clickLoginBtn();
        Assert.assertTrue(homePg.hasLogoutLink());

//        HomePage page = pg.getInstance(LoginPage.class)
//                .fillUsername("sqa")
//                .fillPassword("sqa")
//                .clickLoginBtn();
//        Assert.assertTrue(page.hasLogoutLink());

    }

    @Test
    public void loginShouldFailWithOutUsernameAndPassword() {
        LoginPage page = pg.getInstance(LoginPage.class)
                .clickLoginBtnForFail();
        Assert.assertTrue(page.hasUsernameField());

    }

    @Test
    public void loginShouldFailWithOutPassword() {
        LoginPage page = pg.getInstance(LoginPage.class)
                .fillUsername("dadd")
                .clickLoginBtnForFail();
        Assert.assertTrue(page.hasUsernameField());

    }

    @Test
    public void loginShouldFailWithOutUsername() {
        LoginPage page = pg.getInstance(LoginPage.class)
                .fillPassword("dddd")
                .clickLoginBtnForFail();
        Assert.assertTrue(page.hasUsernameField());

    }

    @Test
    public void loginShouldFail() {
        LoginPage page = pg.getInstance(LoginPage.class)
                .fillUsername("sqaddd")
                .fillPassword("sdddqa")
                .clickLoginBtnForFail();
        Assert.assertTrue(page.hasError());

    }
}
