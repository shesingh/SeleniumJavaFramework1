/*
 * This class covers:
 * List all the links on page and display their text. Note - In page there are always some blank links
 * in xpath we can handle dynamic ID by using contains function ex //input[contains(@id, 'test')]
 */

//custon xPath Examples:
//input[@class='actextbox']
//input[@name='query']
//input[contains(@class,'actextbox')]
//input[contains(@id, 'test')]
//input[starts-with(@id, 'test')]
//input[ends-with(@id, 'test')]
//a[contains(text(),'My Account'] ---here text() is function so @text is not written.
//a[contains(text()='Alerts'] ---here text() is function so @text is not written. and I want to find exact match so used = instead of ,

/*I have checkbook to click next to Shefali. All this is in webtable.
 * First I find cell with text shefali ..then find its parent which is table...then find its preceding sibling and in that find the check box.
 * so here i moved child to parent and then from there I moved to parents sibling  and tehn from their I moved to its child
 * means from one cousin I idendifed other cousin element through xpath
 * like preceding-sibling their is forward-sibling
//a[text()='shefali]//parent=td(@class='datalistrow'//preceding-sibling[@class='datalistrow']//input[@name='contact_Id']
*/

/*
 * Soemtime we have to use xpath like below because we have to go to parent div to identify element uniquely.
 //div[@class='dropdown'//button[@type='button' and @class='btn btn-secondary dropdown toggle' and @id = 'dropdownmenubutton']
 */

/* This is absolute xpath so don't use this (not recommended). 
 * Disadvantages
 * 1. As developer can change the path and it may not work next day
 * 2. Also there has performance issue with  this.
 //html[1]/body[1]/div[3]/div[3]/div[3]/section[1]/div[1]/h2[1]
 //*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
 * 
 */


/* In page inspect do ctrl +F and their try to write xpath...try until we get 1/1 Element.
 * 
 */

package testNGTesing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.SetupBase;

public class NoOfLinks_CustomxPath extends SetupBase{

	@BeforeMethod
	public void setup() {
		SetupBase.initialization();
	}

	@Test
	public static void main() {
		driver.get("https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334");
		//to find no of links html tag =a, for input fields tag =input, for buttons tag= button
		List <WebElement> linktlist = driver.findElements(By.tagName("a"));
		int noOfLinks = linktlist.size();
		System.out.println("Total No of links on the page are: "+noOfLinks);
		
		for(int i=0; i<noOfLinks; i++) {
			String linkText = linktlist.get(i).getText();
			System.out.println(linkText);
		}
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}//main class
