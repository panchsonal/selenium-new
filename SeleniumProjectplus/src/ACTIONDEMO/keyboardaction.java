package ACTIONDEMO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class keyboardaction {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver" , "C:/sonal/chromedriver_win32/chromedriver.exe/");
		
		 WebDriver driver  = new ChromeDriver();
		 driver.get("http://demowebshop.tricentis.com/desktops");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 WebElement search=driver.findElement(By.cssSelector("input[value='Search store']"));
		 
		 Actions actions = new Actions(driver);
		 
		 
		actions.keyDown(search,Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT).build().perform();
		 Thread.sleep(3000);
		 
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(3000);
		 
		 Assert.assertTrue(driver.getTitle().contains("Build your own computer"));
		
		 System.out.println("Test is ok");
		 driver.close();

	}

}

	