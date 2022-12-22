package loginData;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CrossBrowserTesting1 {
	WebDriver driver;
	@Test
	@Parameters("Browser")
  public void setUpBrowser(String Browser) 
  {
	  if(Browser.equalsIgnoreCase("Chrome"))
	  {
		  System.out.println("Chrome started");
		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("https://www.google.com/");
		  String actualTitle="Google";
		  if(actualTitle.equals(driver.getTitle()))
		  {
			  System.out.println("Test Passed");
		  }
		  else
		  {
			  System.out.println("Test Failed");
		  }
		  driver.close();
	  }
	  else if(Browser.equalsIgnoreCase("Firefox"))
	  {
		  System.out.println("Firefox started");
		  System.setProperty("webdriver.geko.driver",System.getProperty("user.dir")+"\\gekodriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get("https://www.google.com/");
		  String actualTitle="Google";
		  if(actualTitle.equals(driver.getTitle()))
		  {
			  System.out.println("Test Passed");
		  }
		  else
		  {
			  System.out.println("Test Failed");
		  }
		  driver.close();
	  }
  }
}
