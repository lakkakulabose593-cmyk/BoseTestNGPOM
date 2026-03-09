package tests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Log;
import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest{
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		for(int i=1; i<rowCount; i++) {
			data[i-1][0]=ExcelUtils.getCellData(i, 0);//UserName
			data[i-1][1]=ExcelUtils.getCellData(i, 1);//password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
//	@DataProvider(name="TestData2")
//	public Object[][] getData(){
//		return new Object[][] {
//			{"User1","Pass1"},
//			{"User2","Pass2"},
//			{"User3","Pass3"}
//		};
//	}we can use this type of object instead of Excel
	
	//@Test(dataProvider="LoginData")//here we have to give the name of the data provider ex:-TestData, TestData2....
	@Test
	@Parameters({"username","password"})
	public void testValidLogin(String username, String password) {
		Log.info("Starting Login Test ...");
		test = ExtentReportManager.createTest("Login Test -"+username);
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		Log.info("Adding Credentials");
		test.info("Adding Credentials");
//		loginPage.enterUserName("admin@yourstore.com");
//		loginPage.enterPassword("admin");
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		test.info("Clicking on Login Button");
		loginPage.clickLogin();
		Log.info("Clicking on Login Button");
		System.out.println("Title of the page is:"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Dashboard / nopCommerce administration");
	}
	/*@Test
	public void falseTestValidLogin() {
		//Log.info("Starting Login Test ...");
		test = ExtentReportManager.createTest("Login Test for false login");
		test.info("Navigating to URL with incorrect title");
		LoginPage loginPage = new LoginPage(driver);
		//Log.info("Adding Credentials");
		test.info("Adding Credentials");
		loginPage.enterUserName("admin@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Clicking on Login Button");
		loginPage.clickLogin();
		System.out.println("Title of the page is:"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Just a moment...123");
	}*/

}
