package com.Test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.Base.BaseClass;
import com.Pages.LoginPage;
import com.Utility.PropertiesUtils;

public class LoginTest extends BaseClass {
	
	public LoginPage lp=null;
	@BeforeSuite
	public void setup() throws Exception
	{
		initialization(); 
		reportinit();
		lp=new LoginPage(driver);
	}
	@Test(priority = 1)
	public void logintest() throws Exception
	{
		String uname=PropertiesUtils.readProperties("username");
		String pass=PropertiesUtils.readProperties("password");
		lp.loginToApplication(uname,pass);
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test(priority = 2)
	public void failTest()
	{
		Assert.assertEquals(driver.getTitle(), "test");
	}
	@Test(priority = 3)
	public void skipTest()
	{
		throw new SkipException("Skipping a test case");
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
