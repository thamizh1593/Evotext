package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddClassPage;
import pageObjects.SchoolPage;
import pageObjects.SignInPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_AddClassTestCase extends BaseClass{
	@Test(dataProvider="AddClassData",dataProviderClass= DataProviders.class,groups={"Master","Regression"})
	public void addClassTestCase(String className,String SelectOption, String startDate, String endDate) {
		logger.info("**********************Started TC004_AddClass Test case*********************");
		try {
		SignInPage sp = new SignInPage(driver);
		sp.username(p.getProperty("username"));
		sp.password(p.getProperty("password"));
		sp.clickSignIn();
		
		AddClassPage acp = new AddClassPage(driver);
		
		boolean target = acp.msgisDisplayed();
		Assert.assertEquals(target, true);
		
		acp.clickAddClass();
		acp.addClassRadioButton();
		acp.clickContinueButton();
		acp.classNameText(className);
		acp.clickSelectDropDown();
		System.out.println(SelectOption);
		acp.selectOption(SelectOption);
		acp.startDateInput(startDate);
		acp.endDateInput(endDate);
		acp.clickSaveButton();
		
		SchoolPage sch = new SchoolPage(driver);
		sch.profile();
		sch.clicklogout();
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*******************Exceution Completed**********************");
	}

}
