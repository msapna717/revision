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

public class LoginWithCredentialsTest {
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
//if main testcase failes then depending testcases will not be executed and skipped by using depandsOnMethod
@Test(priority=0,description = "Testcase1= Verify that User is on login with userId and password page")
public void VerifyLoginWithCredentialsPage() throws InterruptedException {
	WebElement loginWithPinText=driver.findElement(By.xpath("//p[contains(text(),'Please sign in using your account details ')]"));
Thread.sleep(1000);
Assert.assertEquals(loginWithPinText.isDisplayed(), true);
	
}
@Test(dependsOnMethods = {"VerifyLoginWithCredentialsPage"},priority=1,description = "Testcase1= Verify that error message is displayed on entering invalid data")
public void loginInvalidCredentials() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("sapna@mishra");
	driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Sapna@56");
	driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//p[contains(text(),'Sign In')]")).click();
     Thread.sleep(1000);
     String errormsg=driver.findElement(By.xpath("//p[@class='bad_credential_p']")).getText();
     String expectedMsg="Invalid userid or password. Please try again.";
     
     if(errormsg.contains(expectedMsg)) {
     //If the message is displayed
      Assert.assertTrue(true);
      System.out.println("PASS");
      System.out.println("error message:"+errormsg);
     }
 else{
     	  System.out.println("FAIL");
     	  System.out.println("Error message is not displayed or not matching");
     }
}
@Test(dependsOnMethods = {"VerifyLoginWithCredentialsPage"},priority=2,description = "Testcase2= Verify that User is able to log in succesfully on entering valid data")
public void loginValidCredentials() throws InterruptedException {
	driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("sapna@mishra");
	driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Sapna@567");
	driver.findElement(By.xpath("//span[@class='mat-button-wrapper']//p[contains(text(),'Sign In')]")).click();
	 Thread.sleep(10000);
	 Assert.assertTrue(true);
     System.out.println("User logged in succesfully");
     }
@AfterMethod
public void TearDown() {
	driver.quit();
	}
}

	



