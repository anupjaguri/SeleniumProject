package wcPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import lib.BaseClass;
import lib.CommonClass;

public class WCBasePage extends BaseClass {
	public WCBasePage()
	{
		super();
		PageFactory.initElements(CommonClass.driver, this);
	}
	public static int iProductCount=0;
	
	public void fnScrollTo(int  startPoint,int endPoint) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor) CommonClass.driver;
		jse.executeScript("window.scrollTo("+startPoint+", "+endPoint+")");
		Thread.sleep(3000);
	}
	
	public void fnScrollToBottom() throws InterruptedException
	{
		int iteration =500;
		JavascriptExecutor jse = (JavascriptExecutor) CommonClass.driver;
		for(int i=0;iteration>i;i++)
		{
			//product image bakeriID
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			List <WebElement> productImg = CommonClass.driver.findElements(By.xpath("//*[contains(@data-bakeri-id,'EA0042EC0004')]"));
			int imgNewCount = productImg.size();
			if(imgNewCount==iProductCount){
				break;
			}
			iProductCount = productImg.size();
			Thread.sleep(3000);
		}
	}
}
