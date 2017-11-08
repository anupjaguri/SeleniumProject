//package wcTest;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class Test {
//	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		for(int i=1;i<20;i++) {
//			driver.get("https://www.wishingchair.in/");
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//			driver.findElement(By.xpath("(//a/div[contains(text(),'Sweet Home Wall Plate')])[2]")).click();
//			Thread.sleep(7000);
//			driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
//			Thread.sleep(5000);
//			
//			driver.get("https://www.wishingchair.in/checkout/cart/");
////			Actions act = new Actions(driver);
////			WebElement weCart = driver.findElement(By.xpath("//span[@class='cart-info visible-desktop']"));
////			WebElement weCart = driver.findElement(By.xpath("//span[@class='cart-info visible-desktop']"));
//			
//			driver.findElement(By.xpath("//button[@class='button btn-proceed-checkout btn-checkout']")).click();
////
////			
////			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/div[3]/div/a[1]/span")).click();
////			Thread.sleep(1000);
////			driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/div[3]/div/div/div/div[2]/a[1]")).click();
//			
//			Thread.sleep(5000);
//			String str = driver.findElement(By.xpath("//button[@id='checkout-guest']")).getText();
//			System.out.println("The value for iteration i ="+i+" is "+str);
//		}
//	}
//
//}
//
