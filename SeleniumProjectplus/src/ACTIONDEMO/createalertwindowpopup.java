package ACTIONDEMO;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class createalertwindowpopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "C:/sonal/chromedriver_win32/chromedriver.exe/");
		
		 WebDriver driver  = new ChromeDriver();
		 driver.get("https://docs.seleniumhq.org/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("alert('I have a call at 12:30.Lets Break for 20 minutes..is it ok?')");
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		 
		 driver.switchTo().alert().accept();
	}

}
