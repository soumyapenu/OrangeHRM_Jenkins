package com.OrangeHRM;





import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Login_Verification2DataProvider extends TestData{
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "Login")
	public void Login(String uname,String upass) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		Thread.sleep(5000);
		driver.findElement(By.name("txtPassword")).sendKeys(upass);
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("welcome")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.linkText("Logout")).click();
		//driver.findElement(By.linkText("Dashboard")).isDisplayed();
//		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
//		String actualUrl = driver.getCurrentUrl();
//		String expectedTitle = "OrangeHRM";
//	    String actualTitle = driver.getTitle();
//		Assert.assertEquals(expectedUrl, actualUrl);
//		Assert.assertEquals(expectedTitle, actualTitle);

	}
	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
