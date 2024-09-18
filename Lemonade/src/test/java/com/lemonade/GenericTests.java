package com.lemonade;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenericTests {

	@Test
	public void genericTest() {
		System.out.println("Test Started");

// Test case 1. Disable Chrome alert by setting specific Chrome option
		ChromeOptions options = new ChromeOptions();// Add the argument to disable the "Chrome is being controlled by automated test software" alert
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" }); 																																											
		WebDriver driver = new ChromeDriver(options);// Initialize the WebDriver with ChromeOptions
		System.out.println("Chrome alert disabled");

//Test case 2. Open test page
		driver.get("https://www.lemonade.com");
		System.out.println("Page opened");

//Test case 3. Maximize Window Browser
		driver.manage().window().maximize();
		System.out.println("Window maximized");
		
//Test case 4. Validate Title		
		String expectedTitle = "Lemonade: An Insurance Company Built for the 21st Century";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title doesn't match");
		System.out.println("Title validated");

//Test case 5. Verify the navigation bar contains expected links
		try {
			// Verify "Renters" link
			WebElement rentersLink = driver.findElement(By.linkText("Renters"));
			if (rentersLink.isDisplayed()) {
				System.out.println("Navigation link 'Renters' is found and visible.");
			}

			// Verify "Homeowners" link
			WebElement homeownersLink = driver.findElement(By.linkText("Homeowners"));
			if (homeownersLink.isDisplayed()) {
				System.out.println("Navigation link 'Homeowners' is found and visible.");
			}

			// Verify "Car" link
			WebElement carLink = driver.findElement(By.linkText("Car"));
			if (carLink.isDisplayed()) {
				System.out.println("Navigation link 'Car' is found and visible.");
			}

			// Verify "Pet" link
			WebElement petLink = driver.findElement(By.linkText("Pet"));
			if (petLink.isDisplayed()) {
				System.out.println("Navigation link 'Pet' is found and visible.");
			}
			// Verify "Life" link
			WebElement lifeLink = driver.findElement(By.linkText("Life"));
			if (lifeLink.isDisplayed()) {
				System.out.println("Navigation link 'Life' is found and visible.");
			}
			// Verify "Giveback" link
			WebElement givebackLink = driver.findElement(By.linkText("Giveback"));
			if (givebackLink.isDisplayed()) {
				System.out.println("Navigation link 'Giveback' is found and visible.");
			}
	   	} catch (Exception e) {
			System.out.println("An error occurred while verifying the navigation links: " + e.getMessage());
		}

//Test case 6. Click on Renters link, select No account and return to the Homepage
		    driver.findElement(By.linkText("Renters")).click();// Find and click the "Renters" link
	     	System.out.println("Renters link clicked");
	    	driver.findElement(By.xpath("//a[@id='gtm_button_renters_check_prices']")).click();// Find and click "Check our price" button
		    String expectedPage = "https://www.lemonade.com/onboarding/1"; 
		    String actualPage = driver.getCurrentUrl();
		    Assert.assertEquals(actualPage, expectedPage, "Actual page is not the same as expected page");// Validate page
		    System.out.println("Page validated");
            try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
            WebElement radioButton = driver.findElement(By.xpath("//input[@type='radio' and @value='no_account']")); //Find radio button "Nope"
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);// Scroll to the radio button using JavaScript to ensure it's in view
			System.out.println("Scrolled to the radio button");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);// JavaScript used to click the element, bypassing standard WebDriver click
			System.out.println("Radio Button selected");
			WebElement nextButton = driver.findElement(By.xpath("//button[@type='submit']")); //Find  "Next" button
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton); //Click "Next" button
			System.out.println("Next button clicked ");

			WebElement lemonadeButton = driver.findElement(By.xpath("//a[@id='gtm_top_logo']"));//locate "Lemonade" link
			lemonadeButton.click(); //Click to "Lemonade" button to return to Homepage 
			System.out.println("Returned to Homepage ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

//Test case 7. Close Browser	  
			driver.quit();
			System.out.println("Test finished ");
			
		}

	}

}