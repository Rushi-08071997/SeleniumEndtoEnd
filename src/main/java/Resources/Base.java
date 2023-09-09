package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	  public WebDriver driver;
	  
	  public Properties prop; //we are defining it public as we need to use properties in another class 
	
	public WebDriver InitializeDriver() throws IOException {
		
		//System.getProperty("user.dir") gets you upto the project path & then you can concatenate the path in this way you can set the path dynamically
		
		prop =new Properties(); 
		
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		
		//String Browsername=prop.getProperty("browser");
		
	String Browsername=System.getProperty("browser"); //it will drive the browser from mabven command in which you need to provide a name
		
		
		if(Browsername.contains("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\Resources\\chromedriver.exe");
			 
			//we are Chromeoptions class object to run test in browser headless mode
			 
			 ChromeOptions option=new ChromeOptions();
			 
			 //we have writen a code in such a way that you can run in both mode as required
			 
			 if(Browsername.contains("headless")) {
				 
				 option.addArguments("headless");
					
			 }
			  
			    driver=new ChromeDriver(option);
			
		}
		
		
		if(Browsername.equals("Firefox"))
		{
			 System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\src\\main\\java\\Resources\\geckodriver.exe");

			    driver=new FirefoxDriver();
		}
		
		if(Browsername.equals("InternetExplorer"))
		{
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public String getscreenshot(String Testcasename, WebDriver driver) throws IOException {
		//after creating driver instance in testnglistener this "driver" will points to that driver declared in an argument
		TakesScreenshot ts=(TakesScreenshot)driver; 
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		//here we are giving path to store the screen shot
		//user.dir means path upto the project name
		//Testcasename we are deriving from listener class
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+Testcasename+".png";
		
		FileUtils.copyFile(src, new File(destinationfile));
		
		return destinationfile; //we are returning destination file path here so that we can use it in "addScreenCaptureFromPath" method
	}
	

}
