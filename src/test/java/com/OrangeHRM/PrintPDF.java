package com.OrangeHRM;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintPDF {
WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		//specify the location of the driver
		WebDriverManager.chromedriver().setup();
		
		//instantiate the driver
		driver = new ChromeDriver();
	}
	
	@Test
	public void verifyContentInPDf() {
		//specify the url of the pdf file
		String url ="file:\\C:\\Users\\Sanshray\\Desktop\\Sanshray\\Diwali Assignments\\English Language.pdf";
		//String url ="http://www.pdf995.com/samples/pdf.pdf";
		driver.get(url);
		try {
			String pdfContent = readPdfContent(url);
			System.out.println(pdfContent);
			Assert.assertTrue(pdfContent.contains("Date"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	public static  String readPdfContent(String url) throws IOException {
		
		URL pdfUrl = new URL(url);
		InputStream in = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(in);
		PDDocument doc = PDDocument.load(bf);
		PDFTextStripper pdfStrip = new PDFTextStripper();
		pdfStrip.setStartPage(2);
		pdfStrip.setEndPage(2);
		String content = pdfStrip.getText(doc);
		System.out.println(content);
		doc.close();
	
	return content;
}
	
	public static int getPageCount(PDDocument doc) {
		//get the total number of pages in the pdf document
		int pageCount = doc.getNumberOfPages();
		System.out.println(pageCount);
		return pageCount;
		
	
}


}
