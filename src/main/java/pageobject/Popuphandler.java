package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Popuphandler {
	

    WebDriver driver;	//local driver
    
    //we have to give information about the driver having life to this local driver so we have created construcor
    
    public Popuphandler(WebDriver driver) //argument driver is from test class which we have invoked from initializedemo()
    {
    //we are giving life to our local driver using this which points  to the local driver ;	
    	
    	
    	this.driver=driver;
	}
    
    
   // By Popup=By.xpath("//body/div[4]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    
    By Popup=By.xpath("//div[@class='listbuilder-popup-scale']");
    
    By close=By.xpath("//button[contains(text(),'NO THANKS')]");
    
    
    
    public WebElement Popup() {
    	
    	return driver.findElement(Popup);
    }
    
public WebElement Close() {
    	
    	return driver.findElement(close);
    }

}
