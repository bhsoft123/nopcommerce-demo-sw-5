package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ComputerPage computerPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
    }

    //3. ComputerPageTest
    @Test(groups = {"smoke", "sanity","regression"})
    //1. verifyUserShouldNavigateToComputerPageSuccessfully()
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputerLink();
        //Verify "Computer" text
        Assert.assertEquals(computerPage.getTextComputerElement(), "Computer", "error");
    }
    @Test(groups = {"smoke", "regression"})
    //2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputerLink();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Verify "Desktops" text
        Assert.assertEquals(computerPage.getTextDesktopsElement(), "Desktops", "Error");
    }

    //3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
    //processor, String ram, String hdd, String os, String software)
    @Test(dataProvider = "buildDetails", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software){
        //Click on Computer tab
        homePage.clickOnComputerLink();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Click on product name "Build your own computer"
        computerPage.clickOnBuildYourOwnComputer();
        //Select processor "processor"
        //Select RAM "ram"
        //Select HDD "hdd"
        //Select OS "os"
        //Select Software "software"
        computerPage.sendBuildDetails(processor,ram,hdd,os,software);
        //Click on "ADD TO CART" Button
        computerPage.clickOnAddToCart();
        //Verify message "The product has been added to your shopping cart"
        Assert.assertEquals(computerPage.getTextFromProductAdded(), "The product has been added to your shopping cart", "error");
    }
}