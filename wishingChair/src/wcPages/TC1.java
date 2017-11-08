package wcPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lib.CommonClass;
import lib.CommonExcel;

public class TC1 extends WCBasePage 
{
	public TC1() 
	{
		super();
	}
	
	public void testCase1()
	{
	System.out.println("Test Start");
	
	CommonClass.driver.get("https://www.wishingchair.in/kitchen-dining");
	List <WebElement> bakeri = CommonClass.driver.findElements((By.xpath("//*[@data-bakeri-id]")));
	System.out.println("List 404 start");
	List <WebElement> notFound = CommonClass.driver.findElements((By.xpath("//span[contains(text(),'404')]")));
	if(notFound.size()>0)
	{
		System.out.println("PAGE NOT FOUND ERROR");
	}
	System.out.println("List 404 ends");
	System.out.println(bakeri.size());
	for(int i=1;i<(bakeri.size()-1);i++)
	{
		try 
		{
			String bakeriID = bakeri.get(i).getAttribute("data-bakeri-id");
			String bakeriLabel = bakeri.get(i).getAttribute("data-bakeri-label");
			CommonExcel ce = new CommonExcel();
			ce.setExcelCellValue(1, i, bakeriID);
			ce.setExcelCellValue(2, i, bakeriLabel);
			System.out.println("Bakeri ID: "+bakeriID);
		}
	catch (Exception e) {e.printStackTrace();}
}
System.out.println("Test End");

}
}