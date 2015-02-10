//upload the meadia through url....
package script;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;




public class UploadMediaThroughURL
{
   private WebDriver driver;
   
	@BeforeMethod
	public void setUp() throws Exception 
	{
		//create instance of firefox
		driver=new FirefoxDriver();
		//to get maximize window
		driver.manage().window().maximize();
		//to go that url
		driver.get("http://demo.rtcamp.com/rtmedia/");
	}
	@AfterMethod
	public void tearDown() throws Exception {
		 //click to the log out using mouse over
		   WebElement mainMenu = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"));
		  
		   WebElement submain=(driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a")));
		   Actions action = new Actions(driver);
		   
		   action.moveToElement(mainMenu).perform();
		   
		   Thread.sleep(2000);
		   action.click(submain).perform();
		   //close the driver
		   driver.close();

	}

	@Test
	public void test() throws IOException, AWTException 
	{
		
		        //click to the login
				driver.findElement(By.linkText("Log in")).click();
				//put the user name
				driver.findElement(By.id("user_login")).sendKeys("Akash1234");
				//put the password
				driver.findElement(By.id("user_pass")).sendKeys("Akash1234");
				//click on submit button
				driver.findElement(By.id("wp-submit")).click();
				//click on Howdy text
				driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a")).click();
				//click on media text 
				driver.findElement(By.id("user-media")).click();
				//click on upload text
				driver.findElement(By.id("rtm_show_upload_ui")).click();
				//click on check box 
				driver.findElement(By.id("rtmedia_upload_terms_conditions")).click();
				//store in web element in ele
				WebElement ele=driver.findElement(By.id("rtmedia_url_upload_input"));
				//put the url
				ele.sendKeys("http://allthingsd.com/files/2013/02/google_campus.jpg");
				//wait to upload
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//to get outside cursor from text area used tab 
				ele.sendKeys(Keys.TAB);
				//click on start upload button
		        driver.findElement(By.className("start-media-upload")).click();
		


		
	//	fail("Not yet implemented");
	}


		
	}


