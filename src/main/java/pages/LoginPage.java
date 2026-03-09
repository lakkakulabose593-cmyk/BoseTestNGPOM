package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement UserNameTextBox;
	
	@FindBy(id="Password")
	WebElement PasswordTextBox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/section/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement LoginButton;
	
//	private By UserNameTextBox = By.id("Email");
//	private By PasswordTextBox = By.name("Password");
//	private By LoginButton = By.xpath("//*[@class=\'button-1 login-button']");

	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		UserNameTextBox.clear();
		UserNameTextBox.sendKeys(username);
//		driver.findElement(UserNameTextBox).clear();
//		driver.findElement(UserNameTextBox).sendKeys(username);
		
	}
	public void enterPassword(String password) {
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(password);
//		driver.findElement(PasswordTextBox).clear();
//		driver.findElement(PasswordTextBox).sendKeys(password);
		
	}
	public void clickLogin() {
		LoginButton.click();
//		driver.findElement(LoginButton).click();
	}
}
