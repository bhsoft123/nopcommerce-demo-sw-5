package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    //By loginLink = By.linkText("Log in");

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;
   // By registerLink = By.linkText("Register");

    @CacheLookup
    @FindBy(css = "body > div:nth-child(7) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
    WebElement computerLink;
    //By computerLink = By.cssSelector(("body > div:nth-child(7) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
    }
    public void clickOnComputerLink(){     clickOnElement(computerLink);
    }
}
