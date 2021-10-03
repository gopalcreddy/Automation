package com.cucumberFramework.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.WaitHelper;
import org.testng.Assert;

public class securePayContactUsPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Contact us')]")
	WebElement contactUsLink;
	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement firstName;

	@FindBy(xpath="//input[@name='lastName']")
	public WebElement lastName;

	@FindBy(xpath="//input[@name='email']")
	public WebElement email;

	@FindBy(xpath="//input[@name='phone']")
	public WebElement phone;

	@FindBy(xpath="//input[@name='company']")
	public WebElement company;

	@FindBy(xpath="//input[@name='website']")
	public WebElement website;

	@FindBy(xpath="//select[@name='amount']")
	public WebElement amount;

	@FindBy(xpath="//textarea[@placeholder='Write your message here']")
	public WebElement yourMessage;
	

	WaitHelper waitHelper;
	
	public securePayContactUsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);

	}


	public void clickContactUsLink(){
		waitHelper.WaitForElement(this.contactUsLink, 60);
		this.contactUsLink.click();
	}



	public void enterLastName(String lastName){
		this.lastName.sendKeys(lastName);
	}
	public void enterEmail(String email){
		this.email.sendKeys(email);
	}
	public void enterPhone(String phone){
		this.phone.sendKeys(phone);
	}
	public void enterCompany(String company){
		this.company.sendKeys(company);
	}
	public void enterWebsite(String website){
		this.website.sendKeys(website);
	}
	public void enterFirstName(String firstName){
		this.firstName.sendKeys(firstName);
	}

	public void  selectAmount()	{
		new Select(amount).selectByVisibleText("Less than $100,000");
	}
	public void enterYourMessage(String yourMessage)
	{
		this.yourMessage.sendKeys(yourMessage);
	}

	public void verifyTittle(String strExpTittle ){

		waitHelper.WaitForElement(this.firstName, 60);
		String strActTittle= driver.getTitle();
		System.out.println("******************************Page title is : " + strExpTittle);
		System.out.println("******************************Page title is : " + strActTittle);
		Assert.assertTrue(driver.getTitle().contains(strExpTittle));

	}


}
