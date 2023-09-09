package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	
        WebDriver driver;	//local driver
        
        //we have to give information about the driver having life to this local driver so we have created construcor
        
        public LandingPage(WebDriver driver) //argument driver is from test class which we have invoked from initializedemo()
        {
        //we are giving life to our local driver using this which points  to the local driver ;	
        	
        	
        	this.driver=driver;
		}
        
       
        
        By signin=By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]"); //here we have used regular expression to find element(*)
        
       
        
        By title=By.cssSelector("div[class='text-center'] h2");
        
        By navbar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
        
      
        
      
////h2[contains(text(),'Featured Courses')]

//we are creating special method here
        //as when we will click on login we will be directed to login page 
        //so here we are returning that page object so we dont need to create the object in test class
        
     public LoginPage getLogIn() {
        	
         driver.findElement(signin).click();
         LoginPage lp=new LoginPage(driver);
         return lp	;
        }
		
	
	
	public WebElement Tittle() {
    	
    	return driver.findElement(title);
    }
	
    public WebElement getnavbar() {
    	
    	return driver.findElement(navbar);
    }
	
}
