package com.revision;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alert {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sapna Mishra\\Documents\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    String baseUrl="http://demo.guru99.com/test/delete_customer.php";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	     }
	@Test
	public void alertHandlling1() {
		driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();	
		String alertMsg=driver.switchTo().alert().getText();// alert message
		System.out.println(alertMsg);
		driver.switchTo().alert().dismiss();
		
		
	}
	@Test
	public void alertHandlling2() {
		driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();	
		driver.switchTo().alert().accept();
		}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
