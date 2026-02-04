package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By UserNameTextBox = By.id("Email");
	private By PasswordTextBox = By.name("Password");
	private By LoginButton = By.xpath("//*[@class=\'button-1 login-button']");
	
	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUserName(String username) {
		driver.findElement(UserNameTextBox).clear();
		driver.findElement(UserNameTextBox).sendKeys(username);
		
	}
	public void enterPassword(String password) {
		driver.findElement(PasswordTextBox).clear();
		driver.findElement(PasswordTextBox).sendKeys(password);
		
	}
	public void clickLogin() {
		driver.findElement(LoginButton).click();
	}
}
