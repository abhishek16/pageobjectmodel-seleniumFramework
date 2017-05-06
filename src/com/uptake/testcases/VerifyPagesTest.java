package com.uptake.testcases;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationFramework.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unused")

public class VerifyPagesTest {
	
	public String baseUrl = "https://uptake.com/";
	
	WebDriver driver;	
	
	private HomePage homepage; 


@BeforeTest
	
	public void setBaseURL() {
	
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		
		homepage = new HomePage(driver);
	}
	
	
@Test(priority = 0)

	public void verifyHomePageTitle() {		
		
		String expectedTitle = "Analytics for the industrial internet";
		
		String actualTitle = homepage.getTitle();
		
		Assert.assertEquals(expectedTitle,actualTitle);
		
		homepage.gotoApproachTab();
}
	

@Test(priority = 1)

	public void navigatetoApproachTab() throws InterruptedException{

		homepage.gotoApproachTab();
		
		Thread.sleep(1000);
		
		String expected = "Approach";
		
		String actual = homepage.getTitle();
		
		Assert.assertEquals(actual, expected);
	}
	
	
@Test(priority = 2)

	public void gotoOpenPositionsDiv() throws InterruptedException{
		
		String expected = "Approach";
		
		String actual = homepage.getTitle();
		
		Assert.assertEquals(actual, expected);
				
	}
	
	
@Test(priority = 3)
	
	public void searchInJobListings() throws InterruptedException{
			
		Thread.sleep(1000);
		
		homepage.clickOpenJobPositions();
		
		//driver.getWindowHandle();
		
		String expected = "Job Application for QA Engineer at Uptake";
		
		String actual = homepage.getTitle();
		
		Assert.assertEquals(actual, expected);
						
	}
	
	
@AfterTest

	public void endSession(){
    
		driver.quit();
     }
	
	
}