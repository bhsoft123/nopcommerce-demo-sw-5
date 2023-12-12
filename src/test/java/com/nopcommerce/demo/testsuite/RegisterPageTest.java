package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;


    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    //1. verifyUserShouldNavigateToRegisterPageSuccessfully()
    @Test(groups = {"smoke", "sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1Click on Register Link
        homePage.clickOnRegisterLink();
        //1.2Verify "Register" text
        Assert.assertEquals(registerPage.getRegisterText(), "RegisterText", "Error");
    }

    //2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify the error message "First name is required."
        Assert.assertEquals(registerPage.getFirstNameRequiredText(), "First name is required.", "Error");
        //Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.getLastNameRequiredText(), "Last name is required.", "Error");
        //Verify the error message "Email is required."
        Assert.assertEquals(registerPage.getEmailIsRequiredText(), "Email is required.", "Error");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getPasswordIsRequiredText(), "Password is required.", "Error");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getConfirmPasswordIsRequiredText(), "Password is required.", "Error");
    }

    //2. verifyThatUserShouldCreateAccountSuccessfully()
    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Select gender "Female"
        registerPage.clickOnFemaleRadioButton();
        //Enter all credentials firstname, lastname, dob and email
        registerPage.enterCredentialsForRegistration("Orange","Purple","1","1","1990");
        //Click on "REGISTER" button
        registerPage.registerToApplication("orangepurple@gmail.com", "Orange@purple","Orange@purple");
        //Verify message "Your registration completed"
        Assert.assertEquals(registerPage.getRegistrationCompletedText(),"Your registration completed","error");
    }
}