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
   private WebDriver driver;

   @BeforeMethod
public void setUp() throws Exception {
	   
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.rtcamp.com/rtmedia/");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		//click on log in text
		driver.findElement(By.linkText("Log in")).click();
		//put the user name
		driver.findElement(By.id("user_login")).sendKeys("Akash123");
		//put the password	
		driver.findElement(By.id("user_pass")).sendKeys("Akash1234");
		//click the submit button
		driver.findElement(By.id("wp-submit")).click();
		//verify the error 
		assertEquals("ERROR",driver.findElement(By.xpath("//*[@id='login_error']/strong")).getText());
		//Assert.fail("Not yet implemented");
	}

}
