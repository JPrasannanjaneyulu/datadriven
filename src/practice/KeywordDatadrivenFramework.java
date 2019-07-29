package practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class KeywordDatadrivenFramework 
{
	public static void main(String[] args) throws BiffException, IOException 
	{
		//webdriver code:
		System.setProperty("webdriver.chrome.driver", "D:\\batch229\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		//dynamic wait:
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Open excel file for read
		File f=new File("KeywordMercuryToursTestData.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		System.out.println(Workbook.getVersion());
		Sheet rsh=rwb.getSheet(0);// 0 means sheet1
		int nor=rsh.getRows();// used rows count
		//Open excel file for write
		WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
		WritableSheet wsh=wwb.getSheet(0);//0 means sheet1
		//Data driven from 1st (2nd) row to last row
		//0th (1st) row have names of columns
		
		String firstName=rsh.getCell(0, 1).getContents();
		System.out.println(firstName);
			
		String lastName=rsh.getCell(1, 1).getContents();
		System.out.println(lastName);
			
		String phone=rsh.getCell(2, 1).getContents();
		System.out.println(phone);
			
		String email=rsh.getCell(3, 1).getContents();
		System.out.println(email);
			
		String address1=rsh.getCell(4, 1).getContents();
		System.out.println(address1);
			
		String address2=rsh.getCell(5, 1).getContents();
		System.out.println(address2);
			
		String city=rsh.getCell(6, 1).getContents();
		System.out.println(city);
			
		String state=rsh.getCell(7, 1).getContents();
		System.out.println(state);
			
		String postalCode=rsh.getCell(8, 1).getContents();
		System.out.println(postalCode);
			
		String country=rsh.getCell(9, 1).getContents();
		System.out.println(country);
			
		//enter data:
		driver.findElement(By.name("firstName")).sendKeys(firstName);
			
		driver.findElement(By.name("lastName")).sendKeys(lastName);
			
		driver.findElement(By.name("phone")).sendKeys(phone);
			
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email);
			
		driver.findElement(By.name("address1")).sendKeys(address1);
			
		driver.findElement(By.name("address2")).sendKeys(address2);
			
		driver.findElement(By.name("city")).sendKeys(city);
			
		driver.findElement(By.name("state")).sendKeys(state);
			
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);
			
		Select s=new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText(country);
	}
}
