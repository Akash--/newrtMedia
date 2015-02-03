//Login with valid id and password
package script;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//import RTCampPageObjects.Login1;

public class ValidLog {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		driver=new FirefoxDriver();
		
		driver.get("http://demo.rtcamp.com/rtmedia/");
	}

	@AfterMethod
	public void logout() throws Exception {
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"));
		  
		   WebElement submain=(driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a")));
		   Actions action = new Actions(driver);
		   
		   action.moveToElement(mainMenu).perform();
		   
		   Thread.sleep(2000);
		   action.click(submain).perform();

		   driver.close();
		
		//driver.quit();
	}

	@Test
	public void test() throws Exception {
		//click on log in text
		driver.findElement(By.linkText("Log in")).click();
		//put the user name
		driver.findElement(By.id("user_login")).sendKeys("Akash1234");
		//put the password
		driver.findElement(By.id("user_pass")).sendKeys("Akash1234");
		//click the submit button
		driver.findElement(By.id("wp-submit")).click();
		
				
		//fail("Not yet implemented");
	}

}
