package com.cucumberFramework.pageObjects;

import com.cucumberFramework.helper.MyException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.cucumberFramework.helper.WaitHelper;
import org.testng.Assert;

public class securePayContactUsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Contact us')]")
    WebElement contactUsLink;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@name='website']")
    public WebElement website;

    @FindBy(xpath = "//select[@name='amount']")
    public WebElement amount;

    @FindBy(xpath = "//textarea[@placeholder='Write your message here']")
    public WebElement yourMessage;

    WaitHelper waitHelper;

    public securePayContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }
 // to click Contact us lick in contact us page
    public void clickContactUsLink() throws MyException {
        try {
            waitHelper.WaitForElement(this.contactUsLink, 60);
            this.contactUsLink.click();
            System.out.println("Contact us lick is clicked successfully");
        } catch (Exception e) {
            throw new MyException("Failed To click Contact us link on Securepay Page");
        }
    }
    // to enter firstName in contact us page
    public void enterFirstName(String firstName) throws MyException {
        try {
            this.firstName.sendKeys(firstName);
            System.out.println("firstName entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter firstName in Contact us Page");
        }
    }
    // to enter lastName in contact us page
    public void enterLastName(String lastName) throws MyException {
        try {
            this.lastName.sendKeys(lastName);
            System.out.println("Lastname entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter Lastname in Contact us Page");
        }
    }
    // to enter email in contact us page
    public void enterEmail(String email) throws MyException {
        try {
            this.email.sendKeys(email);
            System.out.println("email entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter email in Contact us Page");
        }
    }
    // to enter enterPhone in contact us page
    public void enterPhone(String phone) throws MyException {

        try {
            this.phone.sendKeys(phone);
            System.out.println("Phone number entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter Phone number in Contact us Page");
        }
    }
    // to enter company in contact us page
    public void enterCompany(String company) throws MyException {
        try {
            this.company.sendKeys(company);
            System.out.println("Company name entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter Company name in Contact us Page");
        }
    }
    // to enter website in contact us page
    public void enterWebsite(String website) throws MyException {
        try {
            this.website.sendKeys(website);
            System.out.println("Company website address entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter Company website address in Contact us Page");
        }
    }
    // to select amount in contact us page
    public void selectAmount() throws MyException {
        try {
            new Select(amount).selectByVisibleText("Less than $100,000");
            System.out.println("amount selected successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter select amount in Contact us Page");
        }
    }
    // to enter message in contact us page
    public void enterYourMessage(String yourMessage) throws MyException {
        try {
            this.yourMessage.sendKeys(yourMessage);
            System.out.println("Message entered successfully in Contact us Page");
        } catch (Exception e) {
            throw new MyException("Failed to enter Message in Contact us Page");
        }
    }
    // to verify contact us page
    public void verifyTittle(String strExpTittle) throws MyException {
        try {
            waitHelper.WaitForElement(this.firstName, 60);
            String strActTittle = driver.getTitle();
            Assert.assertTrue(driver.getTitle().contains(strExpTittle));
            System.out.println("Contact us page is loaded successfully Page title is :" + strActTittle);
        } catch (Exception e) {
            throw new MyException("Failed to load Contact us Page");
        }
    }

}
