//upload the media....
package script;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.event.*;
//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class UploadMediaFromClient {
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
		   driver.close();
	}

	@Test

		
		public void test() throws IOException, AWTException, InterruptedException 
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
			//click to attach file	    
		    driver.findElement(By.id("rtMedia-upload-button")).click();
		    Thread.sleep(3000);
		    
		    //upolade the file from client to server
		    
		    StringSelection ss=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
		    
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
		    
		    //wait for 3 sec
		    Thread.sleep(5000);
		    //cilck on start upload button
		    driver.findElement(By.className("start-media-upload")).click();

		    
		    
		   
		    
		    
	//	fail("Not yet implemented");
	}

}
