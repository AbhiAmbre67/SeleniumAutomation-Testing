package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest
{

    @Test
    public void validLoginTest()
    {
        LoginPage login = new LoginPage(driver);

        login.login("standard_user","secret_sauce");
    }
    }

