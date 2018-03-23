package TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePage.Base;
import Page.LoginPage;

public class Logintest {
	
	@Test(dataProvider="tet")
	public void testLogin(String test, String tests){
		Base bp=new Base(Base.pr.getProperty("Browser"),Base.pr.getProperty("AppURL"));
		LoginPage.login();
	}
	
	@DataProvider
	public Object[][] tet(){
		Object[][] ob=new Object[2][2];
		ob[0][0]='e';
		return ob;
	
	}

}
