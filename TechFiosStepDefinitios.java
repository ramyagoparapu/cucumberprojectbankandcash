package steps;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.BankAndCash;

import pages.LoginPage;
import pages.TestBase;

public class TechFiosStepDefinitios extends TestBase {
	String data;
	LoginPage loginpage;// intialising globle variable
	BankAndCash bankAndCash;


	@Before
	public void beforerun() {
		initDriver(); // Initializing driver
		loginpage = PageFactory.initElements(driver, LoginPage.class);// defining page object with driver
	
		bankAndCash = PageFactory.initElements(driver, BankAndCash.class);
	}

	// Given User is on techfios login page
	@Given("^User is on techfios login page$")
	public void user_is_on_techfios_login_page() throws InterruptedException {
		driver.get("https://techfios.com/billing/?ng=login/");
		
        System.out.println("Given User is on techfios login page");
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as_(String username) throws InterruptedException {
		loginpage.insertUserName(username);// we passing value from feature
		//Thread.sleep(1000);

	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) throws Throwable {
		loginpage.insertPassword(password);// we passing value from from feature
		//Thread.sleep(1000);

	}
//	@When("^User clicks on \"([^\"]*)\"$")
//	public void user_clicks_on_signin() throws Throwable {
//		loginpage.clickSignin();
//		Thread.sleep(3000);
//	}
	@Then("^User should land on dashboardpage$")
    public void user_should_land_on_dashboardpage() throws Throwable {
	  String expectedTitle = "Dashboard- iBilling";//xpath   
      String actualPage = loginpage.getpageTitle();
	  Assert.assertEquals(expectedTitle, actualPage);//validating
      takeScreenshot(driver);
	}
	@And ("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String button)  {
		switch(button) {
		case "Signin":
			loginpage.clickSignin();
		
		case "dashboardpage":
			loginpage.getpageTitle();
			
		case "Bank & cash":
			bankAndCash.clicksOnbankAndcash();
			
			break;
		case "New Account":
		    bankAndCash.clicksOnNewAccount();
		 
		    break;
		default:
			System.out.println("unable to click");
		}	
	}  
        
//	@Then("^User clicks on \"([^\"]*)\"$")
//	_clicks_on_Bankandcash() throws Throwable {
//		bankAndCash.clickbankandcash();
//		Thread.sleep(30public void user00);
//		
//	}
//
//	@Then("^User clicks on \"([^\"]*)\"$")
//	public void user_clicks_on_NewAccount() throws Throwable {
//		bankAndCash.clickNewAccount();
//		Thread.sleep(3000);
//	}
	@Then ("^User should land on \"([^\"]*)\"$")
    public void user_should_land_on(String accounts) {
		if(driver.getPageSource().contains("Add New Account\r\n"
				+ "")) {
		Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}	

	@Then("^User enters on \"([^\"]*)\"$")
	public void user_Enters(String data) {
		switch (data) {
		case "accountTitle":
			bankAndCash.enterAccountTitle(data);
			
			break;
		case "description":
			bankAndCash.insertDiscription(data);
			break;
		case "initialBalance":
			bankAndCash.insertInitialBalance(data);
			break;
		case "accountNumber":
			bankAndCash.insertAccountNumber(data + generateRandomNumber(999));
			break;
		case "contactPerson":
			bankAndCash.insertContactPerson(data);
			break;
		case "phoneNumber":
			bankAndCash.insertPhoneNumber(data);
			break;
		case "internetBankingURL":
			bankAndCash.insertinternetBankURL(data);
		
			default:
			System.out.println("unable to enter data");
		}
	}

	@And("^User clicks on Submit$")
	public void USER_clicks_on_Submit() throws InterruptedException {
		bankAndCash.clickSubmitbutton();
		
	}

//	//@Then("^User should be able to validate account created successfully$")
//	public void user_should_be_able_to_validate()throws InterruptedException, IOException {
//		String expectedmassege = "Account created succeccfully";
//		String actualmassege = bankAndCash.validatecreatedAcount();
//		
//		Assert.assertEquals(expectedmassege, actualmassege);
//		takeScreenshot(driver);
//	}

	
//
//	@After
//	public void teardown() {
//		driver.close();
//		driver.quit();
//	}
}
