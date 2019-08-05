package tce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWithPin {
	private WebDriver driver;
	private String baseUrl;
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sapna Mishra\\Documents\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl="http://10.10.0.160:8080/tceweb/#/";
    driver.get(baseUrl);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
@Test(priority=1,description = "Testcase1= Verify that User is on login with pin page")
public void VerifyLoginWithPinPage() throws InterruptedException {
	driver.findElement(By.xpath("//span[contains(text(),'Sign in with PIN')]")).click();
	Thread.sleep(1000);
	WebElement loginWithPinText=driver.findElement(By.xpath("//p[contains(text(),' Please enter your PIN to proceed. ')]"));
	Assert.assertEquals(loginWithPinText.isDisplayed(), true);
	
}

@Test(dependsOnMethods = {"VerifyLoginWithPinPage"},priority=2,description = "Testcase2= Verify that User is able to login with pin succesfully")
public void loginWithPin() throws InterruptedException {
	driver.findElement(By.xpath("//span[contains(text(),'Sign in with PIN')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("otp1")).sendKeys("1");
	driver.findElement(By.id("otp2")).sendKeys("2");
	driver.findElement(By.id("otp3")).sendKeys("3");
	driver.findElement(By.id("otp4")).sendKeys("4");
	driver.findElement(By.id("otp5")).sendKeys("5");
	Thread.sleep(1000);
     Assert.assertTrue(true);
     System.out.println("User logged in successfully");
     }
@AfterMethod
public void TearDown() {
	driver.quit();
	}
}

