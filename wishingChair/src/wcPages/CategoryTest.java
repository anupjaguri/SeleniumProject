package wcPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lib.CommonClass;

public class CategoryTest extends WCBasePage 
{
	public CategoryTest() 
	{
		super();
	}
	
	public void fnCategoryCheck(String sURL,String sBakeriID, String sBakeriLabel)
	{
		CommonClass.driver.get("https://www.wishingchair.in/");
		List <WebElement> weCategory = CommonClass.driver.findElements(By.xpath("//a[@data-bakeri-id='EA0011EC0004' and contains(@data-bakeri-label,'Top Navigation | Level 1 | ')]"));
		//a[@data-bakeri-id="EA0011EC0004" and contains(@data-bakeri-label,'Top Navigation | Level 1 | ')]
		for (int i=0;i<weCategory.size()/2;i++)
		{
			System.out.println(weCategory.get(i).getText());
		}
		
	}
}
