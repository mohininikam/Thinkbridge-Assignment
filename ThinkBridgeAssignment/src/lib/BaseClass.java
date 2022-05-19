package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public ChromeDriver driver;
	
	@BeforeMethod
	public void beforeTestMethod() throws InterruptedException {
			 
		System.setProperty("webdriver.chrome.driver","/Applications/selenium/chromedriver101"); 
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       
        driver.get("https://app.jabatalks.com/#/SignIn/");
        Thread.sleep(2000);
        
	}
		 
	@AfterMethod
	public void afterTestMethod() {
//		driver.quit();
				 
	}

}
