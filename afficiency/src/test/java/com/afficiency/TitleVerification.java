package com.afficiency;



	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	public class TitleVerification {

	public class PageTitleTest {
	    WebDriver driver;

	    @BeforeTest
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.afficiency.com/");
	    }

	    @Test
//Validate title
	    public void validateTitle() {
	        String expectedTitle = "Afficiency";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Title doesn't match");
	    }

	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	
	
}
