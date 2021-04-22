package com.OrangeHRM;

import static org.junit.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class Test_OrangeHRM_Login {

	@SuppressWarnings("deprecation")
	@Test
	public void Login_Successful() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		Thread.sleep(5000);
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(expectedUrl.equals(actualUrl));
		//driver.close();
		//driver.quit();

	}

}
