package ACTIONDEMO;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.glass.events.KeyEvent;



public class ROBOT {

	public static void main(String[] args) throws IOException, InterruptedException, Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "C:/sonal/chromedriver_win32/chromedriver.exe/");
		
		 WebDriver driver  = new ChromeDriver();
		 driver.get("https://postimages.org/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	

	
	
	//CREATING A SCREEN SHOT
	File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(srcFile, new File("C:\\temp\\Demo.png"));
	Thread.sleep(2000);
	
	//opying file to clipboard
	StringSelection copy = new StringSelection("C:\\temp\\Demo.png");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy,null);
	Thread.sleep(2000);
	
	//Pasting file path from clipboard like ctrl +v
	
	Robot robo=new Robot();
	
	robo.keyPress(KeyEvent.VK_CONTROL);
	robo.setAutoDelay(1000);
	
	robo.keyPress(KeyEvent.VK_V);
	robo.setAutoDelay(1000);
	
	robo.keyRelease(KeyEvent.VK_CONTROL);
	robo.setAutoDelay(1000);
	
	robo.keyRelease(KeyEvent.VK_V);
	robo.setAutoDelay(1000);
	
	robo.keyPress(KeyEvent.VK_ENTER);
	robo.setAutoDelay(1000);
	

	 System.out.println("Test is ok");
	
	driver.close();
	
	
	
	}
	 

}
