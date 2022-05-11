package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Fakat;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.io.File;
import java.net.URL;

public class StepDefinition01 {

    HomePage homePage=new HomePage();
    RegistrationPage registrationPage=new RegistrationPage();
    Faker faker=new Faker();
    String fullName;


    Actions actions;

    @Given("Navigate to url {string}")
    public void navigate_to_url(String Url) {
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Automation Exercise"));

    }
    @Then("Click on {string} button")
    public void click_on_button(String string) {

        homePage.signupLoginLink.click();

    }
    @Then("Verify {string} is visible")
    public void verify_is_visible(String string) {
      Assert.assertTrue(homePage.newUserSignupText.isDisplayed());

    }
    @Then("Enter name and email address")
    public void enter_name_and_email_address() {

        fullName=faker.name().fullName();
        registrationPage.signupName.sendKeys(fullName);
        registrationPage.signupEmail.sendKeys(faker.internet().emailAddress());
        System.out.println("fullName = " + fullName);

    }
    @When("Click {string} button")
    public void click_button(String button) {

        switch (button) {

            case "Signup":
                registrationPage.signupButton.click();
                break;
            case "Create Account button":
                registrationPage.createdAccountButton.click();
                break;
            case "Continue":
                registrationPage.continueButton.click();
                break;


        }

    }


    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String text) {

        switch (text){

            case"ENTER ACCOUNT INFORMATION":
                ReusableMethods.waitForVisibility(registrationPage.enterAccountInfoText,7);
                Assert.assertTrue(registrationPage.enterAccountInfoText.isDisplayed());
                break;
            case"ACCOUNT CREATED!":
                ReusableMethods.waitForVisibility(registrationPage.accountCreatedText,7);
                Assert.assertTrue(registrationPage.accountCreatedText.isDisplayed());
                break;
            case"Logged in as username":
                Assert.assertTrue(registrationPage.loggedInElement.getText().contains(fullName));




        }



    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {

        actions=new Actions(Driver.getDriver());
       actions.click(Driver.getDriver().findElement(By.id("id_gender1")))
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.internet().password())
               .sendKeys(Keys.TAB).perform();
        Select select=new Select(registrationPage.birthDay);
        int day=faker.number().numberBetween(0,27);
        select.selectByIndex(day);
        Select select1=new Select(registrationPage.birthMounth);
        int mount=faker.number().numberBetween(0,11);
        select1.selectByIndex(mount);
        Select select2=new Select(registrationPage.birthYear);
        int year=faker.number().numberBetween(1960,2005);
        String yearStr= String.valueOf(year);
        select2.selectByVisibleText(yearStr);


    }
    @Then("Select checkbox {string}")
    public void select_checkbox(String string) {

        actions.click(registrationPage.signUpSelect).sendKeys(Keys.TAB).click().perform();


    }
    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {



        actions.sendKeys(Keys.TAB).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(faker.company().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().streetAddressNumber()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddressNumber()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().state()).sendKeys(Keys.TAB).sendKeys(faker.address().city())
                .sendKeys(Keys.TAB).sendKeys(faker.code().gtin8()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).perform();

        int Country=faker.number().numberBetween(0,5);
        Select select=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='country']")));
        select.selectByIndex(Country);

    }
    @Then("Click {string}")
    public void click(String string) {

    }

    @Then("Verify that {string} is visible and click {string} button")
    public void verify_that_is_visible_and_click_button(String string, String string2) {
        registrationPage.deleteAccountButton.click();

    }

}
