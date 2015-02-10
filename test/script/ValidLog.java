//Login with valid id and password
package script;

import org.testng.annotations.AfterMethod;
import static org.junit.Assert.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import rtCampPageObject.Login;



public class ValidLog {
	private static WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		        //initilize the firefox
				driver=new FirefoxDriver();
				//to maximize the window
				driver.manage().window().maximize();
				//to get the url
				driver.get("http://demo.rtcamp.com/rtmedia/");
	}

	@AfterMethod
	public static void logout() throws Exception {
		  Login.logout(driver);		
		//driver.quit();
	}


	@Test
	public void test() throws Exception {
		     Login.login(driver);
		     System.out.println("Login successful");		   
	}

}
