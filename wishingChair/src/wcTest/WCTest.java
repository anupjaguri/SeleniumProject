package wcTest;

import org.testng.annotations.Test;

import lib.BakeriData;
import lib.BaseClass;
import lib.CommonExcel;
import wcPages.CategoryTest;
import wcPages.TC1;
import wcPages.TC2;

public class WCTest extends BaseClass {
	/* First Test Case to get BakeriID  and corresponding BakeriLABEL on a product page.*/
	
	@Test(dataProvider="getData", dataProviderClass=CommonExcel.class)
	public void testCase1(final int iTestCaseID, BakeriData testData) throws Exception 
	{
		System.out.println("Test Data"+testData);
		TC1 tc1 = new TC1();
		tc1.testCase1();
	}
	
//	@Test(priority=2)
	public void testCase2() throws Exception 
	{
		TC2 tc2 = new TC2();
		tc2.testCase2();
	}
	
//	@Test(priority=3)
	public void testCase3() throws Exception 
	{
		CategoryTest ct = new CategoryTest();
		ct.fnCategoryCheck("", "", "");
	}
}
