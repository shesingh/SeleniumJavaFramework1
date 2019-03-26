package testNGTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import library.SetupBase;

public class Frame_MouseMov_ActionClass extends SetupBase{


	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	
	@Test
	@Ignore
	public static void mouseMovement() throws Throwable {

		driver.get("https://www.spicejet.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();

		driver.findElement(By.linkText("SpiceLounge")).click();

	}

	@Test
	public static void dragDropFrame() throws Throwable {

		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(0);

		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")))
		.build()
		.perform();

	}


	@AfterMethod
	public void tearDown() { 
		//driver.quit();
	}
}
