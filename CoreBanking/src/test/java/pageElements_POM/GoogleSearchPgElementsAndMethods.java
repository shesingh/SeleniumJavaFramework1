package pageElements_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPgElementsAndMethods {
	
	static WebDriver driver;
	
	// define all the objects on the page here
	By textbox_search = By.xpath("//input[@title='Search']");
	By search_button = By.xpath("//input[@type='submit'][@name='btnK']	");
	
	//constructor to initialize the object to get the driver instance from 
	public GoogleSearchPgElementsAndMethods(WebDriver driver) {
		GoogleSearchPgElementsAndMethods.driver = driver;
	}

	//function to enter text in search box.
	public void setTextInSearchBox (String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
		
	//function to click search button.
	public void clickSearchButton() {
		driver.findElement(textbox_search).sendKeys(Keys.RETURN);
		//driver.findElement(search_button).sendKeys(Keys.RETURN);
	}
	
}
