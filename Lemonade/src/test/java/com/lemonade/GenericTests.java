package com.lemonade;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenericTests {
	
	@Test
	public void genericTest() {
	System.out.println("Test Started");	
			
//Test case 1. Disable Chrome alert by setting specific Chrome option	
        ChromeOptions options = new ChromeOptions();// Add the argument to disable the "Chrome is being controlled by automated test software" alert
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Initialize the WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds explicit wait
       // Explicit wait of 10 seconds for elements to be interactable or visible
     

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
	  Assert.assertEquals(actualTitle,expectedTitle, "Title doesn't match");
	  System.out.println("Title validated");
// Test case 5: Find and click links with explicit wait
      String[] links = {"Renters", "Homeowners", "Car", "Pet", "Life", "Giveback"};
      for (String link : links) {
          WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));
          element.click();
          System.out.println("Link " + link + " clicked");
          driver.navigate().back();
          System.out.println("Back to homepage");
      }

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Renters")));
    
//Test case 6. Verify the navigation bar contains expected links
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
	 
	  
	  
	  
//Test case 7. Close Browser	  
	    driver.quit();
	    System.out.println("Test finished");	
	}

}
