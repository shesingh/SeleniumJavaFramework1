/* This library contains functions using JavascriptExecutor Interface
 * 
 * Syntax:
		 JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript(Script,Arguments);
		 script - The JavaScript to execute
		 Arguments - The arguments to the script.(Optional)
 */

package library;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtilities {

	//To change the background color of the element
	public static void changeColor(String color, WebDriver driver, WebElement element ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
	}

	//To flash the element by changing element background color again and again
	public static void flash(WebDriver driver, WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");

		for (int i=0; i<100; i++) {
			changeColor("rgb(200,0,90)",driver, element );
			changeColor(bgcolor,driver, element);
		}
	}

	//To draw border around element
	public static void drowBroder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border ='3px solid red'", element);
	}

	//To get innertext (entire content of the web page) of the entire webpage in Selenium
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sText =  js.executeScript("return document.documentElement.innerText;").toString();
		return sText;
	}

	//To get the Title of our webpage
	public static String getPageTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sText =  js.executeScript("return document.title;").toString();
		return sText;
	}

	//To get the domain of our webpage
	public static String getPageDomain(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sText =  js.executeScript("return document.domain;").toString();
		return sText;
	}

	//To get the URL of our webpage
	public static String getPageURL(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String sText =  js.executeScript("return document.URL;").toString();
		return sText;
	}

	//To click a button in Selenium WebDriver using JavaScript, This will work for cases where findelement.click may not work
	public static void clickElementByJS(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		// js.executeScript("document.getElementById('enter your element id').click();");
	}


	//To generate alert using JavaScript
	public static void generateAlert(WebDriver driver, String message){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");

	}

	//To refresh browser using JavaScript
	public static void refreshBrowserByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	//To navigate to different page/URL using Javascript
	public static void navigateToByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.location = 'https://www.softwaretestingmaterial.com'");
	}

	//To click check box using Javascript
	//In Java Script only get element by ID is available not by class or name or xpath etc.
	public static void clickCheckBoxJS(WebDriver driver, String webElementId){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		//Directly passing element ID value  - This is working
		//js.executeScript("document.getElementById('u_0_9').checked=true;");
		
		//Passing element ID variable name - Method 1 - This is working
		//js.executeScript("document.getElementById('"+webElementId+"').checked=true;");
		
		
		//Passing element ID variable name - Method 2 - This is working
		js.executeScript("document.getElementById(arguments[0]).checked=true",webElementId );
	}

	
	//To type text in input box without using sendKeys() method
	//In Java Script only get element by ID is available not by class or name or xpath etc.
	//TODO - Not working
	public static void setText(WebDriver driver, String webElementId, String sText) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Directly passing values - This is working
		js.executeScript("document.getElementById('email').value='778787878';");  
		
		//Passing element ID variable name - Method 1 - This is NOT working
		//js.executeScript("document.getElementById('"+webElementId+"').value='"+sText+";");  
		
		//Passing element ID variable name - Method 2 - This is NOT working
		//js.executeScript("document.getElementById(arguments[0]).value=arguments[1]",webElementId,sText);  
	}


	// To click on a SubMenu which is only visible on mouse hover on Menu using Javascript
	//TODO - No clue what this command means
	public static void clickMenuMouseHoverJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		//js.executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");
	}

	//To perform pixels by pixels Scroll on application using  Selenium  
	//TODO - Not working
	public static void pageScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Vertical scroll - down by 50  pixels
		//	 js.executeScript("window.scrollBy(0,500000)");
	}


	//To perform scroll down until end of the page is visible
	//TODO - Not working
	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	//To perform scroll down until specific element is visible
	//TODO - Not working
	public static void scrollIntoView(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


}
