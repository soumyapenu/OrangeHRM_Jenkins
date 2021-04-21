package com.OrangeHRM;

import static org.junit.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class OrangeHRM_Login2_XpathAndCss {

	@SuppressWarnings("deprecation")
	@Test
	public void Login_Successful() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://netbanking.hdfcbank.com/netbanking/?_ga=2.259587978.1417261832.1618294774-1710695636.1603001790");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("1000");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		Thread.sleep(5000);
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(expectedUrl.equals(actualUrl));
		//driver.close();
		driver.quit();

	}

}
