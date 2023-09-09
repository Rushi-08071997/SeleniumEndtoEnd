 package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {

	
	
        WebDriver driver;	//local driver
        
        //we have to give information about the driver having life to this local driver so we have created construcor
        
        public Forgotpassword(WebDriver driver) //argument driver is from test class which we have invoked from initializedemo()
        {
        //we are giving life to our local driver using this which points  to the local driver ;	
        	
        	
        	this.driver=driver;
		}
        
       
       By email=By.id("user_email");
       
       By Instruction=By.cssSelector("input[type='submit']");
       
       
       
       public WebElement getemail()
       {
    	   return driver.findElement(email);
       }
       
       
       public WebElement getInstruction()
       {
    	   return driver.findElement(Instruction);
       }
       
       
       
}