package seleniumTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class E2E_Test {

	 private static WebDriver driver;
	 static ExcelreadandWrite erw = new ExcelreadandWrite();
		
	
	public static void main(String[] args) throws IOException {
			
		System.setProperty("webdriver.chrome.driver","D:\\Automation Softwares\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.dbs.com.sg/index/default.page");
		 driver.findElement(By.xpath("//p[@class ='dbs-group' ]/a/button")).click();
		 
		
		 driver.findElement(By.xpath("//div[@class='navbar-links-left'] //a[@data-node ='jwxuznof']")).click();
		 driver.findElement(By.xpath("//a[text() ='Creating Social Impact']")).click();
		
		 driver.findElement(By.xpath("//a[@href = '/sustainability/dbs-stronger-together-fund'] [text() = 'DBS Stronger Together Fund']")).click();
		 
		 WebElement element = driver.findElement(By.xpath("//span[text() = 'Singapore']"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;  
		 js.executeScript("arguments[0].scrollIntoView();",element);
	     //Web Table handling
		 
		  
		 
		WebElement table = driver.findElement(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table"));
		List<WebElement> rows = table.findElements(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table/tbody/tr"));
		int rowCount = rows.size();
		
		List<WebElement> cols = table.findElements(By.xpath("//div[@class = 'col-md-8 col-sm-8 left-content'] //table/tbody/tr[1]/td"));
		int colCount = cols.size();
		System.out.println(colCount);
		
		String beforeXpath_1 = "//div[@class = 'col-md-8 col-sm-8 left-content'] //table/tbody/tr[";
		String afterXpath_1 = "]/td[";
		String afterXpath_2 = "]";
		
       String[][] tableValues = new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++) {
			
			for(int j=1;j<=colCount;j++) {
				String actualXpath = beforeXpath_1+i+afterXpath_1+j+afterXpath_2;
				String value = table.findElement(By.xpath(actualXpath)).getText();
				tableValues[i-1][j-1] = value;
				
			}
			
		}
		
		erw.writetoExcel1(rowCount, colCount, tableValues);
		
	     
		
		 driver.findElement(By.xpath("//div[@class = 'navbar-links-left'] //a[text() = 'About']")).click();		 
		
		 driver.findElement(By.xpath("//a[text() = 'Who We Are']")).click();		 
		
		 driver.findElement(By.xpath("//a[text() = 'Our Awards & Accolades']")).click(); 
		 
		 List<WebElement> awards = driver.findElements(By.xpath("//div[@class = 'col-md-8']"));		 
		 
		 //Assert.assertEquals(22, awards.size());
		 Assert.assertEquals(22, awards.size(), "Total number of awards displying are"+awards.size() );
		 
		
		 List<WebElement> name = driver.findElements(By.xpath("//div[@class='col-md-8']/h3/Strong")); 
		 List<WebElement> caption = driver.findElements(By.xpath("//div[@class='col-md-8']/p"));
		 
		 int nameCount = name.size();
		 int captionCount = caption.size();
		 String[] nameValues = new String[name.size()];
		 String[] captionValues = new String[caption.size()];	 
		 int index = 0,index1 = 0;
 		 
		 for(int i=0,j=0; i<nameCount || j<captionCount; i++,j++)
		 {
			 String curName = name.get(i).getText();
			 nameValues[index++] = curName;
			 String curCaption = caption.get(j).getText();
			 captionValues[index1++] = curCaption;
			 
		 }
		 erw.writetoExcel2(nameValues,captionValues);
	
	 driver.quit();
	}
	
		
	
	}
