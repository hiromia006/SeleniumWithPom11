package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.LoginPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void registrationShouldSucceed(){
        pg.getInstance(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillAddress(LoremIpsum.getInstance().getTitle(3));
    }
}
