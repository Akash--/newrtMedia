//login with invalid id and password 
package script;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import static org.junit.Assert.*;
//import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvalidLog 
{
	//create a instance of WebDriver interface
   private WebDriver driver;
   int i=0;

   @BeforeMethod
public void setUp() throws Exception {
	    //Initialize the variable to firefoxDriver class
	    driver=new FirefoxDriver();
	    //to maximize the window
	     driver.manage().window().maximize();		
		//to get the url
		driver.get("http://demo.rtcamp.com/rtmedia/");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		
		if(i==1)
		{
			System.out.println("login error!!!! test pass");
		}
		else
		{
			System.out.println("Test Fail!!!!");
		}
		//close the driver
		driver.close();
	}

	@Test
	public void test()throws Exception {
	
		//click on log in text
		driver.findElement(By.linkText("Log in")).click();
		//put the user name
		driver.findElement(By.id("user_login")).sendKeys("Akash123");
		//put the password	
		driver.findElement(By.id("user_pass")).sendKeys("Akash1234");
		//click the submit button
		driver.findElement(By.id("wp-submit")).click();
		//verify the error 
		assertEquals("ERROR: Invalid username. Lost your password?",driver.findElement(By.id("login_error")).getText());
		//print the message on console
		i++;

 }
	
	

	 
}
