//TODO - Using Naveen Automation lab - 12

package testNGTesing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import library.JavascriptExecutorUtilities;
import library.SetupBase;
import library.TestUtilities;

public class JavaScriptExecutorTest extends SetupBase{

	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	@Test
	@Ignore
	//To flash the web element
	public static void flashElement() {
		driver.get("http://www.google.com/");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		JavascriptExecutorUtilities.flash(driver, element);

		element = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']"));
		JavascriptExecutorUtilities.flash(driver, element);
	}




	@Test
	@Ignore
	//To draw border around element
	public static void drawBorder() {
		driver.get("http://www.google.com/");
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		JavascriptExecutorUtilities.drowBroder(driver, element);
	}

	@Test
	@Ignore
	//To get innertext (entire content of the web page) of the entire webpage in Selenium
	public static void displayPageInnerText() {
		driver.get("http://www.google.com/");
		String vText = JavascriptExecutorUtilities.getPageInnerText(driver);
		System.out.println(vText);


	}


	@Test
	@Ignore
	//To get the Title of our webpage
	public static void displayTitle() {
		driver.get("http://www.google.com/");
		String vText = JavascriptExecutorUtilities.getPageTitle(driver);
		System.out.println(vText);
	}

	@Test
	@Ignore
	//To get the Domain of our webpage
	public static void displayDomain() {
		driver.get("http://www.google.com/");
		String vText = JavascriptExecutorUtilities.getPageDomain(driver);
		System.out.println(vText);
	}

	@Test
	@Ignore
	//To get the URL of our webpage
	public static void displayURL() {
		driver.get("http://www.google.com/");
		String vText = JavascriptExecutorUtilities.getPageURL(driver);
		System.out.println(vText);
	}


	@Test
	@Ignore
	//To click a button in Selenium WebDriver using JavaScript, This will work for cases where findelement.click may not work
	public static void jsClick() {
		driver.get("https://www.facebook.com/");
		WebElement element = driver.findElement(By.xpath("//input[@value='Log In']"));
		JavascriptExecutorUtilities.clickElementByJS(element, driver);
	}

	@Test
	@Ignore
	//To generate alert using JavaScript
	public static void generateAlertTest() {
		driver.get("http://www.google.com/");
		String text = "Hello World";
		JavascriptExecutorUtilities.generateAlert(driver, text);
	}

	@Test
	@Ignore
	//To refresh browser using JavaScript
	public static void refreshBrowserTest() {
		driver.get("http://www.google.com/");
		JavascriptExecutorUtilities.refreshBrowserByJS(driver);
		//same is done by using selenium
		driver.navigate().refresh(); 
	}

	@Test
	@Ignore
	//To navigate to different page/URL using Javascript
	public static void navigateToTest() throws Exception {
		driver.get("http://www.google.com/");
		//Thread.sleep(2000);
		JavascriptExecutorUtilities.navigateToByJS(driver);
	}

	@Test
	@Ignore
	//To click check box using Javascript
	public static void checkBoxTest() {
		driver.get("https://www.facebook.com/");
		String webElementId = "u_0_9";
		JavascriptExecutorUtilities.clickCheckBoxJS(driver, webElementId);
	}

	@Test
	@Ignore
	//TODO - Not working
	//To type text in inputbox without using sendKeys() method
	public static void writeText() {
		driver.get("https://www.facebook.com/");
		String webElementId = "email";
		String text = "ABCDE";
		JavascriptExecutorUtilities.setText(driver, webElementId, text);
	}

	@Test
	@Ignore
	//TODO - Not working
	//To click on a SubMenu which is only visible on mouse hover on Menu using Javascript
	public static void mouseHoverTest() {
		driver.get("https://www.spicejet.com/");
		JavascriptExecutorUtilities.clickMenuMouseHoverJS(driver);
	}


	@Test
	@Ignore
	//TODO - Not working
	//To perform pixels by pixels Scroll on application using  Selenium  
	public static void scrollDown() {
		driver.get("https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/");
		JavascriptExecutorUtilities.pageScroll(driver);
	}

	@Test
	@Ignore
	//TODO - Not working
	//To perform scroll down until end of the page is visible
	public static void scrollDownEOP() {
		driver.get("https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/");
		JavascriptExecutorUtilities.scrollPageDown(driver);
	}


	@Test
	@Ignore
	//TODO - Not working
	//To perform scroll down until specific element is visible
	public static void scrollDownTillElement() {
		driver.get("https://www.softwaretestingmaterial.com/javascriptexecutor-selenium-webdriver/");
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Full Name']")); 
		JavascriptExecutorUtilities.scrollIntoView(element, driver);
	}



	@AfterMethod
	public void tearDown() throws InterruptedException { 
		//Thread.sleep(2000);
		//driver.quit();
	}

}
