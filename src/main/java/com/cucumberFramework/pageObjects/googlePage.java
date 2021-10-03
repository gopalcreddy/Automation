package com.cucumberFramework.pageObjects;

import com.cucumberFramework.helper.MyException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.helper.WaitHelper;

public class googlePage {

    private WebDriver driver;
    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@title='Search']")
    public WebElement search;

    @FindBy(xpath = "//span[contains(text(),'SecurePay')]")
    WebElement securePayLink;

    public googlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    // to enter search value in google page
    public void searchItem(String search) throws MyException {

        try {
            this.search.sendKeys(search);
            System.out.println("search text entered successfully : " + search);
        } catch (Exception e) {
            throw new MyException("Failed To enter search text");
        }
    }

    // to click enter on google page
    public void clickSearch() throws MyException {

        try {
            this.search.sendKeys(Keys.ENTER);
            System.out.println("ENTER key pressed successfully");
        } catch (Exception e) {
            throw new MyException("Failed To click ENTER key ");
        }
    }

    // to click securepay website link on google page
    public void clickSecurePay() throws MyException {
        try {
            waitHelper.WaitForElement(this.securePayLink, 60);
            this.securePayLink.click();
            System.out.println("Securepay link is clicked successfully");
        } catch (Exception e) {
            throw new MyException("Failed to click Securepay link");
        }
    }

}
