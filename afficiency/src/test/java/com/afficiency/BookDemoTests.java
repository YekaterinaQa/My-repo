package com.afficiency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookDemoTests {
	@Test
	public void loginTest() {
		
// Create driver
		WebDriver driver = new ChromeDriver();
		
// open test page
		String url = "https://www.afficiency.com/";
		driver.get(url);
		driver.manage().window().maximize();
	
		
		System.out.println("Page is opened");
		
// Click on Book a Demo button
		WebElement demoButton = driver.findElement(By.xpath("//a[@class='globalDesktop__Links' and @href='https://www.afficiency.com/book-a-demo?hsLang=en']"));
		demoButton.click();
// enter First Name
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Test");
// enter Last Name
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("TestTest");
// enter Invalid email
		WebElement invalidEmail = driver.findElement(By.xpath("//input[@name='email']"));
		invalidEmail.sendKeys("Invalid Email");
// enter Phone Number
	    WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
		phoneNumber.sendKeys("5555555555");		
// enter Company Name
	    WebElement companyName = driver.findElement(By.xpath("//input[@name='company']"));
		companyName.sendKeys("Afficiency");		
		
// click Submit button
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		submitButton.click();
			
//verifications
		String expectedUrl = "https://www.afficiency.com/book-a-demo";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
		

// Error message "Email must be formatted correctly"
		WebElement errorMessage = driver.findElement(By.xpath("//label[contains(text(),'Email must be formatted correctly.')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Email must be formatted correctly is not visible");	
         
		
		driver.close();
		System.out.println("Test is finished");

		}
	}

