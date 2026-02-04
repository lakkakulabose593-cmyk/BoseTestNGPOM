package base;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");//chrome version
		co.addArguments("--disable-blink-features=AutomationControlled");//chaptcha google image 
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			//driver.quit();
		}
	}
	
}
