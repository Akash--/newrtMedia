//get register on rt meadia...
package script;

import static org.junit.Assert.assertFalse;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import rtCampPageObject.SecurityQuestionLogic;


public class RegisterProcess {
	
	//initilize the varriable for webdriver
	private static WebDriver driver;
	int i=0;

	@BeforeMethod
	public void setUp() throws Exception {
		//create new instance of Firefox class
		driver=new FirefoxDriver();
		//to maximize browser window
		driver.manage().window().maximize();
		//go to that link 
		driver.get("http://demo.rtcamp.com/rtmedia/");
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if(i==1)
		{
			System.out.println("Register Successful");
		}
		else
		{
			System.out.println("Test Fail!!!! Not Register Successful");
		}
	
		//close the browser
        driver.close();
	

	}

	@Test
	public void test() {
		        //click on register text
				driver.findElement(By.linkText("Register")).click();
				//put the value of user name
				driver.findElement(By.id("signup_username")).sendKeys("Akash583");
				//put the value of name
				driver.findElement(By.id("field_1")).sendKeys("prakash");
				//put the value of email
				driver.findElement(By.id("signup_email")).sendKeys("akashchavan5432@yahoo.com");
				//put the value of password
				driver.findElement(By.id("signup_password")).sendKeys("Akash12345");
				//put the value of city
				driver.findElement(By.id("field_2")).sendKeys("nashik");
				//put the value of confirm password
				driver.findElement(By.id("signup_password_confirm")).sendKeys("Akash12345");
				//using Select class 
				Select gender=new Select(driver.findElement(By.id("field_3")));
				//check it is multiple or not
				assertFalse(gender.isMultiple());
				//select the male text
				gender.selectByVisibleText("Male");
				//ans is a function to get the ans and put in the  security question text
				SecurityQuestionLogic.ans(driver);
				//select the bithdate
				Select birthday=new Select(driver.findElement(By.id("field_4_day")));
				assertFalse(birthday.isMultiple());
				//select 24 text in the box
				birthday.selectByVisibleText("24");
				//select the month in month
				Select month=new Select(driver.findElement(By.id("field_4_month")));
			    assertFalse(month.isMultiple());
				//select october text
				month.selectByVisibleText("October");
				//select year
				Select year=new Select(driver.findElement(By.id("field_4_year")));
				assertFalse(year.isMultiple());
				//select 1993 text
				year.selectByVisibleText("1993");
				//click the submit button
				driver.findElement(By.id("signup_submit")).click();
				//to check it is register successfully or not
				assertEquals("Check Your Email To Activate Your Account!",driver.findElement(By.xpath("//*[@id='post-0']/header/h1")).getText());
				//print the message on console
				i++;
				
		        //fail("Not yet implemented");
	}

}
