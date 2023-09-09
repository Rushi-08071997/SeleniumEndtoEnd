package Academy.E2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageobject.Forgotpassword;
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.Popuphandler;

public class Homepage extends Base {
	
	WebDriver driver;
	
	LandingPage l;
	
	
	Popuphandler ph;
	
	private static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest  //to initialize driver before each test
	
	public void getdriver() throws IOException {
		
		
		
		driver=InitializeDriver();
		
		log.info("driver is initialized");
		
		 //we have defined the url in data.properties
		
		//we'll create object of landing page to invoke methods
		
	 l=new LandingPage(driver);  //we have given driver argument to object for which we need to create constructor
	 
	//we have to create object for login page 
		
	
			
	}
	
	
	@AfterTest //to close browser after each test

	public void BrowserClose()
	{
		
		driver.close();
		
	}
	
	
	
	@Test(dataProvider="userdata")
	//we need to pass the dataprovider fields as a argument here in testcase method
	
	public void HomePageNavigation(String username,String password,String text) throws IOException, InterruptedException {
		
		
		 driver.get(prop.getProperty("url"));
		 
		 Popuphandler ph=new Popuphandler(driver);
		 
		 if(ph.Popup().isDisplayed()) {
			 ph.Close().click();
		 }
		 
		 //so here we are calling the method which we have created in landing page object for login page
		 
		LoginPage lp=l.getLogIn();
		
		lp.getEmail().sendKeys(username); //instead of hard coding we are sending dataprovider arguments
		
		lp.getpassword().sendKeys(password);
		
		lp.getSignIn().click();
		
		log.info(text);
		
		//so here we are calling the method which we have created in login page object for forgotpassword page
		Forgotpassword fp=lp.forgotpassword();
		
		fp.getemail().sendKeys("Nrestricted user@gmail.com");
		
		fp.getInstruction().click();
		
		
		
	}
	
	
		
	
	//we need to test with different users so we are defining dataprovider from which we'll drive the data into test
	
	@DataProvider
	
	public Object[][] userdata() {
		
		Object[][] data =new Object[2][3];
		
		//rows define for how many diff data types test should run
		//colum stands for no.of fields
		
		data[0][0]="restricteduser@gmail.com";
		data[0][1]="4637123";
		data[0][2]="Restrcited User";

		data[1][0]="Nonrestricteduser@gmail.com";
		data[1][1]="64856123";
		data[1][2]="NonRestrcited User";
				
		return data;
		
		
	}
	
	
	
}

