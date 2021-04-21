package com.OrangeHRM;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPDF {
WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		//A HashMap basically designates unique keys to corresponding values that can be retrieved at any given point.
		//The values can be stored in a map by forming a key-value pair. The value can be retrieved using the key by passing it to the correct method.
		//Important Hashmap Methods
				//.get(Object KEY) – This will return the value associated with a specified key in this Java hashmap.
				//.put(Object KEY, String VALUE) – This method stores the specified value and associates it with the specified key in this map.
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		prefs.put("pdfjs.disabled", true);
		prefs.put("download.default_directory","D:\\DownloadPDFFile");
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	}
	
	
	@Test
	public void downloadPdf() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.learningcontainer.com/sample-pdf-files-for-testing");
	Thread.sleep(2000);
	//String pdfimage=driver.findElement(By.linkText("Sample pdf with images")).getText();
	//locator to click the pdf download link
	driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[@id='primary']/main[@id='main']/article[@id='post-809']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
	Thread.sleep(5000);
    File getFirstFile = getLatestFilefromDir("D:\\DownloadPDFFile");
    String fileName1 = getFirstFile.getName();
    System.out.println(fileName1);
	//String pdfimage=driver.findElement(By.linkText("Sample pdf with images")).getText();
	WebElement img = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/article/div/div[2]/p[3]/img"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Thread.sleep(3000);
	js.executeScript("arguments[0].click()",img);
	Thread.sleep(50000);
    File getSecondFile = getLatestFilefromDir("D:\\DownloadPDFFile");
    String fileName2 = getSecondFile.getName();
    System.out.println(fileName2);
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();

	}
	
	/* Get the latest file from a specific directory*/
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}



}
