package rtCampPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Login  {

	public static void login(WebDriver driver)
	{
		driver.findElement(By.linkText("Log in")).click();
		//put the user name in the user name text box
		driver.findElement(By.id("user_login")).sendKeys("Akash1234");
		//put the password in the password text box
		driver.findElement(By.id("user_pass")).sendKeys("Akash1234");
		//click to the submit button
		driver.findElement(By.id("wp-submit")).click();
	
	}
	
     public static void logout(WebDriver driver) throws InterruptedException
     {
    	   WebElement mainMenu = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"));
		  
		   WebElement submain=(driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a")));
		   Actions action = new Actions(driver);
		   
		   action.moveToElement(mainMenu).perform();
		   
		   Thread.sleep(2000);
		   action.click(submain).perform();

		   driver.close();

     }
}
