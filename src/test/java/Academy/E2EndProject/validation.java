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
import pageobject.LandingPage;
import pageobject.LoginPage;
import pageobject.Popuphandler;

public class validation extends Base {
	
	public WebDriver driver; //so that we can run the test parallely
	
	private static Logger log=LogManager.getLogger(Base.class.getName());

	@BeforeTest  //to initialize driver before each test
	
	public void getdriver() throws IOException {
		
		
		driver=InitializeDriver();
		log.info("driver is initialized");
		
		 //we have defined the url in data.properties
			
	
			
	}
	
	
	@AfterTest //to close browser after each test

	public void BrowserClose()
	{
		
		driver.close();
		log.info("driver is closed");
	}
	
	@Test
	
	
	public void validate() throws IOException, InterruptedException {

		
		 driver.get(prop.getProperty("url"));
		
		
		//we'll create object of landing page to invoke methods
		
		LandingPage l=new LandingPage(driver);  //we have given driver argument to object for which we need to create constructor 
		
		
		//we are using assertion here to check whether the correct tittle is printed or not & if not script should fail
		
		Assert.assertEquals(l.Tittle().getText(),"FEATURED COURSES");
		
		System.out.println(l.Tittle().getText());
		
		log.info("text is verified");
		
		//to check whether nav bar is present or not & if not present test should fail
	
		Assert.assertTrue(l.getnavbar().isDisplayed());
		
		System.out.println("passed");
		
		log.info("test passed");
	}
	
	
	
	
		
	
}