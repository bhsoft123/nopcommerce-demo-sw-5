package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement computerText;

    @CacheLookup
    @FindBy(css = "h2[class='title'] a[title='Show products in category Desktops']")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement desktopTextLink;
    @CacheLookup
    @FindBy(css = "body > div:nth-child(7) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h2:nth-child(1) > a:nth-child(1)")
    WebElement buildYourOwnLink;
    @CacheLookup
    @FindBy(id= "product_attribute_1")
    WebElement processor;

    @CacheLookup
    @FindBy(id ="product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(css = "#product_attribute_3_6")
    WebElement hdd320;

    @CacheLookup
    @FindBy(css = "#product_attribute_3_7")
    WebElement hdd400;

    @CacheLookup
    @FindBy(css = "dd[id='product_attribute_input_4'] ul[class='option-list']")
    WebElement os;

    @CacheLookup
    @FindBy(css ="dd[id='product_attribute_input_5'] ul[class='option-list']")
    WebElement software;

    @CacheLookup
    @FindBy(css =  "#product_attribute_4_8")
    WebElement osVistaHome;

    @CacheLookup
    @FindBy(css = "#product_attribute_4_9")
    WebElement osVistaPremium;

    @CacheLookup
    @FindBy(css = "#product_attribute_5_10")
    WebElement swMicrosoft;
    @CacheLookup
    @FindBy(css = "#product_attribute_5_11")
    WebElement swAcrobatReader;
    @CacheLookup
    @FindBy(css = "#product_attribute_5_12")
    WebElement swTotalCommander;

    @CacheLookup
    @FindBy(css = "add-to-cart-button-1")
    WebElement addToCart;

    @CacheLookup
    @FindBy(css = ".content")
    WebElement verifyText;

    public String getTextComputerElement() {
       return getTextFromElement(computerText);
    }

    public void clickOnDesktopsLink(){
        clickOnElement(desktopLink);
    }
    public String getTextDesktopsElement(){
        return getTextFromElement(desktopTextLink);
    }
    public void clickOnBuildYourOwnComputer(){
        clickOnElement(buildYourOwnLink);
    }


    public void sendBuildDetails(String processor1,String ram1,String hdd1,String os1,String software1) {
        selectByVisibleTextFromDropDown(processor, processor1);
        selectByVisibleTextFromDropDown(ram, ram1);
        if (getTextFromElement(hdd320) == hdd1) {
            clickOnElement(hdd320);
        } else {
            clickOnElement(hdd400);
        }
        if (hdd320.isSelected()) {
            System.out.println("hdd 320 is selected");
        } else {
            System.out.println("hdd 400 is selected");
        }

        if (getTextFromElement(osVistaHome) == os1) {
            clickOnElement(osVistaHome);
        } else {
            clickOnElement(osVistaPremium);
        }
        if (osVistaHome.isSelected()) {
            System.out.println("os Vista Home is selected");
        } else {
            System.out.println("os Vista Premium is selected");
        }

        if (getTextFromElement(swMicrosoft) == software1) {
            clickOnElement(swMicrosoft);
        } else if (getTextFromElement(swAcrobatReader) == software1) {
            clickOnElement(swAcrobatReader);
        } else {
            clickOnElement(swTotalCommander);
        }
        if (swMicrosoft.isSelected()) {
            System.out.println("sw Microsoft is selected");
        } else if (swAcrobatReader.isSelected()) {
            System.out.println("sw Acrobat Reader is selected");
        } else {
            System.out.println("sw Total commander is selected");
        }
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }
    public String getTextFromProductAdded(){
        return getTextFromElement(verifyText);
    }
}
