package ACTIONDEMO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class FirstScript {
	
	static WebDriver driver;
	static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver" , "C:/sonal/chromedriver_win32/chromedriver.exe/");
	
		 WebDriver driver  = new ChromeDriver();
		 driver.get("http://demowebshop.tricentis.com/desktops");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 Actions act = new Actions(driver);
		 
		 
		 element=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
		 act.moveToElement(element).build().perform();
		 Thread.sleep(3000);
		 
		 element=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
		 act.moveToElement(element).click().build().perform();
		 Thread.sleep(3000);
		 
		 Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Desktops");		
		 System.out.println(driver.getTitle());
		 System.out.println("Test is passed");
		 driver.close();

	}

}
