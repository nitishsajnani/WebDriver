package Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilty {
	
	public static void captureScreenshot(WebDriver Driver,String Screenshotname ) throws Exception
	{
		
		
		  
		  TakesScreenshot ts = (TakesScreenshot)Driver;
		  File source= ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(source,new File("./screenshots/"+Screenshotname+".png"));
		
	}
	}


