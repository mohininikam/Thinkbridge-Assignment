package main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import lib.BaseClass;

public class RegisterPage extends BaseClass {
	
	@Test 
	public void verifySignUp() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='text-custom ng-binding']")).click();
		Thread.sleep(2000);
		
		// Checking if "English" and "Dutch" present in the dropdown
		driver.findElement(By.xpath("//div[@id='language']")).click();
		List<WebElement> dropdownList = driver.findElements(By.xpath("(//a[@class='ui-select-choices-row-inner'])"));
		int dropdownValue = dropdownList.size();
		System.out.println("Dropdown List Size - " + dropdownValue);
		ArrayList<String> arr = new ArrayList<String>();
		for(int i=1; i<=dropdownValue; i++)
		{
			String value = driver.findElement(By.xpath("(//a[@class='ui-select-choices-row-inner'])["+i+"]")).getText();	
			arr.add(value);
			System.out.println(value);
		}
		if(arr.contains("English") && arr.contains("Dutch"))
		{
				System.out.println("Dropdown Contains English and Dutch Both");
		}
		else
			if(arr.contains("English"))
			{
				System.out.println("Dropdown Contains Only English");
			}
			else
				if(arr.contains("Dutch"))
				{
					System.out.println("Dropdown Contains Only Dutch");
				}
				else
				{
					System.out.println("Dropdown does not contain english nor dutch");
				}

		
		// Submitting Data in the SignUp Form
		driver.findElement(By.id("name")).sendKeys("Mohini"); 		// Enter Name
		driver.findElement(By.id("orgName")).sendKeys("Fermion");		// Enter Organization Name
		driver.findElement(By.id("singUpEmail")).sendKeys("mohini@gmail.com");		// Enter Email ID
		driver.findElement(By.cssSelector("span.black-color.ng-binding")).click();		// Checking checkbox for terms and copnditions
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/section/div[1]/form/fieldset/div[5]/button"))
				.click();		// Clicking SignUp
		
		
		// Validating Success Message
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/section/div[1]/form/div/span"))
				.getText();
		Assert.assertEquals("A welcome email has been sent. Please check your email.", text);

	}
	
}
