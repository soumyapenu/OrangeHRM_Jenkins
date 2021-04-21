package com.OrangeHRM;

import static org.junit.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class Hdfc_Netbanking {

	@SuppressWarnings("deprecation")
	@Test
	public void Login_Successful() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://netbanking.hdfcbank.com/netbanking");
		Thread.sleep(5000);
		driver.switchTo().frame("login_page");
		//driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='/gif/continue_new1.gif?v=1']")).click();
		String text = driver.switchTo().alert().getText();
		String expText = "Customer ID  cannot be left blank.";
		Thread.sleep(3000);
		Assert.assertEquals(expText,text);
		driver.switchTo().alert().accept();
		System.out.println(text);
		driver.switchTo().defaultContent();
//		driver.switchTo().frame(1);
//		driver.findElement(By.linkText("Terms and Conditions")).click();
	    Thread.sleep(5000);
		driver.quit();		

	}

}
