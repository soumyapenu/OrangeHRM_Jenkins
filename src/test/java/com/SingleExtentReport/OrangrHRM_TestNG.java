package com.SingleExtentReport;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class OrangrHRM_TestNG {
	WebDriver driver;
  @Test(priority = 1)
  public void Login_Successful() throws InterruptedException {
		//Thread.sleep(5000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		//Thread.sleep(5000);
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		//Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).click();
		//Thread.sleep(5000);
		String expectedUrl = "https://opensource-demo.orangehrmlivelo.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(expectedUrl.equals(actualUrl));	
	}
  @Test (priority = 2)
  public void logout() throws InterruptedException {
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Logout")).click();
  }
  @BeforeTest
  public void launchBrowser() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		//Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

  @AfterTest
  public void closeBrowser() {
		driver.quit();
	}

}
