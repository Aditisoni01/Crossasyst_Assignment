package com.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericMethods 
{

	public static String getFileName()
	{
		DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		String datestring=format.format(date);
		return datestring;
	}
	
	public static String getScreenShot(String TestName,WebDriver driver) throws Exception
	{
		DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		String datestr=format.format(date);
		String filename=System.getProperty("user.dir")+"\\src\\test\\java\\com\\AP_Reports_Screenshot\\"+TestName+"_"+datestr+".jpg";
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File(filename));
          return filename;
	}
}
