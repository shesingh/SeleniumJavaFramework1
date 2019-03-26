

package testNGTesing;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.SetupBase;

public class HandleWindowPopUp extends SetupBase{


	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	@Test
	public static void main() {
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[@class='black']")).click();

		//Set object don't store values with index like array so we have to use iterator to iterate the values
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowID = it.next();
		System.out.println("Parent Window ID" +parentWindowID);
		String childWindowID = it.next();
		System.out.println("Parent Window ID" +childWindowID);
		driver.switchTo().window(childWindowID);
		System.out.println("Child window Popup title " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowID);
		System.out.println("Parent window Popup title " + driver.getTitle());
	}

	@AfterMethod
	public void tearDown() { 
		//driver.quit();
	}


}
