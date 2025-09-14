package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SchoolPage;
import pageObjects.SignInPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid --> login success --> Test Passed --> logout
Data is valid --> login failed --> Test Fail
Data is invalid --> login success --> Test Fail --> logout 
Data is valid --> login fail --> Test Passed 

 */

public class TC003_SignInUsingDDT extends BaseClass{
	@Test(dataProvider="logindata",dataProviderClass=DataProviders.class)
	public void signInPage(String email, String pwd, String res) {
		
		logger.info("***************TC003_SignInUsingDDT Started********************");
		try {
			
		
		SignInPage sp = new SignInPage(driver);
		sp.username(email);
		sp.password(pwd);
		sp.clickSignIn();
		
		SchoolPage sch = new SchoolPage(driver);
		boolean target = sch.welcomemsgdisplayed();
		
		if(res.equalsIgnoreCase("Valid")) {
			if(target==true) {
				sch.profile();
				sch.clicklogout();	
				Assert.assertTrue(true);
							
			} else {
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("Invalid")) {
			if(target==true) {
				
				sch.profile();
				sch.clicklogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*********************Exceution Completed for the TC003_SignInUsingDDT test case****************");
		
	}

}
