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

import rtCampPageObject.Login;

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
		  Login.logout(driver);
	}

	@Test

		
		public void test() throws IOException, AWTException, InterruptedException 
		{
		     Login.login(driver);
		  
		    //click on Howdy text
			driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a")).click();
			//click on media text 
			driver.findElement(By.id("user-media")).click();
			//click on albums
			driver.findElement(By.id("rtmedia-nav-item-albums")).click();
			//select the albums
			driver.findElement(By.xpath("//*[@id='item-body']/div[2]/ul/li[2]/div[1]/a/img")).click();
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
		    Thread.sleep(3000);
		    //cilck on start upload button
		    driver.findElement(By.className("start-media-upload")).click();

		    //print message on console
		    System.out.println("File Upoaded!!!");
	}

}
