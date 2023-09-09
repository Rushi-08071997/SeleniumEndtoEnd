package StepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.Portalpage;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Resources.Base;

public class stepDefination extends Base {
	LandingPage l;

	LoginPage lp;


	@Given("^initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = InitializeDriver();

	}

	@Given("^then navigate to the \"([^\"]*)\"$")
	public void then_navigate_to_the(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		driver.get(arg1);

	}

	@Given("^click on login link on homepage to land on login page$")
	public void click_on_login_link_on_homepage_to_land_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		l = new LandingPage(driver);
		lp = l.getLogIn();
	}
	
	@When("^user login through (.+) & (.+)$")
    public void user_login_through_(String username, String password) throws Throwable {
		lp.getEmail().sendKeys(username); // instead of hard coding we are sending dataprovider arguments

		lp.getpassword().sendKeys(password);

		lp.getSignIn().click();
	}

	
	@Then("^verify user issuccesfully logged in or not$")
	public void verify_user_issuccesfully_logged_in_or_not() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		Portalpage p=new Portalpage(driver);
		
		Assert.assertTrue(p.getsearchtab().isDisplayed());
		

	}
	
	  @And("^close the browser$")
	    public void close_the_browser() throws Throwable {
	     driver.quit();
	    }

}
