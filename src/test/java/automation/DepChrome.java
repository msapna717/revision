package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class DepChrome {
    @Test
    public void testBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sapna Mishra\\Documents\\chromedriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    }
}