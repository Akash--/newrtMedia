package rtCampPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityQuestionLogic {
	
	public static void ans(WebDriver driver){
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
			a=a+b;
		    String c=Character.toString(num2);
			String d=Character.toString(num3);
			c=c+d;
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
	
	}
}
