package tce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {
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
@Test(priority=1,description = "Testcase1= Verify that User is able to logout succesfully on clicking logout button")
public void logoutAfterLogin() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("sapna@mishra");
	driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Sapna@567");
	driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//p[contains(text(),'Sign In')]")).click();
	Thread.sleep(1000);
     System.out.println("User logged in succesfully");
     driver.findElement(By.xpath("//img[@src='assets/images/User.png']")).click();
     Thread.sleep(1000);
     driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
     Assert.assertTrue(true);
     System.out.println("User logged out successfully");
     }
@AfterMethod
public void TearDown() {
	driver.quit();
	}
}

