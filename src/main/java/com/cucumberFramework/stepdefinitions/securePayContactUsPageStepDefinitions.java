package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.Constants;
import com.cucumberFramework.pageObjects.googlePage;
import com.cucumberFramework.pageObjects.securePayContactUsPage;
import com.cucumberFramework.testBase.TestBase;
import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.text.TextProducer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class securePayContactUsPageStepDefinitions extends TestBase {
    securePayContactUsPage objSecurePayPage = new securePayContactUsPage(driver);
    googlePage objGooglePage = new googlePage(driver);
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    TextProducer textProducer = fairy.textProducer();

    @Given("^User search for \"([^\"]*)\" on the google page$")
    public void User_search_for_securePay_on_google_page(String SearchText) throws Throwable {
        driver.get(Constants.url);
        objGooglePage.searchItem(SearchText);
        objGooglePage.clickSearch();
    }

    @And("^Click on the securePay website$")
    public void Click_on_the_securePay_website() throws Throwable {
        objGooglePage.clickSecurePay();
    }

    @When("^Navigates to the contact us page$")
    public void Navigates_to_the_contact_us_page() throws Throwable {
        objSecurePayPage.clickContactUsLink();
    }

    @And("^Verifies the contact us page \"([^\"]*)\" is loaded$")
    public void Verifies_the_contact_us_page_is_loaded(String strExpTittle) throws Throwable {
        objSecurePayPage.verifyTittle(strExpTittle);
    }

    @Then("^Fill the Contact us form with random generated data$")
    public void Fill_the_Contact_us_form_with_random_generated_data() throws Throwable {
        objSecurePayPage.enterFirstName(person.getFirstName());
        objSecurePayPage.enterLastName(person.getLastName());
        objSecurePayPage.enterEmail(person.getEmail());
        objSecurePayPage.enterPhone(person.getTelephoneNumber());
        objSecurePayPage.enterCompany(person.getCompany().getName());
        objSecurePayPage.enterWebsite(person.getCompany().getUrl());
        objSecurePayPage.selectAmount();
        objSecurePayPage.enterYourMessage(textProducer.text());
    }
}