package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Portalpage {
	
	public WebDriver driver;
	
	By searchtab=By.xpath("input[@id='search-courses']");
	
	
	public Portalpage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public WebElement getsearchtab() {
		
		return driver.findElement(searchtab);
	}

}
