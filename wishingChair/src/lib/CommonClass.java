package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CommonClass extends CommonExcel{
	//Globals variables defined here --- START ---
	// Wait for long duration
	public static int iWaitForElement;

	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public static String BROWSER;
	public static String CHROME_DRIVER_PATH;
	public static String IE_DRIVER_PATH;
	public static String OUTPUT_PATH;
	public static String IMAGES_PATH;
	public static String GECKO_DRIVER_PATH;
	public static String DATA_PATH;
	public static String SHEET;
	public static int TESTCASES;

	@BeforeSuite
	@Parameters({"CHROME_DRIVER_PATH","IE_DRIVER_PATH","GECKO_DRIVER_PATH","OUTPUT_PATH","IMAGES_PATH","iWaitForElement"})
	public void setup(String CHROME_DRIVER_PATH, String IE_DRIVER_PATH,String GECKO_DRIVER_PATH, String OUTPUT_PATH, String IMAGES_PATH, int iWaitForElement){

		//Globals variables populated here --- START ---
		CommonClass.CHROME_DRIVER_PATH	= CHROME_DRIVER_PATH;
		CommonClass.IE_DRIVER_PATH 		= IE_DRIVER_PATH;
		CommonClass.OUTPUT_PATH 		= OUTPUT_PATH;
		CommonClass.IMAGES_PATH 		= IMAGES_PATH;
		CommonClass.GECKO_DRIVER_PATH 	= GECKO_DRIVER_PATH;
		CommonClass.iWaitForElement 	= iWaitForElement;
		//Globals variables populated here ---  END  ---

		//Globals variables dumped here --- START ---
		System.out.println("CHROME_DRIVER_PATH: " + CHROME_DRIVER_PATH);
		System.out.println("IE_DRIVER_PATH: " + IE_DRIVER_PATH);
		System.out.println("Output Folder: " + OUTPUT_PATH);
		System.out.println("Images Folder: " + IMAGES_PATH);
		//Globals variables dumped here ---  END  ---
	}

	@BeforeTest
	@Parameters({"browser","DATA_PATH","SHEET","TESTCASES"})
	public void setUp(String browser,String DATA_PATH,String SHEET,int TESTCASES) throws Exception
	{
		browser = browser.toLowerCase();
		if (browser.equals("chrome"))
		{        
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new RuntimeException("No driver available for browser: " + browser);
		}

		CommonClass.BROWSER = browser; 
		CommonClass.DATA_PATH = DATA_PATH;
		CommonClass.SHEET = SHEET;
		CommonClass.TESTCASES = TESTCASES;

		System.out.println("DataPath "+DATA_PATH);
		System.out.println("Sheet "+DATA_PATH);

		action = new Actions(driver);
		wait = new WebDriverWait(driver, iWaitForElement);

		driver.manage().timeouts().implicitlyWait(iWaitForElement, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws Exception
	{
		// WebDriver will be closed
		System.out.println("Starting tear Down");
		driver.quit();
	}



}
