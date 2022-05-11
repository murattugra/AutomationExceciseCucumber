package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {




    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(),this);



    }



    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signupEmail;

    @FindBy(xpath = "//button[.='Signup']")
    public WebElement signupButton;


    @FindBy(xpath = "//h2[.='Enter Account Information']")
    public WebElement enterAccountInfoText;

    @FindBy(id = "days")
    public WebElement birthDay;

    @FindBy(id = "months")
    public WebElement birthMounth;

    @FindBy(id = "years")
    public WebElement birthYear;

    @FindBy(xpath = "//button[.='Create Account']")
    public WebElement createdAccountButton;

    @FindBy(id ="newsletter")
    public WebElement signUpSelect;

    @FindBy(xpath = "//a[.='Continue']")
    public  WebElement continueButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "(//a)[10]")
    public WebElement loggedInElement;

    @FindBy(xpath = "//a[.=' Delete Account']")
    public WebElement deleteAccountButton;



}
