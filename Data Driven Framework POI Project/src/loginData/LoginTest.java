package loginData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import excellUtility.ReadExcelSheet;
import utility.Constants;

public class LoginTest {
	public void loginSetUp() throws IOException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url=Constants.URL;
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		ReadExcelSheet rs=new ReadExcelSheet();
		ArrayList userName=rs.readExcellData(0);
		ArrayList userPass=rs.readExcellData(1);
		
		for(int i=1;i<userName.size();i++)
		{
			driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
			WebElement username=driver.findElement(By.xpath("//input[@name='user[email]']"));
			String userString=(String) userName.get(i);
			username.sendKeys(userString);
			
			WebElement userpass=driver.findElement(By.xpath("//input[@name='user[password]']"));
			String userPassString=(String) userPass.get(i);
			userpass.sendKeys(userPassString);
			
			WebElement signIn=driver.findElement(By.xpath("//button[@type='submit']"));
			signIn.click();
			
			WebElement profileclick=driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));
			profileclick.click();
			
			WebElement signout=driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			signout.click();
		}
		
	}

}
