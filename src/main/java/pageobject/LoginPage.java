

package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	
        WebDriver driver;	//local driver
        
        //we have to give information about the driver having life to this local driver so we have created construcor
        
        public LoginPage(WebDriver driver) //argument driver is from test class which we have invoked from initializedemo()
        {
        //we are giving life to our local driver using this which points  to the local driver ;	
        	
        	
        	this.driver=driver;
		}
        
        By Email=By.id("user_email"); 
        
        By password=By.id("user_password");
        
        By SignIn=By.cssSelector("input[type='submit']");      
        
        By Error =By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]");
      
        By forgotpassword=By.linkText("Forgot Password?");
        
        
        
        
        public Forgotpassword forgotpassword() {
        	
        	driver.findElement(forgotpassword).click();
        	
        	Forgotpassword fp =new Forgotpassword(driver);
        	
        	return fp;
        }


		public WebElement getEmail() {
        	
        	return driver.findElement(Email);
        }
	
		
         public WebElement getpassword() {
        	
        	return driver.findElement(password);
        }
         
         
          public WebElement getSignIn() {
	
	        return driver.findElement(SignIn);
        }
          
          public WebElement getError() {
        		
  	        return driver.findElement(Error);
          }

}
