package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SchoolPage extends BasePage {
	
	public SchoolPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='admin-dashboard-welcome theme-header-title']")
	WebElement Welcommsg;
	
	@FindBy(xpath="//a[@id='profile-menu']")
	WebElement profilemenu;
	
	@FindBy(xpath="//span[text()='Logout']")
	WebElement btn_logout;
	
	public Boolean welcomemsgdisplayed() {
		try {
		Boolean status = Welcommsg.isDisplayed();
		return status;
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	public void profile() {
		Actions act = new Actions(driver);
		act.moveToElement(profilemenu).build().perform();
	}
	
	public void clicklogout() {
		btn_logout.click();
	}
	

}
