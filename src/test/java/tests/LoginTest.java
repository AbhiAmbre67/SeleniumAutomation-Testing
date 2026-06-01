package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage login;

    @BeforeMethod
    public void pageSetup() {
        login = new LoginPage(driver);
    }

    @Test(priority =1 )
    public void verifyValidLoginTest()
    {
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(login.GetCurentUrl().contains("inventory"));
    }


    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {
                        "TC01_EmptyPass",
                        "standard_user",
                        "",
                        "Epic sadface: Password is required"
                },

                {
                        "TC02_EmptyUserName",
                        "",
                        "secret_sauce",
                        "Epic sadface: Username is required"
                },

                {
                        "TC03_InvalidPass",
                        "standard_user",
                        "wrongpass",
                        "Epic sadface: Username and password do not match any user in this service"
                }
        };
    }

    @Test(  priority = 2,
            dataProvider = "loginData")
    public void verifyInvalidLogins(
            String testCaseName,
            String userName,
            String password,
            String expectedError)
    {
        System.out.println("Running : " + testCaseName);

        login.login(userName,password);

        String actualError= login.getErrorMessage();

        Assert.assertEquals(actualError,expectedError);
    }}



//    @Test
//    public void validLoginTest()
//    {
//        login.login("standard_user", "secret_sauce");
//        Assert.assertTrue(login.GetCurentUrl().contains("inventory"));
//    }
//
//    @Test
//    public void invalidUserNameTest()
//    {
//        login.login("WrongUser" ,"secret_sauce" );
//
//        Assert.assertEquals(login.getErrorMessage(),"Epic sadface: Username and password do" +
//                " not match any user in this service");
//    }
//
//    @Test
//    public void emptyUsernameTest()
//    {
//        login.login("", "secret_sauce");
//
//        Assert.assertEquals(login.getErrorMessage(),"Epic sadface: Username is required");
//    }



