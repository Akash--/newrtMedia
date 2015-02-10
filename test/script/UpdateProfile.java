//update the profile....
package script;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import rtCampPageObject.Login;

public class UpdateProfile
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
		Login.logout(driver);
	}

	@Test
	public void test() {
		 Login.login(driver);
		//click on Howdy text
		driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a")).click();
		//click on profile
	     driver.findElement(By.id("user-xprofile")).click();
	     //click on edit profile
		 driver.findElement(By.id("edit")).click();
		 //clear the field1
		 driver.findElement(By.id("field_1")).clear();
		 //clear the field2
		 driver.findElement(By.id("field_2")).clear();
		 //put the updated value in first text box
		 driver.findElement(By.id("field_1")).sendKeys("Akash chavan");
		 //put the update value in second text box
		 driver.findElement(By.id("field_2")).sendKeys("Nagpur");
		 //click to change the privacy
         driver.findElement(By.xpath("//*[@id='field-visibility-settings-toggle-2']/a")).click();
         //select the privacy
		 driver.findElement(By.xpath("//*[@id='field-visibility-settings-2']/fieldset/ul/li[4]/label/span")).click();
		 //select the year using select class
		 Select year=new Select(driver.findElement(By.id("field_4_year")));
		 AssertJUnit.assertFalse(year.isMultiple());
		 year.selectByVisibleText("1993");
		//click to change the privacy
		 driver.findElement(By.xpath("//*[@id='field-visibility-settings-toggle-4']/a")).click();
		 //select the privacy
		 driver.findElement(By.xpath("//*[@id='field-visibility-settings-4']/fieldset/ul/li[4]/label/span")).click();
			
		 //click on save change button 
		 driver.findElement(By.id("profile-group-edit-submit")).click();
		 
		 
		 assertEquals("Changes saved.",driver.findElement(By.xpath("//*[@id='message']/p")).getText());
		 
		 System.out.println("Profile updated");
	}

}
