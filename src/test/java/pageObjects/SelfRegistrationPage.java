package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelfRegistrationPage extends BasePage {
	
	public SelfRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='ui input']/child::input[@name='accessCode']")
	WebElement txt_AccessCode;
	
	@FindBy(xpath="//div[@class='ui input']/child::input[@name='firstName']")
	WebElement txt_FirstName;
	
	@FindBy(xpath = "//div[@class='ui input']/child::input[@name='lastName']")
	WebElement txt_LastName;
	
	@FindBy(xpath="//div[@class='ui input']/child::input[@name='email']")
	WebElement txt_Username;
	
	@FindBy(xpath= "//div[@class='ui right labeled input']/child::input[@name='password']")
	WebElement txt_Password;
	
	@FindBy(xpath = "//div[@class='ui right labeled input']/child::button[text()='Show Password']")
	WebElement btn_SowPassword;
	
	@FindBy(xpath="//div[@class='ui right labeled input']/child::button[text()='Show Password']")
	WebElement btn_confirmshowPassword;
	
	@FindBy(xpath="//div[@class='ui right labeled input']/child::input[@name='confirmPassword']")
	WebElement txt_confirmPassword;
	
	@FindBy(xpath="//div[@class='ui buttons']/child::button[text()='Submit']")
	WebElement btn_Submit;
	
	@FindBy(xpath="//p[text()='Registration complete, check your email to verify your account.']")
	WebElement msg_successmessage;
	
	public void setAccessCode(String code) {
		txt_AccessCode.sendKeys(code);
	}
	
	public void setFirstName(String fname) {
		txt_FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txt_LastName.sendKeys(lname);
	}
	
	public void setUserName(String uname) {
		txt_Username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}
	
	public void clickShowPassword() {
		btn_SowPassword.click();
	}
	
	public void setConfirmPassword(String cpwd) {
		txt_confirmPassword.sendKeys(cpwd);
	}
	
	public void clickConfirmShowPassword() {
		btn_confirmshowPassword.click();
	}
	
	public void clickSubmit() {
		btn_Submit.click();
	}
	
	public String successMessage() {
		try {
			return msg_successmessage.getText();
		} catch(Exception e){
			return e.getMessage();
		}
	}

}
