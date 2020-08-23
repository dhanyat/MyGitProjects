package seleniumTests;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ExcelreadandWrite {
	
	public void writetoExcel1(int rowCount, int colCount, String[][] tableValues) throws IOException{
	
		File file = new File("D:\\Automation\\Workspaces\\DBSAutomationChallenge\\src\\test\\java\\testData\\AutomationChallenge.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheet("Writing Table Values");
		
		for(int i=1;i<=rowCount;i++) {
			Row row = sheet.createRow(i-1);
			for(int j=1;j<=colCount;j++) {
				
				Cell cell = row.createCell(j-1);
				cell.setCellValue(tableValues[i-1][j-1]);
			}
			
		}
		 
		 FileOutputStream outputStream = new FileOutputStream(file);
		    wb.write(outputStream);
            outputStream.flush();
		    outputStream.close();
			
		    }

	
	public void writetoExcel2(String[] nameValues, String[] captionValues) throws IOException{
		
		File file =    new File("D:\\Automation\\Workspaces\\DBSAutomationChallenge\\src\\test\\java\\testData\\AutomationChallenge.xlsx");		
		FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet("Awards");
	    
		for(int j=1;j<=nameValues.length;j++) {
			Row row = sheet.getRow(j);
			if(row==null) continue;
			Cell cell = row.createCell(2);
			cell.setCellValue(nameValues[j-1]);
		}
		
		for(int k=1;k<=captionValues.length;k++) {
			Row row = sheet.getRow(k);
			if(row==null) continue;
			Cell cell = row.createCell(3);
			//System.out.println(captionValues[k-1]);
			cell.setCellValue(captionValues[k-1]);
		}
	    
		for(int i=1;i<=nameValues.length;i++) {
			Row row = sheet.getRow(i);
			if(row==null) continue;
			Cell expectedOutcome = row.getCell(0);
			String expectedOutcome1 = expectedOutcome.toString();
			Cell actualOutcome = row.getCell(2);
			String actualOutcome1 = actualOutcome.toString();
			if(expectedOutcome1==null) continue;
			Cell cell = row.createCell(4);
			
			if(actualOutcome1.equalsIgnoreCase(expectedOutcome1)) {
				cell.setCellValue("Yay, matched");
			}
			else {
				cell.setCellValue("Nope");
			}
		}
	
		for(int i=1;i<=captionValues.length;i++) {
			Row row = sheet.getRow(i);
			if(row==null) continue;
			Cell expectedOutcome =row.getCell(1);
			String expectedOutcome1 = expectedOutcome.toString();
			Cell actualOutcome = row.getCell(3);
			String actualOutcome1 = actualOutcome.toString();
			if(expectedOutcome1==null) continue;
			Cell cell = row.createCell(5);
			
			if(actualOutcome1.equalsIgnoreCase(expectedOutcome1)) {
				cell.setCellValue("Yay, matched");
			}
			else {
				cell.setCellValue("Nope");
			}
		}
	
	   
	      FileOutputStream fileOut = new FileOutputStream(file);	        
	    				wb.write(fileOut);
	    				fileOut.flush();
	    				fileOut.close();
	        
	     
		    }
		

	}


