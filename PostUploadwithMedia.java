//to updating the post according to privacy and media...
package script;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import RTCampPageObjects.Login1;

public class PostUploadwithMedia {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception
	{
		//create an instance of web driver
		 driver=new FirefoxDriver();
	     //to maximize the window
	     driver.manage().window().maximize();
		//get the url
	     driver.get("http://demo.rtcamp.com/rtmedia/");

	}

	@AfterMethod
	public void tearDown() throws Exception
	{
		//click to the log out 
		 WebElement mainMenu = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"));
		  
	     WebElement submain=(driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a")));
	     Actions action = new Actions(driver);
		   
	     action.moveToElement(mainMenu).perform();
		   
	     Thread.sleep(2000);
		 action.click(submain).perform();
		 driver.close();
	}

	@Test
	public void test() throws Exception 
	{
        driver.findElement(By.linkText("Log in")).click();
		//put the user name in the user name text box
		driver.findElement(By.id("user_login")).sendKeys("Akash1234");
		//put the password in the password text box
		driver.findElement(By.id("user_pass")).sendKeys("Akash1234");
		//click to the submit button
		driver.findElement(By.id("wp-submit")).click();
		//click on my account button 
		driver.findElement(By.linkText("Howdy, Akash")).click();
		//click the activity button
		driver.findElement(By.xpath("//*[@id='user-activity']")).click();
		 //select the post option
		Select post=new Select(driver.findElement(By.id("activity-filter-by"))); 
		AssertJUnit.assertFalse(post.isMultiple());
		post.selectByVisibleText("Posts");
		//put the post 
		driver.findElement(By.id("whats-new")).sendKeys("Hiii");
		 //select the privacy
		Select privacy=new Select(driver.findElement(By.id("rtSelectPrivacy")));
		AssertJUnit.assertFalse(privacy.isMultiple());
		privacy.selectByVisibleText("Private");
		//click to attach file 
		driver.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		
		
		
		//to attached file 
		StringSelection ss=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Hydrangeas.jpg");
	    
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    
	    Robot r =new Robot();
	    
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);    
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    
	    Thread.sleep(3000);
	    
		
		//cilck on post update button
	    driver.findElement(By.id("aw-whats-new-submit")).click();
		
		
		//fail("Not yet implemented");
		 
		
	}

}
