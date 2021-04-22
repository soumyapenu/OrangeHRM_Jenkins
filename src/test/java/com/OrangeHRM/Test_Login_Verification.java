package com.OrangeHRM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Test;

public class Test_Login_Verification {
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test
	public void Login_Successful() throws InterruptedException {
		//Thread.sleep(5000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//Thread.sleep(5000);
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		//Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		//Thread.sleep(5000);
		//driver.findElement(By.linkText("Dashboard")).isDisplayed();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		String expectedTitle = "OrangeHRM";
	    String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedUrl, actualUrl);
		Assert.assertEquals(expectedTitle, actualTitle);

	}
	@Before
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		//Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
