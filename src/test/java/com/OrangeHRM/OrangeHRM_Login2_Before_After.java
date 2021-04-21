package com.OrangeHRM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class OrangeHRM_Login2_Before_After {
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
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(expectedUrl.equals(actualUrl));		

	}
	@Before
	public void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
