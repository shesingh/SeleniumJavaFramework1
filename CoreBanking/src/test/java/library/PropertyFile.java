/*
 * This class covers:
 * Methods to get & set properties in config.properties file.
 * 
 */

package TestUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFile {
	
	public static String projectPath = System.getProperty("user.dir");
	public static Properties prop = new Properties();
	
    public static void getProperties() {
		
		try {
			
			InputStream input = new FileInputStream(projectPath+"/src/test/resources/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			//System.out.println(browser);
			SetupBase.browser = browser;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
    
    
    
  public static void setProperties() {
		
		try {
			
			OutputStream output = new FileOutputStream(projectPath+"/src/test/resources/config.properties");
			prop.setProperty("browser", "firefox");
			prop.store(output, "comments");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
    
    @Test
    public void test() {
    	getProperties();
    	setProperties();
    	getProperties();
    }

}
