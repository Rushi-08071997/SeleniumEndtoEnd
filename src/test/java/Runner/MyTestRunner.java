package Runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Feature",
		glue="StepDefinations")

public class MyTestRunner {
	
	public WebDriver driver;
	
	@AfterTest
	public void close() {
		
		driver.close();
	}
	
	

}
