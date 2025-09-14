package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
	
	public SignInPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement btn_SignIn;
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement register;
	
	public void clickRegister() {
		register.click();
	}
	
	public void username(String username)
	{
		txt_email.clear();
		txt_email.sendKeys(username);
	}
	
	public void password(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}
	
	public void clickSignIn() {
		btn_SignIn.click();
	}
	
	
	

}
