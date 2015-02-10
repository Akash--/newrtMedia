//get register on rt meadia...
package script;

import static org.junit.Assert.assertFalse;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class RegisterProcess {
	
	//initilize the varriable for webdriver
	private static WebDriver driver;

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
		
         driver.close();
	//close the browser

	}

	@Test
	public void test() {
		//click on register text
				driver.findElement(By.linkText("Register")).click();
				//put the value of user name
				driver.findElement(By.id("signup_username")).sendKeys("Akash125");
				//put the value of name
				driver.findElement(By.id("field_1")).sendKeys("prakash");
				//put the value of email
				driver.findElement(By.id("signup_email")).sendKeys("akashchavan@gmail.com");
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
				
				// logic starts from here..........		
				 
				String aa=  driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText();
				int w=aa.length();
				if (w==7)
				{
				
				char num =  driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(0);
				char num2 = driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(4);
				char num4 = driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(2);
			    char min='+';
				String a=Character.toString(num);
				String c=Character.toString(num2);
				int p=Integer.parseInt(a);
				int q=Integer.parseInt(c);
				int r=0;
				if(num4==min) 
				{
					r=(p + q);
					String r1=Integer.toString(r);
					//put the ans
					driver.findElement(By.name("bp-security-check")).sendKeys(r1);
				}	
				
				else
				{
					r=(p - q);
					String r2=Integer.toString(r);
					driver.findElement(By.name("bp-security-check")).sendKeys(r2);
							
				}
				
			}
				else
				{
					char num =  driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(0);
					char num1 = driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(1);
					char num2 = driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(4);
					char num3 = driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(5);
					char num4 = driver.findElement(By.xpath("//*[@id='signup_form']/div[3]/label")).getText().charAt(3);
					String a=Character.toString(num);
					String b=Character.toString(num1);
					a=a.concat(b);
				    String c=Character.toString(num2);
					String d=Character.toString(num3);
					c=c.concat(d);
					int p=Integer.parseInt(a);
					int q=Integer.parseInt(c);
					int r=0;
					char min='+';
					if(num4==min) 
					{
						r=(p + q);
						String r1=Integer.toString(r);
						driver.findElement(By.name("bp-security-check")).sendKeys(r1);
				
					}	
					
					else
					{
						r=(p - q);
						String r2=Integer.toString(r);	
						driver.findElement(By.name("bp-security-check")).sendKeys(r2);
					}
					
				}
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
		      //fail("Not yet implemented");
	}

}
