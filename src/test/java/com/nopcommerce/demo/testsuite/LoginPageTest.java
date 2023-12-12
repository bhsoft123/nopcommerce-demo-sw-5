package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage ;
    LoginPage loginPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    //1.1 userShouldNavigateToLoginPageSuccessFully().

        @Test(groups = {"smoke", "sanity","regression"})
        public void verifyUserShouldNavigateToLoginPage() {
            //1.2 Click on login link
            homePage.clickOnLoginLink();
            //1.3 verify that "Welcome, Please Sign In!" message display
            String expectedMessage = "Welcome, Please Sign In!";
            String actualMessage = loginPage.getWelcomeText();
            Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        }
        //2.1 verifyTheErrorMessageWithInValidCredentials().
        @Test(groups = {"smoke","regression"})
        public void verifyErrorMessageWithInvalidCredentials() {
            //2.2Click on login link
            homePage.clickOnLoginLink();
            //2.3 Enter invalid credentials
            loginPage.enterCredentials("xyz@gmail.com","orange@purple");
            //2.4 Verify that the Error message
            String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                    + "No customer account found";
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
        }
        //3.1 verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
        @Test(groups = {"regression"})
        public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
            //3.1 Click on login link
            homePage.clickOnLoginLink();
            //3.2 Enter valid credentials and login
            loginPage.enterCredentials("orangepurple@gmail.com", "Orange@purple");
            //3.3 Verify that LogOut link is display
            String expectedErrorMessage = "Logout";
            String actualErrorMessage = loginPage.getLogoutText();
            Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Logout text not displayed");

        }
        @Test(groups = {"regression"})
        //4.1 verifyThatUserShouldLogOutSuccessFully()
        public void verifyThatUserShouldLogOutSuccessFully(){
            //4.2 Click on login link
            homePage.clickOnLoginLink();
            //4.3 Enter valid credentials and login
            loginPage.enterCredentials("orangepurple@gmail.com", "Orange@purple");
            //4.4 logout
            loginPage.clickOnLogout();
            //4.5 Verify that LogIn Link Display
            String expectedErrorMessage = "LogIn Link";
            String actualErrorMessage = loginPage.getLoginText();
            Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"LogIn Link Display");

}
}

