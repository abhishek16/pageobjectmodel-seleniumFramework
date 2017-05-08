package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	String baseUrl = "https://uptake.com/";
	
		public String getTitle(){
		
		String actualTitle = driver.getTitle();
		
		return actualTitle;
	}
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
	
		this.driver=driver;
	}
	

/*** Open the parent home page method ***/
	
	public void gotoHomePage(){
		
		driver.get(baseUrl);
	}
	
	
/*** Click on Approach tab on the home page ***/
	
	public void gotoApproachTab() {
		
		driver.findElement(By.linkText("APPROACH")).click();
	}


/*** Scroll down twice to 'Open Positions' section and click on the button ***/
	
	public void gotoOpenPositionsDiv() throws InterruptedException{
		
		driver.findElement(By.linkText("APPROACH")).click();
		
		Thread.sleep(1000);
		
		WebElement searchBtn = driver.findElement(By.tagName("button")); 
		
		searchBtn.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(1000);
		
		searchBtn.sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"approach\"]/div[3]/div/div/div/button")).click();
		
		Thread.sleep(2000);
		
	}

	
/*** Open Jobs section page and search for QA Engineer position & click it***/
	
	public void clickOpenJobPositions() throws InterruptedException {
		
		gotoOpenPositionsDiv();
		
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(windowHandles.get(1));
		
		Thread.sleep(2000);
			
			boolean exists = driver.findElements( By.partialLinkText("QA")).size() != 0;
		
			if (exists) System.out.println("QA position(s) found");	
			
			driver.findElement(By.linkText("QA Engineer")).click();

			Thread.sleep(2000);
		}

}
