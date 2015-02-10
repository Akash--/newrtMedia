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
	static int i=0;
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
	public  void tearDown() throws Exception {
		if(i==1)
		{
			System.out.println("Login success!!");
		}
		else
		{
			System.out.println("Test Fail!!!!");
		}
		
		  Login.logout(driver);		
		//driver.quit();
	}


	@Test
	public void test() throws Exception {
		     Login.login(driver);
		     i++;
		    	   
	}

}
