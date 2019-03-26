/*
 * There are several type of popup.
 * 1. alerts ---- Java Script popup .....Alery API(accept , dismiss method)
 * 2. File upload popup ....Browse button (type file, sendKeys(path)
 * 3. Browser Window popup - Usually advertismnet popup (window handler API - getWindowHandles())
 * 
 */

package testNGTesing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import library.SetupBase;

public class Dropdown_SelectClass_Alert_fileUpload extends SetupBase{

	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	@Ignore
	@Test
	public static void dropdowm() throws InterruptedException {
		driver.get("https://www.sanwebe.com/2014/08/css-html-forms-designs");	
		System.out.println("Selecting dropdown value");
		WebElement dropdowm = driver.findElement(By.name("field4"));
		Select select = new Select(dropdowm);
		select.selectByVisibleText("General");	
		Thread.sleep(4000);
	}

	@Ignore
	@Test
	public static void alert_popup() throws InterruptedException {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");	
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); //to click OK button on pop Up.
		//alert.dismiss();//to click Cancel button on pop Up.

	}


	@Test
	public static void fileUpload() throws InterruptedException {
		driver.get("https://html.com/input-type-file/");
		//below we can not use .click as Selenium cannot handle windows popup.
		//Below command will work only if element type (In this case Browse button) is file
		driver.findElement(By.xpath("//input[@value='fileupload']")).sendKeys("C:\\Users\\shefali.singh.GROUPINFRA\\git\\SeleniumJavaFramework1\\CoreBanking\\files\\Test");
		
		Thread.sleep(4000);

	}

	@AfterMethod
	public void tearDown() {

		//driver.quit();
	}


}
