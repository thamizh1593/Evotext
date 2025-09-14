package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddClassPage;
import pageObjects.SchoolPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC002_SignInTestWithValid extends BaseClass {
	
	@Test(groups={"Smoke","Regression"})
	public void validateSignIn() {
		logger.info("******Started TC002_SignInTestWithValid test case*********");
		try {
		SignInPage sp = new SignInPage(driver);
		sp.username(p.getProperty("username"));
		sp.password(p.getProperty("password"));
		sp.clickSignIn();
		
		SchoolPage sh = new SchoolPage(driver);
		System.out.println(sh.welcomemsgdisplayed());
		AddClassPage acp = new AddClassPage(driver);
		boolean target = acp.msgisDisplayed();
		Assert.assertEquals(target, true);
		sh.profile();
		sh.clicklogout();
		}
		catch(Exception e) {
			logger.info("Test case Failed........");
			logger.debug("Debug logs............");
			Assert.fail();
		}
		
		logger.info("************* Test case execution finished**************");
	}

}
