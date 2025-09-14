package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.SelfRegistrationPage;
import pageObjects.SignInPage;
import testBase.BaseClass;

public class TC001_SelfRegistration extends BaseClass {
	
	@Test
	public void selfRegistrationTest() {
		
		logger.info("***** Started Selfregistration Class ******");
		
		try {		
		SignInPage sp = new SignInPage(driver);
		sp.clickRegister();
		logger.info("Clicked on Register");
		SelfRegistrationPage srp = new SelfRegistrationPage(driver);
		logger.info("Provide user Details");
		srp.setAccessCode("A4SM85JAZ2PZ");
		srp.setFirstName(randomalphabet().toUpperCase());
		srp.setLastName(randomalphabet().toUpperCase());
		srp.setUserName(randomalphabet()+"@yopmail.com");
		String password = randomAlphanumeric();
		System.out.println(password);
		srp.setPassword(password);
		srp.clickShowPassword();
		srp.setConfirmPassword(password);
		srp.clickConfirmShowPassword();
		srp.clickSubmit();
		logger.info("Validate confirmation message");
		
		if(srp.successMessage().equals("Registration complete, check your email to verify your accounts.")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test case Failed");
			logger.debug("Debug Logs....");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(srp.successMessage(), "Registration complete, check your email to verify your account.");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("Self Registration test case is finished");
		
	}
	
	
	

}
