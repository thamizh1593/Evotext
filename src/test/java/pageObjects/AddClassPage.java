package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddClassPage extends BasePage {

	public AddClassPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[@class='ui header welcome-header theme-header-title']")
	WebElement msg_Welcome;

	@FindBy(xpath = "//button[text()='+ Add / Join Class']")
	WebElement btn_addclass;

	@FindBy(xpath = "//label[text()='+ Add New Class']")
	WebElement radiobtn_addclass;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement btn_continue;

	@FindBy(xpath = "//input[@name='classroomName']")
	WebElement txt_className;

	@FindBy(xpath = "//div[@class='ui selection dropdown']//div[contains(text(),'Select')]")
	WebElement dropdown_select;

	@FindBy(xpath = "//div[@class='visible menu transition']/descendant::span")
	List<WebElement> options;

	@FindBy(xpath = "//input[@name='startDate']")
	WebElement txt_startDate;

	@FindBy(xpath = "//input[@name='endDate']")
	WebElement txt_endDate;

	@FindBy(xpath = "//button[text()='Save']")
	WebElement btn_save;

	public boolean msgisDisplayed() {
		try {
			boolean status = msg_Welcome.isDisplayed();
			return status;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickAddClass() {
		btn_addclass.click();
	}
	
	public void addClassRadioButton() {
		radiobtn_addclass.click();
	}
	
	public void clickContinueButton() {
		btn_continue.click();
	}
	
	public void classNameText(String className) {
		txt_className.clear();
		txt_className.sendKeys(className);
	}
	
	public void clickSelectDropDown() {
		dropdown_select.click();
	}
	
	public void selectOption(String dropdownOption) {
		for(WebElement we:options) {
			String selectOption = we.getText();
			if(selectOption.equals(dropdownOption)) {
				we.click();
			}
		}
	}
	
	public void startDateInput(String startDate) {
		txt_startDate.clear();
		txt_startDate.sendKeys(startDate);
	}
	
	public void endDateInput(String endDate) {
		txt_endDate.clear();
		txt_endDate.sendKeys(endDate);
	}
	
	public void clickSaveButton() {
		btn_save.click();
	}

}
