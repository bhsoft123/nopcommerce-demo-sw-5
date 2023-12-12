package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {



        @CacheLookup
        @FindBy(xpath = "//h1[contains(text(),'Register')]")
        WebElement RegisterText;

        @CacheLookup
        @FindBy(xpath = "//h1[contains(text(),'Register')]")
        WebElement RegisterButton;
        @CacheLookup
        @FindBy(id = "FirstName-error")
        WebElement FirstNameRequired;

        @CacheLookup
        @FindBy(id = "LastName-error")
        WebElement LastNameRequired;

        @CacheLookup
        @FindBy(id = "Email-error")
        WebElement EmailIsRequired;
        @CacheLookup
        @FindBy(xpath = "//span[@data-valmsg-for='Password']")
        WebElement PasswordIsRequired;

        @CacheLookup
        @FindBy(id = "ConfirmPassword-error")
        WebElement ConfirmPasswordIsRequired;

        @CacheLookup
        @FindBy(id = "gender-female")
        WebElement FemaleRadioButton;

        @CacheLookup
        @FindBy(id = "FirstName")
        WebElement Firstname;

        @CacheLookup
        @FindBy(id = "LastName")
        WebElement Lastname;

        @CacheLookup
        @FindBy(xpath = "//select[@name='DateOfBirthDay']")
        WebElement Day;

        @CacheLookup
        @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
        WebElement Month;

        @CacheLookup
        @FindBy(xpath = "//select[@name='DateOfBirthYear']")
        WebElement Year;

        @CacheLookup
        @FindBy(id = "Email")
        WebElement EmailField;

        @CacheLookup
        @FindBy(id = "Password")
        WebElement PasswordField;
        @CacheLookup
        @FindBy (id = "ConfirmPassword")
        WebElement ConfirmPassword;
        @CacheLookup
        @FindBy (id = "register-button")
        WebElement RegisterButton1;

        @CacheLookup
        @FindBy(xpath = "//div[@class='result']")
        WebElement RegistrationCompletedText;


        public String getRegisterText() {
            String message = getTextFromElement(RegisterText);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

        public void clickOnRegisterButton() {
            clickOnElement(RegisterButton);
        }

        public String getFirstNameRequiredText() {
            String message = getTextFromElement(FirstNameRequired);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

        public String getLastNameRequiredText() {
            String message = getTextFromElement(LastNameRequired);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

        public String getEmailIsRequiredText() {
            String message = getTextFromElement(EmailIsRequired);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

        public String getPasswordIsRequiredText() {
            String message = getTextFromElement(PasswordIsRequired);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

        public String getConfirmPasswordIsRequiredText() {
            String message = getTextFromElement(ConfirmPasswordIsRequired);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

        public void clickOnFemaleRadioButton() {
            clickOnElement(FemaleRadioButton);
        }

        public void enterCredentialsForRegistration(String firstname, String lastname, String day, String month, String year){
            sendTextToElement(Firstname ,firstname );
            sendTextToElement(Lastname, lastname);
            selectByVisibleTextFromDropDown(Day ,day );
            selectByVisibleTextFromDropDown(Month,month);
            selectByVisibleTextFromDropDown(Year,year );
        }

        public void registerToApplication(String username,String password,String confirmPassword){
            sendTextToElement(EmailField,username );
            sendTextToElement(PasswordField,password );
            sendTextToElement(ConfirmPassword, confirmPassword );
            clickOnElement(RegisterButton);
        }
        public String getRegistrationCompletedText() {
            String message = getTextFromElement(RegistrationCompletedText);
            CustomListeners.test.log(Status.PASS, "Message is not displayed");
            return message;
        }

 }



