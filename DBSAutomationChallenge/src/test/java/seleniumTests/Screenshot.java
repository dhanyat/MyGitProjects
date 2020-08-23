package seleniumTests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	private WebDriver driver;
	String ssname;

	

	public Screenshot(WebDriver driver, String ssname) {
		this.driver = driver;
		this.ssname = ssname;
	}

	public void TakeScreenShot(WebDriver driver) throws Exception{
	
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh_mm_ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMM_d_H");
		String time = sdf.format(d);
		String hour = sdf1.format(d);
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("D:\\Automation\\Workspaces\\DBSAutomationChallenge\\\\target\\Screenshots\\"+hour+"\\"+ssname+time+".png");
		FileUtils.copyFile(screenshot, destination);
	}

}
