package ACTIONDEMO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class datadriventesting {
	
	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException
	
	{
		
		 WebDriver driver;
			FileInputStream FRead;
			FileOutputStream FWrite;
			
			XSSFWorkbook wb;
			XSSFSheet sh;
			String d1,d2;
			String login; 
			String pwd;
			String wbmsg;
			String xlmsg;
			String pass= "Test is pass";
			String fail ="Test is fail";
			int rowval;
			int rowcount;
			
					
			
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "C:/sonal/chromedriver_win32/chromedriver.exe/");
		 driver  = new ChromeDriver();
		FRead=new FileInputStream("C:/sonal/testdata.xlsx"); 
		wb=new XSSFWorkbook(FRead);
		sh=wb.getSheetAt(0);
		//sh=wb.getSheet("Login");
		d1=sh.getRow(0).getCell(0).getStringCellValue();
		d2=sh.getRow(0).getCell(1).getStringCellValue();
		rowcount=sh.getPhysicalNumberOfRows();
			
		System.out.println(d1);
		System.out.println(d2);
		for(rowval=1;rowval<rowcount;rowval++)
		{
		login=sh.getRow(rowval).getCell(0).getStringCellValue();
		pwd=sh.getRow(rowval).getCell(1).getStringCellValue();
		xlmsg=sh.getRow(rowval).getCell(2).getStringCellValue();
		
		driver.get("http://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(500);
		driver.findElement(By.id("Email")).sendKeys(login);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Thread.sleep(1000);	
		wbmsg=driver.findElement(By.cssSelector("a.account")).getText();
		System.out.println(wbmsg);
		
		System.out.println("Login id used is " + login);
		System.out.println("Password used is " + pwd);
		System.out.println("The user name is "+ wbmsg);
		
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(1000);
		
		FWrite= new FileOutputStream("C:/sonal/testdata.xlsx");
		sh.getRow(rowval).createCell(3).setCellValue(wbmsg);
		
		if (wbmsg.equals(xlmsg))
			{
				System.out.println("Test is passed");
				sh.getRow(rowval).createCell(4).setCellValue(pass);
			}
			else
			{
				System.out.println("Test is failed");
				sh.getRow(rowval).createCell(4).setCellValue(fail);
		}
		wb.write(FWrite);
		}		
	driver.close();
	wb.close();
		 
	}

}


























