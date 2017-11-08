package wcPages;

import lib.CommonClass;

public class TC2 extends WCBasePage {
	
	public TC2()
	{
		super();
	}
	public void testCase2() throws InterruptedException
	{
//		CommonClass.driver.get("https://www.wishingchair.in/lighting");
		CommonClass.driver.get("https://www.wishingchair.in/decor/room-decor/wall-decor");
//		fnScrollToBottom();
		fnScrollTo(0, 500);
		
	}
}
