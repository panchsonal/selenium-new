package ACTIONDEMO;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cookiescreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "C:/sonal/chromedriver_win32/chromedriver.exe/");
		
		 WebDriver driver  = new ChromeDriver();
		 driver.get("https://mail.rediff.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 Cookie TestCookie1 = new Cookie("UserName","TestUser");
		 		driver.manage().addCookie(TestCookie1);
				 Cookie TestCookie2 = new Cookie("Password","TestPassword");
			 		driver.manage().addCookie(TestCookie2);
			 		
			 		Set<Cookie> ck =driver.manage().getCookies();
			 		for (Cookie c:ck)
			 		{
			 			System.out.println("Name " +c.getName());
			 			System.out.println("Value " +c.getValue());
			 			System.out.println("Domain " +c.getDomain());
			 			System.out.println("Path " +c.getPath());
			 			System.out.println("Expires " +c.getExpiry());
			 		}
 		 		
	}

}
